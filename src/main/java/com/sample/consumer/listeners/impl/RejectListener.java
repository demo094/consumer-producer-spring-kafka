package com.sample.consumer.listeners.impl;

import com.sample.common.model.RejectObject;
import com.sample.consumer.listeners.IKafkaListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by demo094 on 2019-04-02.
 */
@Service
public class RejectListener implements IKafkaListener<RejectObject> {
	private static final Logger logger = Logger.getLogger(RejectListener.class.getName());

	@Override
	@KafkaListener(topics = "${custom-topics.reject}", containerFactory = "rejectKafkaListenerContainerFactory")
	public void onReceive(RejectObject dto) {
		throw new IllegalArgumentException("REJECTING OBJECT, " + dto);
	}
}
