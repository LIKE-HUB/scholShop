package com.like.schoolShop.dto;

import java.util.List;

import com.like.schoolShop.entity.HeadLine;
import com.like.schoolShop.enums.HeadLineStateEnum;

public class HeadLineExecution {

	private int state;
	private String stateInfo;
	private int count;
	private HeadLine headLine;
	private List<HeadLine> headLineList;

	public HeadLineExecution() {
	}

	// 失败的构造器
	public HeadLineExecution(HeadLineStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public HeadLineExecution(HeadLineStateEnum stateEnum, HeadLine headLine) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.headLine = headLine;
	}

	// 成功的构造器
	public HeadLineExecution(HeadLineStateEnum stateEnum, List<HeadLine> headLineList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.headLineList = headLineList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public HeadLine getHeadLine() {
		return headLine;
	}

	public void setHeadLine(HeadLine headLine) {
		this.headLine = headLine;
	}

	public List<HeadLine> getHeadLineList() {
		return headLineList;
	}

	public void setHeadLineList(List<HeadLine> headLineList) {
		this.headLineList = headLineList;
	}

}
