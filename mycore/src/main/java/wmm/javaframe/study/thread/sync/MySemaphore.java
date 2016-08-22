package wmm.javaframe.study.thread.sync;

import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2016/8/19.
 * 3个窗口取号刚开始人来了有位置大于三个后就开始排队处理一个来一个。
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
