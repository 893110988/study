package wmm.javaframe.study.designmodule.strategy.factoryandstrategy;

import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

/**
 * Created by Administrator on 2016/8/31.
 */
@OnceValidRegion(@ValidRegion(max=1000,order=99))
public class Common implements BaseCall{
        public Double callPrice(Double originalPrice) {
            return originalPrice;
        }
}
