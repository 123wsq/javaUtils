package com.wsq.test;

import java.io.File;
import java.util.List;

public class MainMethod {

	public static final String savePath = "F:\\images/";
	public static void main(String[] args) {
		
	
		
		try {
			String content = ParseHtml.getHtml("https://www.mn52.com/xingganmeinv/19729.html");
//			System.out.println("ÍøÒ³ÄÚÈİ"+ content);
			List<String>  list = ParseHtml.getImgStr(content);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				FileDownloadManager.download("https:"+list.get(i), savePath);
			}
//			System.out.println("Í¼Æ¬£º "+list.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
