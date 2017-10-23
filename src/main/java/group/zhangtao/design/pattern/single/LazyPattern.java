package group.zhangtao.design.pattern.single;

import static java.lang.Thread.sleep;

public class LazyPattern {
    private LazyPattern() {
        System.out.println("Lazy Pattern init, time:"+System.currentTimeMillis());
    }

    private static LazyPattern instance = null;

    public static LazyPattern getInstance() {
        if (instance == null) {
            instance = new LazyPattern();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        sleep(1000);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(LazyPattern.getInstance().toString())).start();
        }
    }
}
