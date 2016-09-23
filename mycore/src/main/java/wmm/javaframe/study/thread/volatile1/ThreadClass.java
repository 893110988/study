package wmm.javaframe.study.thread.volatile1;

import wmm.javaframe.study.thread.ThreadLocal.ThreadLocalVal;

/**
 * Created by Administrator on 2016/9/21.
 */
public class ThreadClass extends Thread{

    @Override
    public void run() {


       // synchronized (ThreadClass.class){
            VolatileTest.a++;
       // }

       // System.out.println(VolatileTest.a);

    }
}
