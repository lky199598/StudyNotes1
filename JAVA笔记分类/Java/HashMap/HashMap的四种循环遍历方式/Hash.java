package Emp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hash {

	public static void main(String args[]) {
		Map<String, Integer> goods = new HashMap<String, Integer>();
		goods.put("aaa", 1);
		goods.put("bbb", 2);

		// Set<Map.Entry<K,V>> entrySet() 返回此映射所包含的映射关系的 Set 视图。
		
		//第一种方法
		for (Entry<String, Integer> entry : goods.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		System.out.println();
		
		
		//第二种方法
		Iterator<Map.Entry<String, Integer>> iterator=goods.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		
		
		//第三种方法
		// Set<K> keySet()    返回此映射中所包含的键的 Set 视图。 
		System.out.println();
		for (String key : goods.keySet()) {
		System.out.println(key+"\t"+goods.get(key));
		}
		
		//第四种方法
		System.out.println();
		Set<Entry<String, Integer>> entrySet = goods.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}

}
