package serverChat;

import client.Client;

public interface ClientListener {
    void onConnection(Client client);
    void onDisconnected(Client client);
//    void onReceiving(Client client, String text);
void onReceiving( String text);
}
