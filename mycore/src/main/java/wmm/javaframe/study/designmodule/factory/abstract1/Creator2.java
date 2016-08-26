package wmm.javaframe.study.designmodule.factory.abstract1;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Creator2 implements Creator {
    public ProductA createProductA() {
        return new ProductA2();
    }

    public ProductB createProductB() {
        return new ProductB2();
    }
}
