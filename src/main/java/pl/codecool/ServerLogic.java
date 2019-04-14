package pl.codecool;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerLogic {
    private int number;

    private ServerSocket serverSocket;
    private Scanner scanner;
    private PrintStream printStream;

    public ServerLogic() throws IOException {
        serverSocket = new ServerSocket(1342);

        number = scanner.nextInt();
    }

    public Socket createClientSocket() throws IOException {
        return serverSocket.accept();
    }

    public void processClientRequest(Socket socket) throws IOException {
        scanner = new Scanner(socket.getInputStream());
        printStream = new PrintStream(socket.getOutputStream());
    }
    public void returnCalculation() {
        printStream.println(calculate());
        printStream.flush();
    }

    public int calculate() {
        return number * 2;
    }
}
