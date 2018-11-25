import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 * CLIENT SHOULD BE COMPILED AND RAN AFTER SERVER.
 * Client creates a new socket and establishes a connection with server. Gets user input from command line (filename) and
 * sends the filename over to the server. The server retrieves that data and sends it back to the client, which is then printed.
 */
class Client{

    public static void main(String args[])throws Exception{

        final int PORT = 5000;
        final String HOST = "localhost";

        Socket socket = new Socket(HOST, PORT);
        System.out.println("Established connection on port " + PORT);

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the full path of your file (Example -- C:\\Users\\Marc.MARC-PC\\IdeaProjects\\mmshepherd_swd\\oral_exam2\\28-13_FileRetrieve\\brothers.txt");

        //Get client input and send filename over to server to retrieve
        String fileName=br.readLine();
        output.writeUTF(fileName);

        //Retrieve content from server
        try {
            InputStream istream = socket.getInputStream();
            InputStreamReader istreamReader = new InputStreamReader(istream);
            BufferedReader breader = new BufferedReader(istreamReader);

            String fileContent = "";

            while (breader.readLine() != null) {
                fileContent += breader.readLine() + "\n";
            }
            System.out.println(fileContent);
        } catch (Exception ex) {System.err.println("FILE NOT FOUND");}

        //closing connections
        output.close();
        socket.close();
    }
}