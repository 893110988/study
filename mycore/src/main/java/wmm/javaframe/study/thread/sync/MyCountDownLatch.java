package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.CountDownLatch;


/**
 * Created by Administrator on 2016/8/19.
 * 当阻塞的线程个数到达一定量后  所有的线程一起执行
 */
public class MyCountDownLatch {
    private static Log log = LogFactory.getLog(MyCountDownLatch.class);
    public static void main(String[] args) {
        CountDownLatch countDownLatch= new CountDownLatch(3);

        CountDownLatchThread thread1=new CountDownLatchThread("A",countDownLatch);
        CountDownLatchThread thread2=new CountDownLatchThread("B",countDownLatch);
        CountDownLatchThread thread3=new CountDownLatchThread("C",countDownLatch);
        CountDownLatchThread thread4=new CountDownLatchThread("D",countDownLatch);
        CountDownLatchThread thread5=new CountDownLatchThread("E",countDownLatch);
        CountDownLatchThread thread6=new CountDownLatchThread("F",countDownLatch);
        CountDownLatchThread thread7=new CountDownLatchThread("G",countDownLatch);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        for (int i=0;i<7;i++){
            try {
                Thread.sleep(1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
