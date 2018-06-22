package com.wsq.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHtml {

	
	
	
	/**
	 * ��ȡHTML����
	 * @param url
	 * @return
	 * @throws Exception
	 */
    public static String getHtml(String url)throws Exception{
        URL url1=new URL(url);//ʹ��java.net.URL
        URLConnection connection=url1.openConnection();//������
        InputStream in=connection.getInputStream();//��ȡ������
        InputStreamReader isr=new InputStreamReader(in);//���İ�װ
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){//���ж�ȡ
            sb.append(line,0,line.length());//��ӵ�StringBuffer��
            sb.append('\n');//��ӻ��з�
        }
        //�رո��������������ĺ�ر�
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }
	
	/**
     * �õ���ҳ��ͼƬ�ĵ�ַ
     */
    public static List<String> getImgStr(String htmlStr) {
        List<String> pics = new ArrayList<String>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //ͼƬ���ӵ�ַ
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile
                (regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // �õ�<img />����
            img = m_image.group();
            // ƥ��<img>�е�src����
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }
}
