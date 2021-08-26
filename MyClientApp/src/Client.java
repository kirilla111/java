import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {
    private static final int PORT = 7777;
    private static final String IP_ADDRESS = "127.0.0.1";
    private static Random rnd = new Random();

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(IP_ADDRESS, PORT);
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
            System.out.println("Connected to server");
            String request = "Hello my key: "+rnd.nextLong();

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response: "+response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
