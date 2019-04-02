package com.sample.consumer.configuration.consumers;

import com.sample.common.model.RejectObject;
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
public class RejectConsumerConfiguration {

	@Autowired
	private GlobalConsumerConfiguration consumerConfigs;

	@Bean
	public ConsumerFactory<String, RejectObject> rejectConsumerFactory() {
		return new DefaultKafkaConsumerFactory<>(
				consumerConfigs.consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(RejectObject.class)
		);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, RejectObject> rejectKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, RejectObject> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(rejectConsumerFactory());
		return factory;
	}

}
