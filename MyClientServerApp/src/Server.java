import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7777)) {

            System.out.println("App launched..");
            while (true)
                try (
                        Socket socket = serverSocket.accept();
                        BufferedWriter writer =
                                new BufferedWriter(
                                        new OutputStreamWriter(
                                                socket.getOutputStream()));
                        BufferedReader reader =
                                new BufferedReader(
                                        new InputStreamReader(
                                                socket.getInputStream()
                                        )
                                )
                ) {
                    System.out.println("New client connected!");

                    String request = reader.readLine();
                    System.out.println(request);

                    writer.write("Hello from Server");
                    writer.newLine();
                    writer.flush();



                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
