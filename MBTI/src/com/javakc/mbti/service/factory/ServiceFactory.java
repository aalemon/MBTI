package com.javakc.mbti.service.factory;

import com.javakc.mbti.dao.impl.DaoImpl;
import com.javakc.mbti.service.Service;
import com.javakc.mbti.service.impl.ServiceImpl;

public class ServiceFactory {

	public static Service getService() {
		return ServiceImpl.getInstance();
	}

}
