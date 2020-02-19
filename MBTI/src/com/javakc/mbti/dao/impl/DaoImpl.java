package com.javakc.mbti.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.javakc.mbti.dao.Dao;
import com.javakc.mbti.service.impl.ServiceImpl;

public  class DaoImpl implements Dao{
	
	private static DaoImpl instance=new DaoImpl();
	private DaoImpl() {
		
	}
	public static DaoImpl getInstance() {
		return instance;	
	}
	@Override
	public String read(String filePath) throws IOException {
		Path p1=Paths.get(filePath);
		byte [] arr=Files.readAllBytes(p1);
		return new String(arr);
		
	}

}
