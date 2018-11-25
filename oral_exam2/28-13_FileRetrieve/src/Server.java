import java.net.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * START SERVER FIRST, THEN CLIENT.
 * Server begins by listening for a client socket, and accepts the connection when one is found. This allows for communication
 * between client and server. The <code>DataInputStream</code> instance <code>input</code> allows the server to read in
 * data (command-line-input) from the client. As seen below, the <code>input.readUTF()</code> does this. We create a file input stream
 * and reads the file, which is then read into a buffer. That buffer is made into a string <code>fileContent</code> and
 * thrown into the bufferedWriter, which is then written and flushed back to the client.
 */
class Server{

    public static void main(String args[]){

        try{
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Listening...");
            Socket socket = server.accept();
            System.out.println("Accepted.");

            DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String filepath = input.readUTF();
            File file = new File(filepath);

            if (file.exists() && file.canRead()) {
                FileInputStream fin = new FileInputStream(file);

                byte[] buffer = new byte[fin.available()];

                fin.read(buffer); //Read file contents into buffer

                String fileContent = new String(buffer); //Create a string out of buffer

                //Sending contents of file back to client
                OutputStream ostream = socket.getOutputStream();
                OutputStreamWriter ostreamWriter = new OutputStreamWriter(ostream);
                BufferedWriter bwriter = new BufferedWriter(ostreamWriter);
                bwriter.write(fileContent);
                bwriter.flush();

                //Closing all connections
                input.close();
                socket.close();
                server.close();
            }

            else {
                System.err.println("FILE NOT FOUND");}

        } catch(Exception ex){}
    }
}