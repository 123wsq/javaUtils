package com.wsq.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMethod {
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(3);

	public static final String savePath = "/Users/wsq/Documents/test/9/love/"
			+"love_"
	+"‰¸‰¸–‘∏–Õ¯Õ‡"
			+"/";
	
	public static void main(String[] args) {
		
		
		String path = "http://img15.yixiu8.com:8080/picture/140718/pic8/";
		
			down(path);
			
	}
	public static void  down(String path) {
		try {
			for (int i = 1; i < 150; i++) {
			try {
				FileDownloadManager.download(path + i + ".jpg", savePath);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
