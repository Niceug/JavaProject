package cn.edu.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.edu.bean.Canteen;

/**
 * 文件操作的实现类
 */
public class FileOperation implements FileOperationImp{

//	消费记录写入txt文件
	@Override
	public int writeToTextFile(Canteen consume){ 
		FileWriter fw = null;
		try {
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
		File f=new File("consumeListTxt.txt");
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(consume.getMealCardId());
		pw.println(consume.getCanteenId());
		pw.println(consume.getDeviceId());
		pw.println(consume.getConsumeMoney());
		pw.println(consume.getConsumeTime());
		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return 0;
		
	}
//	从txt文件读
	@Override
	public List<Canteen> readFromTextFile(){
		FileReader fr = null;
		List list = new ArrayList<Canteen>();
		try {
			fr = new FileReader("consumeListTxt.txt");
		 
		 BufferedReader br = new BufferedReader(fr);   
		 String str2 = br.readLine();
		 Canteen c = null;
		int i = 1; 
		while (str2 != null) {   
		    str2 = br.readLine();   
		    if(i == 1)
		    {
		    	c = new Canteen();
		    	c.setMealCardId(new Integer(str2));
		    }else if(i == 2){
		    	c.setCanteenId(new Integer(str2));
		    }else if(i == 3){
		    	c.setDeviceId(new Integer(str2));
		    }else if(i == 4){
		    	c.setConsumeMoney(new Integer(str2));
		    }else if(i == 5){
		    	c.setConsumeTime(new Long(str2));
		    	list.add(c);
		    	i %= 5;
		    }
		    
		    ++i;
		}   
		br.close();   
		fr.close();    
		} catch (Exception e) {
			e.printStackTrace();
		}  
		  
		return list;
		
	}
//	写入XML文件
	@Override
	public int writeToXMLFile(Canteen c){
		try {
		SAXReader reader = new SAXReader();
        // 2.通过reader对象的read方法加载xml文件，获取Document对象
		File f = new File("consumeListXML.xml");
        Document document = reader.read(f);
        Element consumeList = document.getRootElement();// 通过document对象获取根节点bookstore
        
        Element consume = consumeList.addElement("consume");
        Element mealCardId = consume.addElement("mealCardId");
        mealCardId.setText(c.getMealCardId() + "");
        
        Element canteenId = consume.addElement("canteenId");
        canteenId.setText(c.getCanteenId() + "");
        Element deviceId = consume.addElement("deviceId");
        deviceId.setText(c.getDeviceId() + "");
        Element consumeMoney = consume.addElement("consumeMoney");
        consumeMoney.setText(c.getConsumeMoney() + "");
        Element consumeTime = consume.addElement("consumeTime");
        consumeTime.setText(c.getConsumeTime() + "");
         
        // 3.设置输出格式和输出流
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer;
		writer = new XMLWriter(new FileOutputStream("consumeListXML.xml"), format);
        writer.write(document);// 将文档写入到输出流
        writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
		
	}
//	从XML文件读
	@Override
	public List<Canteen> readFromXMLFile(){
		List<Canteen> canteenList = null;
		try {
		SAXReader reader = new SAXReader();
        // 2.通过reader对象的read方法加载xml文件，获取Document对象
		File f = new File("consumeListXML.xml");
        Document document = reader.read(f);
        //获取根节点
        Element consumeList = document.getRootElement();// 通过document对象获取根节点
        List<Element> list = consumeList.elements();
        canteenList = new ArrayList<Canteen>();
        for(Element ele : list){
        	Canteen c = new Canteen();
        	String mealCardId = ele.elementText("mealCardId");
        	String canteenId = ele.elementText("canteenId");
        	String deviceId = ele.elementText("deviceId");
        	String consumeMoney = ele.elementText("consumeMoney");
        	String consumeTime = ele.elementText("consumeTime");
        	c.setMealCardId(new Integer(mealCardId));
        	c.setCanteenId(new Integer(canteenId));
        	c.setDeviceId(new Integer(deviceId));
        	c.setConsumeMoney(new Float(consumeMoney));
        	c.setConsumeTime(new Long(consumeTime));
        	canteenList.add(c);
        	
        	
        }
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return canteenList;
		
	}
	
//	对bean对象进行序列化写入文件操作
	@Override
	
	public int serializeIntoFile(Canteen consume){
		try{
         File file=new File("consumeSerializeFile");
         boolean isexist=false;//定义一个用来判断文件是否需要截掉头aced 0005的
         
         if(file.exists()){    //文件是否存在
	            isexist=true;
	            FileOutputStream fo=new FileOutputStream(file,true);
	            ObjectOutputStream oos = new ObjectOutputStream(fo);
	            long pos=0;
	           if(isexist){
	                 pos=fo.getChannel().position()-4;//追加的时候去掉头部aced 0005
	                 fo.getChannel().truncate(pos);
	           }
	         oos.writeObject(consume);//进行序列化    
	         
           }else{//文件不存在
              file.createNewFile();
              FileOutputStream fo=new FileOutputStream(file);
              ObjectOutputStream oos = new ObjectOutputStream(fo);
              oos.writeObject(consume);//进行序列化
              oos.close();
              System.out.println("首次对象序列化成功！");
           }
        
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
//	从文件读取，转换为bean对象
	@Override
	public List<Canteen> readFromSerializeFile(){
		 File file = new File("consumeSerializeFile");
		 List<Canteen> list = null;
         if(file.exists()){
        	 list = new ArrayList<Canteen>();
             ObjectInputStream ois;
             try {
	             FileInputStream fn=new FileInputStream(file);
	             ois = new ObjectInputStream(fn);
	             while(fn.available()>0){//代表文件还有内容
		             Canteen c = (Canteen) ois.readObject();//从流中读取对象
	                 list.add(c);
	             }
               ois.close();
             } catch (Exception e1) {
            e1.printStackTrace();
             }
         }
		return list;
	}
}
