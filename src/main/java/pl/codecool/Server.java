package pl.codecool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Starting TCP server");
        ServerSocket serverSocket = null;
        int port = 1324;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("TCP server created on port " + port);
        } catch (IOException e) {
            System.out.println("ERROR: unable to start TCP server on port " + port);
        }

        while (true) {
            Socket clientSocket = null;
            try {
                System.out.println("TCP server waiting for incoming request");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("ERROR: TCP server cannot accept client request.");
            }

            try {
                processClientRequest(clientSocket);
            } catch (IOException e) {
                System.out.println("ERROR: while processing client request.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void processClientRequest(Socket clientSocket) throws IOException, ClassNotFoundException {
        System.out.println("Processing incoming request");
        InputStream inputStream = clientSocket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        MyValueObject object = (MyValueObject) objectInputStream.readObject();
        System.out.println(object.toString());
        object.setValue(50);
        OutputStream outputStream = clientSocket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();

    }
}
