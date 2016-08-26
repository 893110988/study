package wmm.javaframe.study.designmodule.factory.abstract1;

import wmm.javaframe.study.designmodule.factory.method.Method1Factory;
import wmm.javaframe.study.designmodule.factory.method.Method2Factory;
import wmm.javaframe.study.designmodule.factory.method.MethodInterface;

/**
 * Created by Administrator on 2016/8/25.
 *
 */
public class Testaaa {


    public static void main(String[] args) {
        Creator creator=new Creator1();
        creator.createProductA().methodA();
        creator.createProductB().methodB();

        creator=new Creator2();
        creator.createProductA().methodA();
        creator.createProductB().methodB();
    }
}
