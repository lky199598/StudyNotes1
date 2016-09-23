package Annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//仅可用于注解类的成员变量
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/*1.SOURCE:在源文件中有效（即源文件保留）
2.CLASS:在class文件中有效（即class保留）
3.RUNTIME:在运行时有效（即运行时保留）*/

public @interface Column {

	String value();

}
