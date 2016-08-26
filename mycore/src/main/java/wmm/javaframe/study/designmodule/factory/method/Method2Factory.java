package wmm.javaframe.study.designmodule.factory.method;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Method2Factory implements MethodFactoty {
    public MethodInterface getMethodInterface() {
        return new Method2();
    }
}
