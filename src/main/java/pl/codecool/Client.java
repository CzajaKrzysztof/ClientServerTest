package pl.codecool;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1324);
            System.out.println("Connected");
            ObjectOutputStream oOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream oInputStream = new ObjectInputStream(socket.getInputStream());
            MyValueObject myObject = new MyValueObject("MyObject", 5);
            System.out.println(myObject.toString());
            oOutputStream.writeObject(myObject);
            myObject = (MyValueObject) oInputStream.readObject();
            System.out.println(myObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
