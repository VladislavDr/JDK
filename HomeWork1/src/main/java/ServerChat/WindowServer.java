package ServerChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WindowServer extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 250;
    private JButton btnStart, btnStop, btnExit;
    public boolean IS_SERVER_WORK;
    public final JTextArea LOG_SERVER = new JTextArea(10, 30);
    private static final String ALREADY_ENABLE = "Сервер уже запущен.";
    private static final String STILL_OFF = "Сервер еще не запущен";


    public WindowServer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat server");
        setResizable(false);
        IS_SERVER_WORK = false;

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnExit = new JButton("Exit");

        setLocation(getX() - WINDOW_WIDTH / 2, getY() - WINDOW_HEIGHT / 2);

        btnStart.addActionListener(e -> {
            setVisible(true);
            if (IS_SERVER_WORK) {
                System.out.println("Сервер уже запущен"); //TODO доделать нужно!
                showWarning(ALREADY_ENABLE);
                return;
            }
            IS_SERVER_WORK = true;
            System.out.println("Server start...");
        });

        btnStop.addActionListener(e -> {
            if (!IS_SERVER_WORK){
                System.out.println("Сервер еще не запущен"); //TODO доделать нужно!
                showWarning(STILL_OFF);
                return;
            }
            IS_SERVER_WORK = false;
            System.out.println("Server stop!");
        });
        btnExit.addActionListener(e -> System.exit(0));

        JPanel mainPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(btnStart);
        mainPanel.add(btnStop);
        mainPanel.add(btnExit);
        add(mainPanel, BorderLayout.SOUTH);
        add(LOG_SERVER, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void addTextChat(String text) {
        File file = new File("logs.txt");

        {
            try {
                FileWriter fw = new FileWriter(file, true);
                fw.write(text + "");
                fw.flush();
            } catch (IOException e) {
                System.out.println("Ошибка записи файла");
            }
        }
    }
    public static List<String> readTextChat(){
        List<String> content = null;
        try {
            content = Files.readAllLines(Paths.get("notes.txt"));
        } catch (IOException e) {
            System.out.println("Error");
        }
        return content;
    }
//    public void textArea(String text){
//        getContentPane().add(LOG_SERVER, BorderLayout.CENTER);
//        addTextChat(String.valueOf(LOG_SERVER));
//        pack();
//    }
    public void showWarning(String text){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JLabel jl = new JLabel(text, SwingConstants.CENTER);
        getContentPane().add(jl);
        pack();
    }
}
