package wmm.javaframe.study.annotation.ann;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/8/17.
 * 元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，它们被用来提供对其它 annotation类型作说明。Java5.0定义的元注解：
 　　　　1.@Target,
 　　　　2.@Retention,
 　　　　3.@Documented,
 　　　　4.@Inherited
 @Target：
 　　　@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
　　作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
　　取值(ElementType)有：
　　　　1.CONSTRUCTOR:用于描述构造器
　　　　2.FIELD:用于描述域(成员变量)
　　　　3.LOCAL_VARIABLE:用于描述局部变量
　　　　4.METHOD:用于描述方法
　　　　5.PACKAGE:用于描述包
　　　　6.PARAMETER:用于描述参数
　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
http://images.cnitblog.com/blog/34483/201304/25200814-475cf2f3a8d24e0bb3b4c442a4b44734.jpg    注解的解释
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
   String value() default  "wmm111";
}
