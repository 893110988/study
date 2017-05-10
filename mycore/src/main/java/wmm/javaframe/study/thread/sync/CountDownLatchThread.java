package wmm.javaframe.study.thread.sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.CountDownLatch;

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
        log.info(this.name + "准备-------：" + System.currentTimeMillis());
        log.info(this.name + "doing-------：" + System.currentTimeMillis());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        log.info(this.name + "结束--------：" + System.currentTimeMillis());
    }
}
