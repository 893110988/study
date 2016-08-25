package wmm.javaframe.study.designmodule.factory.simple;

/**
 * Created by Administrator on 2016/8/25.
 * 简单工厂模拟了+springBean管理里面获取需要的Bean
 */
public class Testaaa {


    public static void main(String[] args) {
        AppleInterface inter= AppleFactory.getApple("apple1");
        inter.doSomething();
    }
}
