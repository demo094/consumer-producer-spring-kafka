package com.sample.producer.api.web;

import com.sample.common.TopicProperties;
import com.sample.common.model.ConsoleLog;
import com.sample.common.model.RejectObject;
import com.sample.common.model.SaveObject;
import com.sample.common.model.enums.SaveTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by demo094 on 2019-03-31.
 */
@RestController
public class ProducerPublishController {
	@Autowired
	private TopicProperties topicProperties;
	@Autowired
	private KafkaTemplate<Object, Object> template;

	@GetMapping(path = "/send/save")
	public void sendSave(@RequestParam SaveTypeEnum type, @RequestParam String content) {
		this.template.send(topicProperties.getSaveTopic(), new SaveObject(type, content));
	}

	@GetMapping(path = "/send/log")
	public void sendLogger(@RequestParam String content) {
		this.template.send(topicProperties.getLogTopic(), new ConsoleLog(content));
	}

	@GetMapping(path = "/send/reject")
	public void sendReject(@RequestParam(required = false, defaultValue = "") String content) {
		this.template.send(topicProperties.getRejectTopic(), new RejectObject(content));
	}
}
