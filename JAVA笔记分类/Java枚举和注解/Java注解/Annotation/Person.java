package Annotation;

/*public interface Person {

	public String name();
	
	public int age();
	
	@Deprecated//过时
	public char sex();
}*/

@Description("这是一个父类")
public class Person {

	@Description("这是一个父类方法")
	public String name(){
		return null;
	}
	
	public int age(){
		return 0;
	}
	
	@Deprecated//过时
	public char sex(){
		return 0;
	}
}
