package santaTecla.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.types.FrameType;

public class TCPIP {

    private final static int PORT = 9001;

    private ServerSocket serverSocket;

    private Socket socket;

    private PrintWriter out;

    private BufferedReader in;

    public TCPIP(Socket socket) {
        this.serverSocket = null;
        this.socket = socket;
        try {
            this.out = new PrintWriter(socket.getOutputStream());
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        this(socket);
        this.serverSocket = serverSocket;
    }

    public void send(FrameType frameType) {
        send(frameType.name());
    }

    public void send(StateValue stateValue) {
        send(stateValue.toString());
    }

    public void send(Error error) {
        send(error == null ? null : error.toString());
    }

    public void send(String value) {
        this.out.println(value);
        this.out.flush();
    }

    public void send(int value) {
        this.send("" + value);
        
    }

    public void send(boolean value) {
        this.send("" + value);
    }
    public void send(List<Color> colors) {
        for (Color color : colors) {
            send(color.toString());
        }
        send("");
    }
    
    public void send(String[] stringItems) {
        for (String item : stringItems) {
            send(item);
        }
        send("");
    }
    public String receiveLine() {
        String result = null;
        try {
            result = this.in.readLine();
        } catch (IOException e) {
            System.out.println("Error on server!!! reading line");
        }
        return result;
    }

    public boolean receiveBoolean() {
        boolean result = false;
        try {
            result = Boolean.parseBoolean(this.in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int receiveInt() {
        int result = -1;
        try {
            result = Integer.parseInt(this.in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Color> receiveColors() {
        List<Color> result = new ArrayList<Color>();
        String line = receiveLine();
        while (line != null && !line.equals("")) {
            result.add(Color.valueOf(line));
            line = receiveLine();
        }

        return result;
    }

    public List<String> receiveStringArray() {
        List<String> result = new ArrayList<String>();
        String line = receiveLine();
        while (line != null && !line.equals("")) {
            result.add(line);
            line = receiveLine();
        }
        return result;
    }

    

    public StateValue receiveStateValue() {
        String state = this.receiveLine();
        if (state == null || (state != null && state.equals("null"))) {
            return null;
        }
        return StateValue.valueOf(state);
    }

    public Error receiveError() {
        String error = this.receiveLine();
        if (error == null || (error != null && error.equals("null"))) {
            return null;
        }
        return Error.valueOf(error);
    }

    public void close() {
        try {
            this.in.close();
            this.out.close();
            this.socket.close();
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static TCPIP createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server> Waiting...");
            Socket socket = serverSocket.accept();
            System.out.println(String.format("Server> new connection from: %s:%d",
                    socket.getInetAddress().getHostAddress(), socket.getPort()));
            return new TCPIP(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static TCPIP createClientSocket() {
        try {
            Socket socket = new Socket("localhost", PORT);
            System.out.println("Client> conencted!!! :)");
            return new TCPIP(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
