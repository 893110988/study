package wmm.javaframe.study.designmodule.mediator;

import wmm.javaframe.study.designmodule.mediator.School;

/**
 * Created by Administrator on 2016/9/5.
 */
public interface Mediator {
    public abstract void add(School object);
    //攻击
    public abstract void resolveAttack(School resolveSide,School passiveSide);
    //防御
    public abstract void resolveDefense(School passiveSide);
}
