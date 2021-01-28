package by.epam.tc;

import by.epam.tc.client.Client;
import by.epam.tc.server.Server;

public class Main {

    public static void main(String[] args) {
        new Server().run();
        Client.main(null);
    }
}
