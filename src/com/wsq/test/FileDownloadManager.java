package com.wsq.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloadManager {

	
	public static void download(String path, String savePath) throws Exception {
		
		 //newһ��URL����  
        URL url = new URL(path);  
        //������  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        //��������ʽΪ"GET"  
        conn.setRequestMethod("GET");  
        //��ʱ��Ӧʱ��Ϊ5��  
        conn.setConnectTimeout(5 * 1000);  
        //ͨ����������ȡͼƬ����  
        InputStream inStream = conn.getInputStream();  
        //�õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����  
        byte[] data = readInputStream(inStream);  
        //newһ���ļ�������������ͼƬ��Ĭ�ϱ��浱ǰ���̸�Ŀ¼  
        System.out.println(savePath + UrlUtils.getUrlFileName(path));
        File imageFile = new File(savePath + UrlUtils.getUrlFileName(path));  
        //���������  
        FileOutputStream outStream = new FileOutputStream(imageFile);  
        //д������  
        outStream.write(data);  
        //�ر������  
        outStream.close();  

	}
	public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //����һ��Buffer�ַ���  
        byte[] buffer = new byte[1024];  
        //ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���  
        int len = 0;  
        //ʹ��һ����������buffer������ݶ�ȡ����  
        while( (len=inStream.read(buffer)) != -1 ){  
            //���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���  
            outStream.write(buffer, 0, len);  
        }  
        //�ر�������  
        inStream.close();  
        //��outStream�������д���ڴ�  
        return outStream.toByteArray();  
    }  
}
