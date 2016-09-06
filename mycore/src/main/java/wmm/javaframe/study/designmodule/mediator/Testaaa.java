package wmm.javaframe.study.designmodule.mediator;

/**
 * Created by Administrator on 2016/9/5.
 */
public class Testaaa {
    public static void main(String[] args) {
        MediatorObject patternAlliance = new MediatorObject();

        School class1Object = new Class1Object(patternAlliance);
        School class2Object = new Class2Object(patternAlliance);

        School classOther = new ClassOther(patternAlliance);

        //策略宫没有被联盟收留
        patternAlliance.add(class1Object);
        patternAlliance.add(class2Object);
       // patternAlliance.add(classOther);

        class1Object.attackByPatternAlliance(class2Object);
        class2Object.attackByPatternAlliance(classOther);
        System.out.println("------------------------------------------------------");
        classOther.attackByPatternAlliance(class1Object);
        class2Object.defenseByPatternAlliance();
        System.out.println("------------------------------------------------------");
    }

}
