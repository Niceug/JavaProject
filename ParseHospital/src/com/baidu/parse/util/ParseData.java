package com.baidu.parse.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @deprecated 爬取数据类
 * @author     ltp
 * @version    1.0
 * <a href = "http://www.baidu.com">点击查看详细信息</a>
 * @since 2018年1月15日13:05:48
 */

public class ParseData {
	/**
	 * @deprecated  获取网页源代码
	 * @param       url 网址
	 * @param       encoding 解码方式
	 * @return      返回String类型的网页源代码
	 */
	public static String getHtmlInfoFromUrl(String url, String encoding) {
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = null;
		try{
			URL urlObj = new  URL(url);
			URLConnection uc = urlObj.openConnection();
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String str = sb.toString();
	//System.out.println(str);
		return str;
		
	}
	
	/**
	 * @deprecated 从源代码中获取有用的信息
	 * @param url  网址
	 * @param encoding 解码方式
	 */
	
	public static List<HashMap<String, String>> getHotelInfo(String url, String encoding) {
		String html = getHtmlInfoFromUrl(url, encoding);
		org.jsoup.nodes.Document document = Jsoup.parse(html);
		//Elements elementList = document.getElementsByClass("setach-left-list");
		Elements elementList = document.getElementsByTag("li");
		List<HashMap<String, String>> maps =  new ArrayList<HashMap<String, String>>();
		
		for(org.jsoup.nodes.Element element: elementList){
			String img = element.getElementsByClass("yy-img").attr("src");
			String title = element.getElementsByClass("yy-name").attr("title");
			if(img != "" && title != "") {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("img", img);
				map.put("title", title);
				maps.add(map);
			}
			
		}
		return maps;
	}
	/*public static void main(String[] args) {
		List<HashMap<String, String>> list = getHotelInfo("http://yyk.39.net/shanxi2/hospitals/", "gbk");
		for(HashMap<String, String> map: list) {
			System.out.println("图片 ：" + map.get("img"));
			System.out.println("医院名称：" + map.get("title"));
			System.out.println("医院位置：" + map.get("location"));
			System.out.println("------------------------------------");
		}
	}*/
}
