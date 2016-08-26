package wmm.javaframe.study.designmodule.factory.abstract1;

/**
 * Created by Administrator on 2016/8/25.
 *把工厂抽象出来   我需要的是产品 不需要关心产品是从哪个工厂里面出来的
 * 例子温州的工厂有苹果和橘子   青岛的工厂有苹果和橘子
 * 我需要温州的  我就new Creator1
 * 我需要青岛的  我就new Creator2
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
