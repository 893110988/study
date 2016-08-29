package wmm.javaframe.study.designmodule.observer.listener;

import java.util.EventObject;

/**
 * Created by Administrator on 2016/8/29.
 */
public class WriterEvent extends EventObject {
    private static final long serialVersionUID = 8546459078247503692L;

    public WriterEvent(Writer writer) {
        super(writer);
    }

    public Writer getWriter(){
        return (Writer) super.getSource();
    }
}
