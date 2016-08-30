package wmm.javaframe.study.designmodule.strategy.call;

import wmm.javaframe.study.designmodule.strategy.TotalValidRegion;
import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

/**
 * Created by Administrator on 2016/8/30.
 */
@TotalValidRegion(min = 1001,max = 3000)
public class SuperVip implements BaseCall {

    public Double callPrice(Double oldPrice) {
        return oldPrice * 0.5;
    }
}
