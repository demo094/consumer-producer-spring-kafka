package com.sample.consumer.configuration.consumers;

import com.sample.common.model.SaveObject;
import com.sample.consumer.configuration.GlobalConsumerConfiguration;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * Created by demo094 on 2019-04-02.
 */
@Configuration
public class SaveObjectConsumerConfiguration {

	@Autowired
	private GlobalConsumerConfiguration consumerConfigs;

	@Bean
	public ConsumerFactory<String, SaveObject> saveConsumerFactory() {
		return new DefaultKafkaConsumerFactory<>(
				consumerConfigs.consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(SaveObject.class)
		);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, SaveObject> saveKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, SaveObject> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(saveConsumerFactory());
		return factory;
	}

}
