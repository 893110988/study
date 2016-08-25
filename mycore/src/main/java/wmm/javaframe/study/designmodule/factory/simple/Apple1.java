package wmm.javaframe.study.designmodule.factory.simple;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Apple1 implements AppleInterface {

    private static Logger log = Logger.getLogger(Apple1.class);
    public void doSomething() {
        log.info("Apple1Apple1Apple1Apple1");
    }
}
