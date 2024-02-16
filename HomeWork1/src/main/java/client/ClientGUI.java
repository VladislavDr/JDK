package client;

import serverChat.Server;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientGUI extends JFrame implements ClientView{
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 250;
    public JTextArea LOG_CLIENT = new JTextArea();
    private JTextField name, textMessage;
    private static List<String> LST_MESSAGES = new ArrayList<>();
    private static List<String> LOGINS_USERS = List.of("Влад", "Вика");
    private Client client;
    private boolean isWorkServer;
    private Server server;


    public ClientGUI(Server server) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("client");
        setResizable(true);

        setLocation(getX() + getX() / 2, getY() - WINDOW_HEIGHT / 2);

        createPanel();

        setSize(350, 250);
        setVisible(true);
        client = new Client(server, this);
    }
    public void createPanel(){
        add(btnLogin(LOGINS_USERS), BorderLayout.NORTH);
        add(LOG_CLIENT, BorderLayout.CENTER);
        add(btnTextMessage(), BorderLayout.SOUTH);
    }

    public Component btnTextMessage() {
        JPanel downPanel = new JPanel(new GridLayout(1, 1));
        textMessage = new JTextField(20);
        textMessage.setToolTipText("Текст сообщений");
        textMessage.addActionListener(e -> {
            sendMessage();
            textMessage.setText("");
        });
        downPanel.add(textMessage);
        return downPanel;
    }

    public Component btnLogin(List<String> lstLogin) {
        name = new JTextField("", 10);
        name.setToolTipText("Имя");
        JPasswordField password = new JPasswordField("", 10);
        password.setEchoChar('*');

        JButton btnLog = new JButton("Login");
        btnLog.addActionListener(e -> {
            setVisible(true);
            LOG_CLIENT.append("Успешно авторизовано!");
        });
        JPanel upPanel = new JPanel(new GridLayout(1, 3));
        upPanel.add(name);
        upPanel.add(password);
        upPanel.add(btnLog);

        return upPanel;
    }

    public void readFile() {
        FileReader reader;
        try {
            reader = new FileReader("logs.txt");
            LOG_CLIENT.read(reader, "logs.txt");
            System.out.println(LOG_CLIENT.getText());
        } catch (IOException e) {
            System.err.printf(String.valueOf(e));
        }
    }

    public void textArea(List<String> text, Server win) {
        for (String word : text) {
            win.LOG_SERVER.append(word);
            LOG_CLIENT.append(word);
        }
        readFile(win.LOG_SERVER.getText());
        pack();
    }

    public void textArea(String text, Server win) {
        win.LOG_SERVER.append(name.getText() + ": " + text);
        LOG_CLIENT.append(name.getText() + ": " + text);

        readFile(name.getText() + ": " + text);
        pack();
    }

    public void readFile(String text) {
        File file = new File("logs.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(text + " ");
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
    }

    public void existenceCheck(String name) {
        if (LST_MESSAGES.contains(this.name.getText())) {
            return;
        } else {
            LOG_CLIENT = new JTextArea();
        }
    }

    @Override
    public void sendMessage() {
        LOG_CLIENT.append(textMessage.getText());
        LOG_CLIENT.append("\n");
    }

    @Override
    public void connected() {

    }
    @Override
    public void disconnected(){

    }
}
