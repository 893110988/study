package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/8/19.
 * 达到一定的容量后就不允许运行新的东西了
 */
public class SemaphoreThread extends Thread{
    private Log log= LogFactory.getLog(SemaphoreThread.class);
    private String name;

    private Semaphore semaphore;



    public SemaphoreThread(String name,Semaphore semaphore) {
        this.name=name;
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            log.info("准备-------："+this.name+ System.currentTimeMillis());
            semaphore.acquire();
            log.info("doing-------："+this.name+ System.currentTimeMillis());
            this.sleep(1000);
            log.info("结束--------："+this.name+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
