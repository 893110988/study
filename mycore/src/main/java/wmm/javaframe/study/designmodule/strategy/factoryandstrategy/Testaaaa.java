package wmm.javaframe.study.designmodule.strategy.factoryandstrategy;

import wmm.javaframe.study.designmodule.strategy.*;
import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

/**
 * Created by Administrator on 2016/8/31.
 */
public class Testaaaa {
    public static void main(String[] args) {
        BaseCall call=CallPriceFactory.getInstance().createBaseCall(400d);
        System.out.println("客户需要付钱：" + call.callPrice(400d));
    }
}
