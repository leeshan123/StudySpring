package hello.core.singleton;

public class SingletonService {

    //스태틱으로 선언해버림
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //문제 발생 마음대로 만들 수 있음 그래서 private으로 만들어서 다른 곳에서 마음대로 생성 못하게 막음.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {

//        SingletonService singletonService1 = new SingletonService();
//        SingletonService singletonService2 = new SingletonService();
    }



}
