package wmm.javaframe.study.reflect.vistor;

/**
 * Created by Administrator on 2016/8/10.
 */
public class VisitableString1 implements  Visitable{
    private Float value;
    public VisitableString1(Float string) {
        value = string;
    }
    public void todo(Visitor visitor)
    {
        System.out.println("VisitableString1");
        visitor.visitFloat(this.value);
    }
}
