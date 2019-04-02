package com.sample.consumer.listeners;

/**
 * Created by demo094 on 2019-04-02.
 */
public interface IKafkaListener<T> {

	void onReceive(T dto);

}
