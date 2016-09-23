package File;

import java.io.File;
import java.io.IOException;

public class UseFile {
	public static void main(String[] args) {
		File dir1 = new File("D:/IOTest/dir1");
		
		if (!dir1.exists()) { // 如果D:/IOTest/dir1不存在，就创建为目录
			dir1.mkdir();// 创建此抽象路径名指定的目录。
		}
		
		// 创建以dir1为父目录,名为"dir2"的File对象
		File dir2 = new File(dir1, "dir2");
		if (!dir2.exists()) { // 如果还不存在，就创建为目录
			dir2.mkdirs();// 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		} 
		
		
		File dir4 = new File(dir1, "dir3/dir4");
		if (!dir4.exists()) {
			dir4.mkdirs();
		}
		
		
		// 创建以dir2为父目录,名为"test.txt"的File对象
		File file = new File(dir2, "test.txt");
		if (!file.exists()) { // 如果还不存在，就创建为文件
			try {
				file.createNewFile();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
