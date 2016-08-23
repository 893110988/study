package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/8/19.
 * 循环等待一定数目线程后执行线程
 *
 * CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 * CyclicBarrier        : N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
 这样应该就清楚一点了，对于CountDownLatch来说，重点是那个“一个线程”, 是它在等待，
 而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。而对于CyclicBarrier来说，
 重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。

 CountDownLatch 是计数器, 线程完成一个就记一个, 就像 报数一样, 只不过是递减的.
 而CyclicBarrier更像一个水闸, 线程执行就想水流, 在水闸处都会堵住, 等到水满(线程到齐)了, 才开始泄流.
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
