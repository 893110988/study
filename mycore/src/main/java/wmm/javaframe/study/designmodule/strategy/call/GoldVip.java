package wmm.javaframe.study.designmodule.strategy.call;

import wmm.javaframe.study.designmodule.strategy.TotalValidRegion;
import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

/**
 * Created by Administrator on 2016/8/30.
 */
@TotalValidRegion(min = 3001,max = 5000)
public class GoldVip implements BaseCall {

    public Double callPrice(Double oldPrice) {
        return oldPrice * 0.1;
    }
}
