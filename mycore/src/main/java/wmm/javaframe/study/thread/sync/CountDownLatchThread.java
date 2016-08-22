package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/8/19.
 */
public class CountDownLatchThread extends Thread {
    private Log log = LogFactory.getLog(CountDownLatchThread.class);
    private String name;
    private CountDownLatch countDownLatch;

    public CountDownLatchThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            log.info("准备-------："+this.name+ System.currentTimeMillis());
            countDownLatch.await();
            log.info("doing-------："+this.name+ System.currentTimeMillis());
            log.info("结束--------："+this.name+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
