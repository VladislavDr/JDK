import Client.ClientWindow;
import ServerChat.WindowServer;

public class main {
    public static void main(String[] args) {
        WindowServer windowServer = new WindowServer();
        new ClientWindow(windowServer);
        new ClientWindow(windowServer);
    }
}
