package wmm.javaframe.study.designmodule.mediator;

/**
 * Created by Administrator on 2016/9/5.
 */
public abstract class School {

    protected Mediator mediator;

    public School(Mediator mediator) {
        super();
        this.mediator = mediator;
    }

    public void defense() {
        System.out.println(getName() + "防御");
    }

    public void attack(School school) {
        System.out.println(getName() + "攻击" + school.getName());
    }

    //有了中介者，将由中介者处理
    public void attackByPatternAlliance(School school){
        mediator.resolveAttack(this, school);
    }

    public void defenseByPatternAlliance(){
        mediator.resolveDefense(this);
    }


    public abstract String getName();
}
