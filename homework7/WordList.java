package com.yichao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 * 读取连个文件，返回两个词汇 list1 list2
 * 用一个totalList存放两个list 
 * 将 list2 的元素依次加入到 list1 中，并判断 list1 是否已存在 list2 中的元素
 * 可以分别计算 totalList 和 sameList 的大小
 * 分别将 totalList 和 sameList 写入文件
 * 
 */
public class WordList {
	
	//读取文件返回词汇列表
	static List<String> readFile(String fileName){
		List<String> wordList = new ArrayList<>();
		String[] tempStr;
		String lineStr;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while((lineStr = reader.readLine()) != null){
				//split掉标点符号和空格
				tempStr = lineStr.split("[\\s,.;!！。，；]");
				for(String s:tempStr){
					if(!s.trim().equals("")){
						wordList.add(s.trim());
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return wordList;
	}
	
	//输出 totalList
	static List<String> toToalList(List<String> list1, List<String> list2){
		
		if(list2.size() == 0){
			return list1;
		}else if(list1.size() == 0){
			return list2;
		}else{
			List<String> totalList = new ArrayList<>();
			totalList.addAll(list1);
			for(String s:list2){
				if(totalList.contains(s)){
					continue;
				}else{
//					list1.add(s);
					totalList.add(s);
				}
				
			}
			return totalList;
		}
	}
	
	//输出 sameList
	static List<String> toSameList(List<String> list1, List<String> list2){
		
		if(list1.size() == 0 || list2.size() == 0){
			return null;
		}else{
			List<String> sameList = new ArrayList<>();
			for(String s:list2){
				if(list1.contains(s)){
					sameList.add(s);
					
				}else{
					continue;
				}
			}
			
			return sameList;
		}
		
		
	}
	
	//将 list 写入文件
	static boolean toFile(String fileName, List<String> list){
		boolean result = false;
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			for(String s:list){
				//每行写一个单词
				fw.write(s+"\n");
			}
			result = true;
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		//测试文本1
		String fileName1 = "essay1.txt";
		//测试文本2
		String fileName2 = "essay2.txt";
		//文本1 和 文本2 的所有词汇（不重复）
		String totalListFile = "totalList.txt";
		//文本1 和 文本2的重复词汇
		String sameListFile = "sameList.txt";
		List<String> list1 = readFile(fileName1);
		List<String> list2 = readFile(fileName2);
		List<String> totalList = toToalList(list1, list2);
		List<String> sameList = toSameList(list1, list2);
		
		toFile(totalListFile, totalList);
		toFile(sameListFile, sameList);
		//总词汇表的词数
		System.out.println("total list contains " + totalList.size() + " words");
		//重复词汇表的词数
		System.out.println("same list contains " + sameList.size() + " words");
	}
	
}
