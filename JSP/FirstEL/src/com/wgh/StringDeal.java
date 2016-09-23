package com.wgh;

public class StringDeal {

	public static String shiftEnter(String str)
	{
		String NewStr = str.replaceAll("\r\n", "<br>");
		
		NewStr =  NewStr.replaceAll(" ", "&nbsp;");
		return NewStr;
	}
}
