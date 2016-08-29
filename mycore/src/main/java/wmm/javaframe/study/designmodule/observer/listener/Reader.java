package wmm.javaframe.study.designmodule.observer.listener;

import java.util.EventListener;

/**
 * Created by Administrator on 2016/8/29.
 */
public class Reader implements EventListener{

    private String name;

    public Reader(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEvent(WriterEvent event){
        Writer writer=event.getWriter();
        System.out.println(name+"know "+writer.getName()+"write "+writer.getLastNovel());
    }
    public void giveEvent(WriterEvent event){
        Writer writer=event.getWriter();
        System.out.println(name+"know "+writer.getName()+"write "+writer.getLastNovel()+"打赏了100块钱");
    }
}
