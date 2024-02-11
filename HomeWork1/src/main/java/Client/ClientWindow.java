package Client;

import ServerChat.WindowServer;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 250;
    public JTextArea LOG_CLIENT = new JTextArea(10, 30);
    private JTextField NAME, TEXT_MESSAGE;
    private static List<String> LST_MESSAGES = new ArrayList<>();
    private static List<String> LOGINS_USERS = List.of("Влад", "Вика");
    private static final String STILL_OFF = "Сервер еще не запущен";


    public ClientWindow(WindowServer windowServer) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setLocationRelativeTo(null);
            setTitle("Client");
            setResizable(true);

        setLocation(getX() + getX()/2 , getY() - WINDOW_HEIGHT / 2);

            TEXT_MESSAGE = new JTextField(20);
            TEXT_MESSAGE.setToolTipText("Текст сообщений");
            TEXT_MESSAGE.addActionListener(e -> {
                if (windowServer.IS_SERVER_WORK) {
                    String text = TEXT_MESSAGE.getText() + "\n";
                    textArea(text, windowServer);
                    TEXT_MESSAGE.setText("");
                } else windowServer.showWarning(STILL_OFF);
            });

            JPanel downPanel = new JPanel(new GridLayout(1, 1));
            downPanel.add(TEXT_MESSAGE);

            add(btnLogin(LOGINS_USERS), BorderLayout.NORTH);
            add(LOG_CLIENT, BorderLayout.CENTER);
            add(downPanel, BorderLayout.SOUTH);

            setSize(350, 250);
            setVisible(true);
    }
    public Component btnLogin(List<String> lstLogin){
        NAME = new JTextField("", 10);
        NAME.setToolTipText("Имя");
        JPasswordField password = new JPasswordField("",10);
        password.setEchoChar('*');

        JButton btnLog = new JButton("Login");
        btnLog.addActionListener(e -> {
            setVisible(true);
            for (String log :lstLogin) {
                if (NAME.getText().equals(log)){
                    readFile();
                    System.out.println("Совпало");
                }
            }
        });
        JPanel upPanel = new JPanel(new GridLayout(1, 3));
        upPanel.add(NAME);
        upPanel.add(password);
        upPanel.add(btnLog);
        return upPanel;
    }
    public void readFile(){
        FileReader reader;
        try {
            reader = new FileReader("logs.txt");
            LOG_CLIENT.read(reader, "logs.txt");
            System.out.println(LOG_CLIENT.getText());
        } catch (IOException e) {
            System.err.printf(String.valueOf(e));
        }
    }

    public void textArea(List<String> text, WindowServer win) {
        for (String word : text) {
            win.LOG_SERVER.append(word);
            LOG_CLIENT.append(word);
        }
        addTextChat(win.LOG_SERVER.getText());
        pack();
    }

    public void textArea(String text, WindowServer win) {
        win.LOG_SERVER.append(NAME.getText() + ": " + text);
        LOG_CLIENT.append(NAME.getText() + ": " + text);

        addTextChat(NAME.getText() + ": " + text);
        pack();
    }

    public void addTextChat(String text) {
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

    public void existenceCheck(String name){
        if(LST_MESSAGES.contains(NAME.getText())){
            return;
        } else {
            LOG_CLIENT = new JTextArea();
        }
    }

}
