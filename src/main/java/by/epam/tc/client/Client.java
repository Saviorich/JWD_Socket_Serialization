package by.epam.tc.client;

import by.epam.tc.dto.Request;
import by.epam.tc.dto.Response;
import by.epam.tc.entity.Text;
import by.epam.tc.reader.impl.TxtReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8000;

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(HOST, PORT);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        ) {
            String text = new TxtReader().readFile("src/main/resources/text.txt");

            Request request = new Request(text, 99);

            outputStream.writeObject(request);
            outputStream.flush();

            Response response = (Response) inputStream.readObject();

            Text parsedText = response.getText();
            Object result = response.getResult();

        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
    }
}
