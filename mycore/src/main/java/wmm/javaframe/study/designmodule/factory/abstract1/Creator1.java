package wmm.javaframe.study.designmodule.factory.abstract1;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Creator1 implements Creator {
    public ProductA createProductA() {
        return new ProductA1();
    }

    public ProductB createProductB() {
        return new ProductB1();
    }
}
