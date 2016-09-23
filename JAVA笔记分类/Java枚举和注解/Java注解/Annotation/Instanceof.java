package Annotation;

public class Instanceof {
   public static void main(String[] args )
   {
	   String str = new String();
	   if(str instanceof String)
		   System.out.println("String的实例");
	   else
		   System.out.println("不是String的实例");
	   
	   Integer n = null;
	   
	   if(n instanceof Integer)
		   System.out.println("Integer的实例");
	   else
		   System.out.println("不是Integer的实例");
   }
}
