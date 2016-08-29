package wmm.javaframe.study.designmodule.observer.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Manager {

    private Manager() {

    }

    private Map<String, Writer> manager = new HashMap<String, Writer>();

    public Writer addWriter(Writer writer) {
        return manager.put(writer.getName(), writer);
    }

    public Writer getWriter(String name) {
        return manager.get(name);
    }

    public static Manager getManager() {
        return GetManager.manager;
    }

    private static class GetManager {
        private static Manager manager = new Manager();
    }


}
