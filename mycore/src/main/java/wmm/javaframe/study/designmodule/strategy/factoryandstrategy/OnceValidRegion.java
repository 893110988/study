package wmm.javaframe.study.designmodule.strategy.factoryandstrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/8/31.
 */
//这是我们的一次性有效区间注解，可以给策略添加有效区间的设置
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnceValidRegion {
    //我们引用有效区间注解
    ValidRegion value() default @ValidRegion;
}
