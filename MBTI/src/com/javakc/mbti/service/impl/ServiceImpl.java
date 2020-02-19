package com.javakc.mbti.service.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javakc.mbti.dao.Dao;
import com.javakc.mbti.dao.factory.DaoFactory;
import com.javakc.mbti.service.Service;
import com.javakc.mbti.vo.Question;
import com.javakc.mbti.vo.Result;


public class ServiceImpl implements Service{
    private Dao dao=DaoFactory.getDao();
	//单例模式
	private static ServiceImpl instance=new ServiceImpl();
	private ServiceImpl() {
		
	}
	public static ServiceImpl getInstance(){
		return instance;	
	}
	//读取文件中的题目和选项，解析成Question数据结构，封装在list中
	@Override
	public List<Question> readQuestion() throws IOException {
	    //调用数据层方法，取得文件中的题目文本
		String jsonString=dao.read("file/question");
		//使用Gson将json格式的字符串解析成list对象
		Gson gson=new Gson();
		List<Question> qs
		=gson.fromJson(jsonString,new TypeToken<List<Question>>(){}.getType());

		return qs;
	}

	@Override
	public String parseResult(List<String> r) throws IOException {
		//调用数据层方法，取得文件中的题目文本
		String jsonStr=dao.read("file/result");
		//使用Gson将json格式的字符串解析成list对象
		Gson gson=new Gson();
		List<Result> rs
		=gson.fromJson(jsonStr,new TypeToken<List<Result>>(){}.getType());
        int e=Collections.frequency(r, "E");
        int i=Collections.frequency(r, "I");
        int s=Collections.frequency(r, "S");
        int n=Collections.frequency(r, "N");
        int t=Collections.frequency(r, "T");
        int f=Collections.frequency(r, "F");
        int j=Collections.frequency(r, "J");
        int p=Collections.frequency(r, "P");
        String a="";
        if (e>i) {
			a+="E";
		}else {
			a+="I";
		}
        if (s>n) {
    			a+="S";
    		}else {
    			a+="N";
    		}
        if (t>f) {
    			a+="T";
    		}else {
    			a+="F";
    		}
        if (j>p) {
    			a+="J";
    		}else {
    			a+="P";
    		}
        String b="";
        for (Result m:rs) {
			if (a.equals(m.getNum())) {
				b+=m.getContent();
			}
		}
		return b;

	}
	


}
