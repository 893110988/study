package wmm.javaframe.study.thread.sync;

import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2016/8/19.
 * 不正规的长途汽车站会等待座位坐满之后才发车，到达目的地之后继续等待然后循环进行。
 * 每个人都是一个Thread，上车后触发cyclicBarrier.await();，当坐满时就是达到指定达成数的时候，
 * 车辆发车就是达成后统一执行的内容，发车后车上的人们就可以聊天之类的操作了。
 */
public class MySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore= new Semaphore(3);

        SemaphoreThread thread1=new SemaphoreThread("A",semaphore);
        SemaphoreThread thread2=new SemaphoreThread("B",semaphore);
        SemaphoreThread thread3=new SemaphoreThread("C",semaphore);
        SemaphoreThread thread4=new SemaphoreThread("D",semaphore);
        SemaphoreThread thread5=new SemaphoreThread("E",semaphore);
        SemaphoreThread thread6=new SemaphoreThread("F",semaphore);
        SemaphoreThread thread7=new SemaphoreThread("G",semaphore);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
