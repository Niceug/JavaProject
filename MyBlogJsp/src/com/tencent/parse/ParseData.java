package com.tencent.parse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import com.tencent.blogservlet.User;

/**
 * 爬取信息的类
 * @author Z7M-SL7D2
 *
 */
public class ParseData {

	/**
	 * 获取源代码
	 * @param url 网址
	 * @param encoding 编码
	 * @return 返回网站源码
	 * @throws Exception
	 */
	public static String getSourceByUrl(String url, String encoding) throws Exception {
		URLConnection uc = new URL(url).openConnection();
		InputStreamReader isr = new InputStreamReader(uc.getInputStream(), encoding);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		StringBuffer sbSource = new StringBuffer();
		String source = null;
		while((line = br.readLine()) != null) {
			sbSource.append(line + "\n");
		}
		source = sbSource.toString();
		return source;
	}
	
	/**
	 * 根据源代码获取有用的信息
	 * @param url 网址
	 * @param encoding 编码
	 * @throws Exception
	 */
	public static List<User> getInfoFromSource(String url, String encoding) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		List<User> userList = new ArrayList<User>();
		String[] urla = url.split("/b");
		String urlHead = urla[0];
		int i = 2;
		while(true) {
			String source = getSourceByUrl(url, encoding);
			Document doc = Jsoup.parse(source);
			Elements eles = doc.getElementsByClass("span11");
			if(eles.toString().equals("")) {
				break;
			}
			for(Element ele : eles) {
				//获取文章标题
				String title = ele.getElementsByClass("margin_top5").first().text();
				//获取文章的链接
				String href = ele.getElementsByClass("title").attr("href");
				//获取文章的作者
				String writer = ele.getElementsByClass("name").text();
				//通过文章href获取文章id
				String id = href.substring(6, href.indexOf("."));
				//获取文章概述
				String summary = ele.getElementById("project_content_" + id).text();
				String str = new String(urlHead + href);
				User user = new User(title, str, summary, writer);
				userList.add(user);
			}
			//提取下一页的数据（变更url，翻页）
			String [] strArr = url.split("/p");
			StringBuffer sb1 = new StringBuffer();
			url = sb1.append(strArr[0] + "/p" + i + ".htm").toString();
			++i;
		}
		return userList;
	}
	public static void main(String [] args) {
		try {
			getInfoFromSource("http://www.zuidaima.com/blog/p1.htm", "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
