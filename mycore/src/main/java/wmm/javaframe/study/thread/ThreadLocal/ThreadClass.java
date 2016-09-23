package wmm.javaframe.study.thread.ThreadLocal;

/**
 * Created by Administrator on 2016/9/21.
 */
public class ThreadClass extends Thread{

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocalVal.y.set(this.getName());
        System.out.println(ThreadLocalVal.y.get());
    }
}
