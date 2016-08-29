package wmm.javaframe.study.designmodule.observer.observer;

import java.util.Observable;

/**
 * Created by Administrator on 2016/8/26.
 * 被观察者
 */
public class Writer extends Observable{
    private String name;

    private String writeThing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writerBook(String writeThing){
        System.out.println(writeThing);
        this.writeThing=writeThing;
        setChanged();
        notifyObservers();
    }

    public Writer(String name) {
        this.name = name;
        Manager.getManager().addWriter(this);
    }
}
