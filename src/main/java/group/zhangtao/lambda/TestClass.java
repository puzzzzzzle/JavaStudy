package group.zhangtao.lambda;

public class TestClass implements Runnable {
    Introduce introduce = null;

    public TestClass(Introduce introduce) {
        this.introduce = introduce;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(introduce.introduce());
        }
    }

    public static void main(String[] args) {
        new Thread(new TestClass(new Introduce() {
            @Override
            public String introduce() {
                return "tao";
            }
        }));
        Introduce introduce = () -> "hello";
        System.out.println(introduce.introduce());
        System.out.println();
        new Thread(new TestClass(() -> {
            return "tao";
        }));
        new Thread(new TestClass(() -> "tao"));


    }
}
