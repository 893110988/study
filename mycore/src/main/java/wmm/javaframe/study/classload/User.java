package wmm.javaframe.study.classload;

/**
 * Created by admin on 2016/9/15.
 */
public class User extends Base{
    public static int t = userStaticMethod();

    public static int userStaticMethod() {
        System.out.println("子类静态属性");
        return 0;
    }

    {
        System.out.println("子类非静态代码块");
    }

    static {
        System.out.println("子类静态代码块 ");
    }

    public static void method() {
        System.out.println("子类静态方法");
    }

    public User() {
        System.out.println("子类构造方法");
    }

}
