package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/8/19.
 * 循环等待一定数目线程后执行线程
 */
public class MyCyclicBarrier {
    private static Log log = LogFactory.getLog(MyCyclicBarrier.class);

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier= new CyclicBarrier(3, new Runnable() {
            public void run() {
                log.info("wait--------------------");
            }
        });

        CyclicBarrierThread thread1=new CyclicBarrierThread("A1",cyclicBarrier);
        CyclicBarrierThread thread2=new CyclicBarrierThread("B1",cyclicBarrier);
        CyclicBarrierThread thread3=new CyclicBarrierThread("C1",cyclicBarrier);
        CyclicBarrierThread thread4=new CyclicBarrierThread("D1",cyclicBarrier);
        CyclicBarrierThread thread5=new CyclicBarrierThread("A2",cyclicBarrier);
        CyclicBarrierThread thread6=new CyclicBarrierThread("B2",cyclicBarrier);
        CyclicBarrierThread thread7=new CyclicBarrierThread("C2",cyclicBarrier);
        CyclicBarrierThread thread8=new CyclicBarrierThread("D2",cyclicBarrier);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }
}
