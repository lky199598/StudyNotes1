package File;

import java.io.File;

public class ListFile {

	public static void listAll(File file) throws Exception {
		
		if (file.isFile()) {
			System.out.println(file);
		}

		else if (file.isDirectory()) 
		{
			//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件
			File[] fs = file.listFiles();
			
			for (int i = 0; i < fs.length; i++)
			{
				listAll(fs[i]);//递归调用
			}
		}
	}

}
