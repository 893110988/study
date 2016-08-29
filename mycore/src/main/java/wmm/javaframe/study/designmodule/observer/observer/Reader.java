package wmm.javaframe.study.designmodule.observer.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016/8/26.
 * 观察者
 */
public class Reader implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reader(String name) {
        this.name=name;
    }

    //关注作者
    public void addObservable(String writerName){

        Manager.getManager().getWriter(writerName).addObserver(this);
    }

    //取关作者
    public void removeObservable(String writerName){
        Manager.getManager().getWriter(writerName).deleteObserver(this);
    }

    public void update(Observable o, Object arg) {
        System.out.println("du"+arg);
    }
}
