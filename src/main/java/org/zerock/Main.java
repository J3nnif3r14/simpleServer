package org.zerock;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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
        OutputStream out = client.getOutputStream();

        Scanner clientScanner  = new Scanner(inputStream);

        String line = clientScanner.nextLine();

        System.out.println(line);

        String msg ="<h1>Hello World</h1>";

        out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
        out.write(new String("Cache-Control: private\r\n").getBytes());
        out.write(new String("Content-Length:"+msg.getBytes("UTF-8").length+"\r\n").getBytes());
        out.write(new String("Content-Type: text/html;charset=UTF-8\r\n\r\n").getBytes());

        out.write(msg.getBytes(StandardCharsets.UTF_8));

    }
}


