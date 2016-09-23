package UseEnum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class UseEnumSet {
	public static void main(String[] args)
	{
		// EnumSet的使用
        EnumSet<EnumTest> weekSet = EnumSet.allOf(EnumTest.class);
        
        for(EnumTest day : weekSet)
        {
            System.out.println(day);
        }
 
        // EnumMap的使用
        EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
        
        weekMap.put(EnumTest.MON, "星期一");
        weekMap.put(EnumTest.TUE, "星期二");
        
        // ... ...
        for(Iterator< Entry<EnumTest, String> > iter = weekMap.entrySet().iterator(); iter.hasNext();)
        {
            Entry<EnumTest, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
	}
}
