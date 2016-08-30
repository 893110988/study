package wmm.javaframe.study.designmodule.strategy;

/**
 * Created by Administrator on 2016/8/30.
 */
public class Testaaaa {

    public static void main(String[] args) {
        double aa=CallPriceFactory.getCallPrice().createCalPrice(2000d);
        System.out.println(aa);
        aa=CallPriceFactory.getCallPrice().createCalPrice(4999d);
        System.out.println(aa);
    }
}
