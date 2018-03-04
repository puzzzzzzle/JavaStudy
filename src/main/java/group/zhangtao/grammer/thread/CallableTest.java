package group.zhangtao.grammer.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {

    public static void main(String[] args) {
        FutureTask<Integer> future = new FutureTask<>(new CallableTest());
        Thread thread = new Thread(future);
        thread.start();
        try {
            int result = future.get();
            System.out.println("wake up");
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        //模拟运行
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
        return (int) (Math.random() * 1000);
    }
}
