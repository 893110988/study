package wmm.javaframe.study.annotation.model;

import wmm.javaframe.study.annotation.ann.MyAnnotation;

/**
 * Created by Administrator on 2016/8/17.
 */
public class AppleAnno {

    @MyAnnotation("apple")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
