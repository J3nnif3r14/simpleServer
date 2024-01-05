package org.zerock;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{


        ServerSocket   serverSocket = new ServerSocket(9000);
        System.out.println(serverSocket);


        Socket client = serverSocket.accept();
        System.out.println(client);

        InputStream inputStream = client.getInputStream();
        Scanner clientScanner  = new Scanner(inputStream);

        String line = clientScanner.nextLine();

        System.out.println(line);

    }
}