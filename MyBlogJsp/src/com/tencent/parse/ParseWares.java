package com.tencent.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.tencent.waresbean.WaresBean;

/**
 * 爬取淘宝网商品信息
 * @author Z7M-SL7D2
 *
 */
public class ParseWares {
	public static String getSourceFromUrl(String url, String encoding) throws IOException {
		URL u = new URL(url);
		URLConnection uc = u.openConnection();
		
		InputStreamReader isr = new InputStreamReader(uc.getInputStream(), encoding);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		StringBuffer sb = new StringBuffer();
		while((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		return sb.toString();
	}
	
	public static List<WaresBean> getInfoFromSource(String url, String encoding) throws IOException {
		String source = getSourceFromUrl(url, encoding);
		Document doc = Jsoup.parse(source);
		Element element = doc.getElementById("goodsPicList");
		Elements elements = element.getElementsByTag("li");
		List<WaresBean> list = new ArrayList<WaresBean>();
		Date date = new Date();
		Random r = new Random(100);
		for(Element e : elements) {
			//设置商品ID
			String id = new Long((long)(date.getTime() + r.nextInt())).toString();
			//获取商品的图片
			String img = e.getElementsByTag("img").attr("src");
			//获取商品的标题
			String title = e.getElementsByClass("title").text();
			//获取商品的价格
			String price = e.getElementsByClass("price").text();
			price = price.substring(1);
			//获取商品的数量
			int count = 10;
			//获取商品的描述信息
			String description = e.getElementsByClass("shop-infor").text();
			//封装成Bean对象
			WaresBean wb = new WaresBean(id, title, price, count, description, img);
			list.add(wb);
			System.out.println("ID：" + id + "图片：" + img + "\n" + "名称:" + title + "\n" + "价格:" + price + "\n"  + "描述："+ description + "\n\n\n");
		}
		return list;
	}

	public static void main(String[] args) {
//		String str = null;
//		try {
try {
	getInfoFromSource("http://www.zol.com/index.php?c=List&keyword=%B1%CA%BC%C7%B1%BE&spm=1865.45638", "gbk");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(str);
	}

}
