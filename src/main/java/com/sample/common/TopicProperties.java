package com.sample.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by demo094 on 2019-04-02.
 */
@Component
public class TopicProperties {
	@Value("${custom-topics.group-id}")
	private String groupId;
	@Value("${custom-topics.log}")
	private String logTopic;
	@Value("${custom-topics.save}")
	private String saveTopic;
	@Value("${custom-topics.reject}")
	private String rejectTopic;
	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLogTopic() {
		return logTopic;
	}

	public void setLogTopic(String logTopic) {
		this.logTopic = logTopic;
	}

	public String getSaveTopic() {
		return saveTopic;
	}

	public void setSaveTopic(String saveTopic) {
		this.saveTopic = saveTopic;
	}

	public String getRejectTopic() {
		return rejectTopic;
	}

	public void setRejectTopic(String rejectTopic) {
		this.rejectTopic = rejectTopic;
	}
}
