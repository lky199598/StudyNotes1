package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransformStream
{
	public void testMyInput() throws Exception {
	
		//解码：字节数组-->字符串
		//编码：字符串-->字节数组
		FileInputStream fis = new FileInputStream("test.txt");
		FileOutputStream fos = new FileOutputStream("test1.txt");

		InputStreamReader isr = new InputStreamReader(fis, "GBK");		
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");

		BufferedReader br = new BufferedReader(isr);
		
		BufferedWriter bw = new BufferedWriter(osw);

		String str = null;
		while ((str = br.readLine()) != null)
		{
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		br.close();
	}

}
