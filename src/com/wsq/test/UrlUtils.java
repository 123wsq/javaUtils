package com.wsq.test;

import java.util.HashMap;
import java.util.Map;

public class UrlUtils {

	
	public static void main(String[] args) {
		
		String strURL = "https://api.yczmj.cn/user/firstLeader?first_leader=100071&user_id=";
		String strURL2 = "https://api.yczmj.cn/user/firstLeader/123.jpg";
		String param1 = TruncateUrlPage(strURL);
		Map<String, String> param = urlSplit(strURL);
		System.out.println(param);
		System.out.println(getUrlFileName(strURL2));
	}
	
	/**
	 * ��ȡURL�������ļ���
	 * @param url
	 * @return
	 */
	public static String getUrlFileName(String url) {
		
		int index = url.lastIndexOf("/");
		
//	    String before = url.substring(0,index + 1);
	    String after = url.substring(index + 1);
	    
	    return after;
	}
	
	/**
     * ȥ��url�е�·�������������������
     * @param strURL url��ַ
     * @return url�����������
     * @author lzf
     */
    public static String TruncateUrlPage(String strURL){
        String strAllParam=null;
        String[] arrSplit=null;
        strURL=strURL.trim().toLowerCase();
        arrSplit=strURL.split("[?]");
        if(strURL.length()>1){
          if(arrSplit.length>1){
              for (int i=1;i<arrSplit.length;i++){
                  strAllParam = arrSplit[i];
              }
          }
        }
        return strAllParam;   
    }
    
    /**
     * ������url�����еļ�ֵ��
     * �� "index.jsp?Action=del&id=123"��������Action:del,id:123����map��
     * @param URL  url��ַ
     * @return  url�����������
     * @author lzf
     */
    public static Map<String, String> urlSplit(String URL){
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit=null;
        String strUrlParam=TruncateUrlPage(URL);
        if(strUrlParam==null){
            return mapRequest;
        }
        arrSplit=strUrlParam.split("[&]");
        for(String strSplit:arrSplit){
              String[] arrSplitEqual=null;         
              arrSplitEqual= strSplit.split("[=]");
              //��������ֵ
              if(arrSplitEqual.length>1){
                  //��ȷ����
                  mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
              }else{
                  if(arrSplitEqual[0]!=""){
                  //ֻ�в���û��ֵ��������
                  mapRequest.put(arrSplitEqual[0], "");       
                  }
              }
        }   
        return mapRequest;   
    }
}
