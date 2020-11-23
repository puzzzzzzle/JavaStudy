package group.zhangtao.design.pattern.observer;

public class Main {
    public static void main(String[] args) {

        Subject subject = new Subject();
        new MyObserver(subject);
        new AnotherObserver(subject);
        System.out.println("change stat : 10");
        subject.setState(10);
        System.out.println("change stat : 20");
        subject.setState(20);
    }
}
