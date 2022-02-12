import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    ServerSocket serverSocket ;
    Socket socket;
    PrintStream printStream;
    DataInputStream dataInputStream;

    public server()
    {

        while (true)
        {
            try {
                serverSocket = new ServerSocket(5005);
                socket = serverSocket.accept();
                printStream = new PrintStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

}
