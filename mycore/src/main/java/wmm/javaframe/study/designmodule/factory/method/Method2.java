package wmm.javaframe.study.designmodule.factory.method;

import org.apache.log4j.Logger;
import wmm.javaframe.study.designmodule.factory.simple.AppleInterface;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Method2 implements MethodInterface {
    private static Logger log = Logger.getLogger(Method2.class);
    public void doSomething() {
        log.info("Method2Method2Method2Method2");
    }
}
