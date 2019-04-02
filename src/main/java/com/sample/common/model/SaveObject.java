package com.sample.common.model;

import com.sample.common.model.enums.SaveTypeEnum;

/**
 * Created by demo094 on 2019-03-31.
 */
public class SaveObject {

	private SaveTypeEnum saveType;
	private String content;

	public SaveObject() {
	}

	public SaveObject(SaveTypeEnum saveType, String content) {
		this.saveType = saveType;
		this.content = content;
	}

	public SaveTypeEnum getSaveType() {
		return saveType;
	}

	public void setSaveType(SaveTypeEnum saveType) {
		this.saveType = saveType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SaveObject{" +
				"saveType=" + saveType +
				", content='" + content + '\'' +
				'}';
	}
}
