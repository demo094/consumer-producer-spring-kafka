package com.sample.consumer.listeners.impl;

import com.sample.common.model.ConsoleLog;
import com.sample.consumer.listeners.IKafkaListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by demo094 on 2019-04-02.
 */
@Service
public class ConsoleLogListener implements IKafkaListener<ConsoleLog> {
	private static final Logger logger = Logger.getLogger(ConsoleLogListener.class.getName());

	@Override
	@KafkaListener(topics = "${custom-topics.log}", containerFactory = "consoleLogKafkaListenerContainerFactory")
	public void onReceive(ConsoleLog dto) {
		logger.info("Logging " + dto.getText());
	}
}
