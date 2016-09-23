package wmm.javaframe.study.thread.ThreadLocal;

/**
 * 是一个隔离的线程变量，为map类型，key值为当前线程，put的时候先拿到当前线程，判断有没有值有的话覆盖没有的话存入
 * 每一个线程都会初始化一个ThreadLocal对象
 */
public class ThreadLocalTest {



    public static void main(String[] args) {
        for (int i =10;i!=0;i--){
            ThreadClass c=new ThreadClass();
            c.setName(i+"");
            c.start();
        }


    }

}
