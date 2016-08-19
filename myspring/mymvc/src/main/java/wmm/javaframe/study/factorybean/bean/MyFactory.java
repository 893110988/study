package wmm.javaframe.study.factorybean.bean;

/**
 * Created by Administrator on 2016/8/18.
 */
public class MyFactory {

    private String name;

    public MyFactory(){
        System.out.println("initMyFactory");
    }

    public MyFactory(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
