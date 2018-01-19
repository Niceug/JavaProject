package com.baidu.parse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @deprecated  获取图片的一个类
 * @author      Z7M-SL7D2
 * @since       2018年1月16日13:12:33
 */
public class ParseImg {
	/**
	 * @deprecated 用来获取网页源码
	 * @param url  网址
	 * @param encoding 解码方式
	 * @return 返回源码字符串
	 */
	public static String getHtmlSourseFromUrl(String url, String encoding) {
		InputStreamReader isr = null;
		StringBuffer sb = new StringBuffer();
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			isr = new InputStreamReader(uc.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;

			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String htmlSourse = sb.toString();
		return htmlSourse;
	}
	
	/**
	 * @deprecated 获取图片src
	 * @param url
	 * @param encoding
	 * @return
	 */
	public static List<HashMap<String, String>> getImgFormHtml(String url, String encoding) {
		String html = getHtmlSourseFromUrl(url, encoding);
		Document document = org.jsoup.Jsoup.parse(html);
		Element elementId = document.getElementById("hotel_list");
		Elements elements = elementId.getElementsByClass("hotel_new_list");
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		for(Element element : elements) {
			HashMap<String, String> map = new HashMap<String, String>();
			String src = element.getElementsByTag("img").attr("src");
			map.put("src", src);
			list.add(map);
		}
		
		return list;
	}
	public static void main(String[] args) {
		List<HashMap<String, String>> list = null;
		try{
			list = getImgFormHtml("http://hotels.ctrip.com/hotel/nanjing12#ctm_ref=hod_hp_sb_lst", "gbk");
		}catch(Exception e) {
			System.out.println("抓取的网页内容为空，未搜索到HTML ID或者Class");
		}
		
		for(HashMap<String, String> map:list) {
			System.out.println(map.get("src"));
		}
	}
}