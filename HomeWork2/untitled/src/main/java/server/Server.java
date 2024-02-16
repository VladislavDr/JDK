package server;


import client.Client;

public class Server {
    private final ClientListener listener;
    private boolean isConnection;
    public Server(){
        this.listener = new ServerWindow();
    }

    public boolean connectUser(Client client) {
        if (listener.connectUser(client)){
            isConnection = true;
            return true;
        } else return false;
    }

    public void disconnectUser(Client client) {
        if (isConnection){
            listener.disconnectUser(client);
            isConnection = false;
        }
    }

    public void sendMessage(String text) {
        if (!isConnection){
            return;
        } else {
            listener.sendMessage(text);
        }
    }

    public String getHistory(){
        return listener.getHistory();
    }
}
