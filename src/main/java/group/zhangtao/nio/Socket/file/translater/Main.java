package group.zhangtao.Socket.file.translater;

public class Main {
    public static void main(String[] args) {
        new Thread(new Sender("./testOut.zip", "127.0.0.1", 8189)).start();
    }
}
