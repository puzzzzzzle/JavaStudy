package group.zhangtao.thread;

import java.util.concurrent.*;

public class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //模拟运行
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
        return (int)(Math.random()*1000);
    }

    public static void main(String[] args) {
        FutureTask<Integer> future = new FutureTask<>(new CallableTest());
        Thread thread   = new Thread(future);
        thread.run();
        try {
            Thread.sleep(5000);
            System.out.println("wake up");
            long time =System.currentTimeMillis();
            System.out.println(future.get());
            System.out.println("get time:"+(System.currentTimeMillis()-time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
