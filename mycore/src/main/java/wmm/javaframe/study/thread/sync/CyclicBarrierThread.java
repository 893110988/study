package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/8/22.
 */
public class CyclicBarrierThread extends Thread{

    private static Log log = LogFactory.getLog(CyclicBarrierThread.class);

    private String name;

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(String name,  CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        log.info("start----------:"+this.name+System.currentTimeMillis());
        try {
            cyclicBarrier.await();
            log.info("doing----------:"+this.name+System.currentTimeMillis());
            Thread.sleep(10);
            log.info("over----------:"+this.name+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
