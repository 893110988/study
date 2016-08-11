package wmm.javaframe.study.reflect.vistor;

/**
 * Created by Administrator on 2016/8/10.
 */
public class VisitableString implements  Visitable{
    private String value;
    public VisitableString(String string) {
        value = string;
    }
    public void todo(Visitor visitor) {
        visitor.visitString(this.value);
        System.out.println("VisitableString");
    }
}
