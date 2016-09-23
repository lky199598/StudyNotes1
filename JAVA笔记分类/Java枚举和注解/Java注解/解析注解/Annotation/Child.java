package Annotation;

/*@Description("他V极度恐慌")*/

public class Child extends Person {

	@Override//方法覆盖
/*	@Description(value="姓名")*/
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Description(value="年龄")
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char sex() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
