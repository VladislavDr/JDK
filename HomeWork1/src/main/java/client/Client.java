package client;

import serverChat.Server;


public class Client {
    private ClientView view;
    private String name;
    private Server server;
    private boolean connection;
    public Client(Server server, ClientView view){
        this.server = server;
        this.view = view;
    }

    public boolean isConnection(String name){
        this.name = name;
        if (server.IS_SERVER_WORK){
            connectedToServer(name);
            System.out.println("Успешно подключились!");
            connection = true;
            return true;
        } else {
            System.out.println("Не удалось подключиться");
            return false;
        }
    }

    public void connectedToServer(String name){
        this.name = name;
        server.onConnection(this);
        connection = true;
    }
    public void disconnected(){
        server.onDisconnected(this);
        connection = false;
    }
    public void sendMessage(String text){
        if (connection){
            server.onReceiving(name + ": " + text);
        }
    }

}
