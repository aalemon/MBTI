package com.javakc.mbti.dao.factory;

import com.javakc.mbti.dao.Dao;
import com.javakc.mbti.dao.impl.DaoImpl;

public class DaoFactory {
   public static Dao getDao() {
	return DaoImpl.getInstance();
}
}
