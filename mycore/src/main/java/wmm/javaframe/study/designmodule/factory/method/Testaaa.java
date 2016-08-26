package wmm.javaframe.study.designmodule.factory.method;

import wmm.javaframe.study.designmodule.factory.simple.AppleFactory;
import wmm.javaframe.study.designmodule.factory.simple.AppleInterface;

/**
 * Created by Administrator on 2016/8/25.
 * 简单工厂模拟了+springBean管理里面获取需要的Bean
 */
public class Testaaa {


    public static void main(String[] args) {
        MethodInterface inter = new Method1Factory().getMethodInterface();
        inter.doSomething();
        inter = new Method2Factory().getMethodInterface();
        inter.doSomething();
    }
}
