package group.zhangtao.single;

import static java.lang.Thread.sleep;

public class TestClass {

    private TestClass() {
        System.out.println("loader:" + this.toString());
    }

    public static TestClass getInstance() {
        return Horder.INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        sleep(3000);
        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 1000; i++) {
            System.out.println(TestClass.getInstance().toString());
        }
        System.out.println(System.currentTimeMillis());

    }

    private static class Horder {
        static TestClass INSTANCE = new TestClass();
    }
}
