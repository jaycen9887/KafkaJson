package com.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.constants.Constants;
import com.kafka.model.Menu;

public class KafkaProducerConfig {
	
	public static Map<String, Object> producerConfig(){
		Map<String, Object> props = new HashMap<>();
		
		if(Constants.DEV) {
			props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_SERVER_LIST);
			props.put("security.protocol", Constants.KAFKA_PROTOCOL);
			props.put(SslConfigs.SSL_PROTOCOL_CONFIG, Constants.SSL_PROTOCOL);
			props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, Constants.TRUSTSTORE_LOCATION);
			props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, Constants.KEYSTORE_LOCATION);
			props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, Constants.TRUSTSTORE_PASSWORD);
			props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, Constants.KEYSTORE_PASSWORD);
			props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, Constants.KEY_PASSWORD);
		} else {
			props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_SERVER);
		}
		
		props.put(ProducerConfig.CLIENT_ID_CONFIG, Constants.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		
		return props;
	}
	
	public static ProducerFactory<String, Menu> producerFactory() {
		JsonSerializer<Menu> jsonSerializer = new JsonSerializer<>();
		jsonSerializer.setAddTypeInfo(false);
		return new DefaultKafkaProducerFactory<String, Menu>(producerConfig(), Serdes.String().serializer(), jsonSerializer);
	}
	
	public static KafkaTemplate<String, Menu> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
