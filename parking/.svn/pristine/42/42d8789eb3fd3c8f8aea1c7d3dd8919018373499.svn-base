package com.example.uitls;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class Sample {
	
	private static AipOcr client;
	
	public static AipOcr getClient() {
        // 初始化一个AipOcr
		if(client == null) {
			//client = new AipOcr("15653569", "YuBo92awB0WluwM6yhGgSfNq", "PGVC30cLXxvV6OfoZarZVxka34ojGi2D");
			client = new AipOcr("15755463", "rggYMsCSYi8MTxZ1B6KOZvqY", "f3Nx9G98WEHV6fEbiGMiS6Ubcouy00Py");
			// 可选：设置网络连接参数
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);
		}
        return client;
	}

	public static void main(String[] args) {
		AipOcr client = getClient();
		 // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>(16);
	    options.put("multi_detect", "true");


	    // 参数为本地图片路径
//	    String image = "test.jpg";
//	    JSONObject res = client.plateLicense(image, options);
//	    System.out.println(res.toString(2));

	    // 参数为本地图片二进制数组
//	    byte[] file = readImageFile(image);
//	    File file = new File("D:\\1.jpg");
//	    new InputStreamReader()
//	    ImageUtils.baseToByte(file);
	    byte[] file2byte = File2byte("D:\\1.jpg");
	    JSONObject res = client.plateLicense(file2byte, options);
	    System.out.println(res.toString(2));
	}
	
	public static byte[] File2byte(String filePath)
    {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void byte2File(byte[] buf, String filePath, String fileName)  {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try
        {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory())
            {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bos != null)
            {
                try
                {
                    bos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
