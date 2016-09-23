package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
	
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	private BufferedInputStream bis=null;
	private BufferedOutputStream bos = null;
	
	void close()
	{
		if(bos != null)
			try {
				bos.close();
				bos = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if(bis != null)
			try {
				bis.close();
				bis = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(fos != null)
			try {
				fos.close();
				fos = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(fis  != null)
			try {
				fis.close();
				fis = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	void findFile(File f)
	{
		File[] file  = f.listFiles();
		for(File fs : file)
			if(fs.isFile())
			System.out.println(fs.getName());		
		
	}
	
	 void findFile1(File f)
	{
		System.out.println("\n");
		String[] file  = f.list();
		for(String fs : file)
			System.out.println(fs);		
		
	}
	
	 void copyFile(String src, String dest)
	{
		File f1 = new File(src);
				
		String s1 = f1.getName();
		dest+="\\"+s1;
		
		File f2 = new File(dest);
		
		try {
			fis =  new FileInputStream(f1);
			fos = new FileOutputStream(f2);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
						
			byte[] b = new byte[1024];
			int len;
			while( (len = bis.read(b)) != -1)
				fos.write(b, 0, len);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		System.out.println("复制成功！");
	}
	
	public static void main(String[] agrs)
	{
		CopyPicture cp = new CopyPicture();
		cp.copyFile("D:\\我的图片\\吹笛.jpg", "D:\\我的图片\\a");		
	}

}
