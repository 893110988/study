package wmm.javaframe.study.classload;

/**
 * 类加载顺序.
 */
public class Base {
    public static int t = baseStaticMethod();
    static {
        t=111;
        System.out.println("父类静态代码块 ");
    }


    public static int baseStaticMethod() {
        System.out.println("父类静态属性");
        return 0;
    }

    {
        System.out.println("父类非静态代码块");
    }



    public static void method() {
        System.out.println("父类静态方法");
    }

    public Base() {
        System.out.println("父类构造方法");
    }
}
