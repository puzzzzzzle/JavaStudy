package group.zhangtao.Socket.anotherStudy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private int port = 8189;

    private ServerThread() {
        while (this.serverSocket == null){
            try {
                this.serverSocket = new ServerSocket(port);
            } catch (IOException e) {
//            e.printStackTrace();
                System.out.println("端口已被占用："+port+"自动加一");
                serverSocket =null;
                port++;
            }
        }

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private ServerSocket serverSocket = null;


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try{
                Socket socket = serverSocket.accept();
                Thread service = new Thread(new SocketServerTest(socket));
                service.start();
            } catch (IOException e) {
//                e.printStackTrace();
                serverSocket =null;
                return;
            }
        }
    }

    private static ServerThread serverThread = null;
    public static ServerThread getServerSocket(){
        if(serverThread==null){
            serverThread = new ServerThread();
        }
        return serverThread;
    }
}
