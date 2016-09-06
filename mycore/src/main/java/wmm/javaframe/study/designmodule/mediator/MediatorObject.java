package wmm.javaframe.study.designmodule.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class MediatorObject implements Mediator {
    private List<School> schools;

    public MediatorObject() {
        schools = new ArrayList<School>();
    }

    public void add(School object) {
        schools.add(object);
    }

    public void resolveAttack(School resolveSide, School passiveSide) {
        if(schools.contains(resolveSide)&&schools.contains(passiveSide)){
            System.out.println("主攻方" + resolveSide.getName() + "以及被攻方" + passiveSide.getName() + "都已加入联盟，不允许内讧！");
        }else if (schools.contains(resolveSide) && !schools.contains(passiveSide)) {
            System.out.println("主攻方" + resolveSide.getName() + "已加入联盟，被攻方" + passiveSide.getName() + "不在联盟之中，将集体攻打该门派！");
            for (School classObject : schools) {
                classObject.attack(passiveSide);
            }
        }else{
            System.out.println("主攻方" + resolveSide.getName() + "未加入联盟，联盟无权干预此事！");
        }
    }

    public void resolveDefense(School passiveSide) {
        if (schools.contains(passiveSide)) {
            System.out.println("被攻方" + passiveSide.getName() + "已加入联盟，联盟将齐力防御！");
            for (School classObject : schools) {
                classObject.defense();
            }
        }else {
            System.out.println("被攻方" + passiveSide.getName() + "未加入联盟，联盟不给予防御帮助！");
            passiveSide.defense();
        }
    }
}
