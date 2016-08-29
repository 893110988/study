package wmm.javaframe.study.designmodule.observer.listener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/29.
 */
public class Writer {
    //作者类

    private String name;//作者的名称

    private String lastNovel;//记录作者最新发布的小说

      private Set<Reader> writerListenerList = new HashSet<Reader>();//作者类要包含一个自己监听器的列表

    public Writer(String name) {
        super();
        this.name = name;
        // WriterManager.getInstance().add(this);
    }

    //作者发布新小说了，要通知所有关注自己的读者
    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        fireEvent();
    }
    public void giveEvent(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        fireEvent1();
    }
    //触发发布新书的事件，通知所有监听这件事的监听器
    private void fireEvent() {
            WriterEvent writerEvent = new WriterEvent(this);
            for (Reader writerListener : writerListenerList) {
                writerListener.addEvent(writerEvent);
            }
    }
    private void fireEvent1() {
            WriterEvent writerEvent = new WriterEvent(this);
            for (Reader writerListener : writerListenerList) {
                writerListener.giveEvent(writerEvent);
            }
    }
    //提供给外部注册成为自己的监听器的方法
        public void registerListener(Reader writerListener){
            writerListenerList.add(writerListener);
        }
    //提供给外部注销的方法
       /* public void unregisterListener(WriterListener writerListener){
            writerListenerList.remove(writerListener);
        }*/

    public String getLastNovel() {
        return lastNovel;
    }

    public String getName() {
        return name;
    }


}
