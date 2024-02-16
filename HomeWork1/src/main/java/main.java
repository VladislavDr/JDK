import client.ClientGUI;
import serverChat.Server;

public class main {
    public static void main(String[] args) {
        Server server = new Server();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
