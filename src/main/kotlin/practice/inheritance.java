package practice;

class First {
    public void method() {
        System.out.println("First");
    }

    public void method2() {
        System.out.println("First method 2");
    }


}

class Second extends First {
    @Override
    public void method() {
        super.method();
        System.out.println("Second");
    }

    public void method3() {
        System.out.println("First method 3");
    }
}
public class inheritance {
    public static void main(String[] args) {
        First f = new Second();
        f.method2();
        f.method();
        ((Second) f).method3();
    }
}
