package wmm.javaframe.study.designmodule.strategy.call;

import wmm.javaframe.study.designmodule.strategy.TotalValidRegion;
import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

/**
 * Created by Administrator on 2016/8/30.
 */
@TotalValidRegion(max = 1000)
public class Vip implements BaseCall {

    public Double callPrice(Double oldPrice) {
        return oldPrice * 0.7;
    }
}
