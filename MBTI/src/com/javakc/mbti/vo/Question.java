package com.javakc.mbti.vo;
import java.util.List;

public class Question {
	private int num;//��Ŀ���
	private String title;//��Ŀ����
    private List<Option> options;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}


   
}


