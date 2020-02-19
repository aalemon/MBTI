package com.javakc.mbti.service;

import java.io.IOException;
import java.util.List;

import com.javakc.mbti.vo.Question;
import com.javakc.mbti.vo.Result;

public interface Service {
	public List<Question> readQuestion()throws IOException;
    public String parseResult(List<String> r)throws IOException;

}
