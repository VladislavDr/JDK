package server;



import client.Client;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame implements ClientListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String LOG_PATH =
            "C:\\Users\\79509\\Desktop\\Java Devepoler KIT\\Homework\\HomeWork2\\untitled\\src\\main\\java\\server\\log.txt";

    private List<Client> clientList;

    private JButton btnStart, btnStop, btnExit;
    private JTextArea log;
    private boolean work;

    public ServerWindow() {
        clientList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }
    private void answerAll(String text) {
        for (Client client : clientList) {
            client.answerFromServer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getHistory() {
        return readLog();
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnExit = new JButton("Exit");

        btnStart.addActionListener(e -> {
            if (work) {
                appendLog("Сервер уже был запущен");
            } else {
                work = true;
                appendLog("Сервер запущен!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!work) {
                appendLog("Сервер уже был остановлен");
            } else {
                work = false;
                while (!clientList.isEmpty()) {
                    disconnectUser(clientList.get(clientList.size() - 1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        btnExit.addActionListener(e -> System.exit(0));


        panel.add(btnStart);
        panel.add(btnStop);
        panel.add(btnExit);
        return panel;
    }

    @Override
    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        } else {
            clientList.add(client);
            return true;
        }
    }

    @Override
    public void disconnectUser(Client client) {
        if (!work) {
            return;
        } else {
            clientList.remove(client);
            if (client != null) {
                client.disconnectFromServer();
            }
        }
    }

    @Override
    public void sendMessage(String text) {
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }
}