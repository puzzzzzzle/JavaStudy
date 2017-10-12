package group.zhangtao.Socket.anotherStudy;

public class Mian {
    public static void main(String[] args) {
        ServerThread serverThread = ServerThread.getServerSocket();
        new Thread(serverThread).start();
    }
}
