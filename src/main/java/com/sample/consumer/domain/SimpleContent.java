package com.sample.consumer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by demo094 on 2019-04-02.
 */
@Entity
@Table(name = "simple_content")
public class SimpleContent {
	@Id
	private String id;
	@Column
	private String content;

	public SimpleContent() {
		this.id = UUID.randomUUID().toString();
	}

	public SimpleContent(String content) {
		this();
		this.content = content;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SimpleContent)) {
			return false;
		}
		SimpleContent other = (SimpleContent) obj;
		return getId().equals(other.getId()) &&
				getContent().equals(other.getContent());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
