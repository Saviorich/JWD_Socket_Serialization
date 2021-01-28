package by.epam.tc.server;

import by.epam.tc.dto.Request;
import by.epam.tc.dto.Response;
import by.epam.tc.entity.Text;
import by.epam.tc.parser.impl.ProgrammingBookParser;
import by.epam.tc.service.ActionHandler;
import by.epam.tc.service.TextService;
import by.epam.tc.service.impl.TextActionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {
    public static final int PORT = 8000;

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept();
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ) {
                    Request request = (Request) inputStream.readObject();

                    String text = request.getText();
                    int actionNumber = request.getAction();

                    Text parsedText = new ProgrammingBookParser().parse(text);

                    Response response = new Response();
                    response.setText(parsedText);

                    TextService service = new TextService(parsedText);
                    ActionHandler actionHandler = new TextActionHandler(service);

                    response.setResult(actionHandler.getActionResult(actionNumber));

                    outputStream.writeObject(response);
                    outputStream.flush();
                }
            }
        } catch (IOException | NullPointerException | ClassNotFoundException e) {
            logger.error(e);
        }
    }
}
