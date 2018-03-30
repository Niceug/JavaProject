package cn.edu.impl;

import java.util.List;

import cn.edu.bean.Canteen;

/**
 * 有关文件操作的接口
 *
 */
public interface FileOperationImp {
//	消费记录写入txt文件
	public int writeToTextFile(Canteen consume);
//	从txt文件读
	public List<Canteen> readFromTextFile();
//	写入XML文件
	public int writeToXMLFile(Canteen consume);
//	从XML文件读
	public List<Canteen> readFromXMLFile();
//	对bean对象进行序列化写入文件操作
	public int serializeIntoFile(Canteen consume);
//	从文件读取，转换为bean对象
	public List<Canteen> readFromSerializeFile();
}
