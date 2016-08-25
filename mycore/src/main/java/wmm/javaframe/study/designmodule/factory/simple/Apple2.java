package wmm.javaframe.study.designmodule.factory.simple;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Apple2 implements AppleInterface {
    private static Logger log = Logger.getLogger(Apple2.class);
    public void doSomething() {
        log.info("Apple2Apple2Apple2Apple2");
    }
}
