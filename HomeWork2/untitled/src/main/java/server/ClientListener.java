package server;


import client.Client;

public interface ClientListener {
    boolean connectUser(Client client);
    void disconnectUser(Client client);
    void sendMessage(String text);
    String getHistory();
}
