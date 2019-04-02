package com.sample.consumer.listeners.impl;

import com.sample.common.model.SaveObject;
import com.sample.consumer.domain.SimpleContent;
import com.sample.consumer.listeners.IKafkaListener;
import com.sample.consumer.repository.SimpleContentRepository;
import com.sample.consumer.service.IFileSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by demo094 on 2019-04-02.
 */
@Service
public class SaveListenerListener implements IKafkaListener<SaveObject> {

	@Autowired
	private IFileSaveService fileSaveService;
	@Autowired
	private SimpleContentRepository simpleContentRepository;

	@Override
	@KafkaListener(topics = "${custom-topics.save}", containerFactory = "saveKafkaListenerContainerFactory")
	public void onReceive(SaveObject dto) {
		switch (dto.getSaveType()) {
			case FILE:
				fileSaveService.save(dto.getContent());
				break;
			case DATABASE:
				simpleContentRepository.save(new SimpleContent(dto.getContent()));
				break;
			default:
				throw new IllegalArgumentException("Passed type " + dto.getSaveType() + " not supported!");
		}

	}
}
