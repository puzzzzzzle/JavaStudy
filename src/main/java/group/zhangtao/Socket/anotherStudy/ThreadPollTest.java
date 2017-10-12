package group.zhangtao.Socket.anotherStudy;

import sun.nio.ch.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public final class ThreadPollTest implements Runnable {
    private int port = 8189;

    private ThreadPollTest() {
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
    private ThreadPool threadPool = null;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try{
                Socket socket = serverSocket.accept();
                BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,100,3, TimeUnit.MINUTES,workQueue);


// threadPool = new ThreadPool(,false,10);
            } catch (IOException e) {
//                e.printStackTrace();
                serverSocket =null;
                return;
            }
        }
    }

    public static ThreadPollTest getServerThread() {
       if(serverThread == null){
           serverThread = new ThreadPollTest();
       }
        return serverThread;
    }
    private static ThreadPollTest serverThread = null;
}
