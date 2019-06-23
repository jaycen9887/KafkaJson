package com.kafka.constants;

import javax.annotation.Resource;

public class Constants {
		// false = local / true = SSL
		public final static boolean DEV = false;

		public final static String KAFKA_SERVER = "127.0.0.1:9092";

		public final static String KAFKA_SERVER_LIST = "";

		public final static String KAFKA_TOPIC = "menu";
		
		public final static String CLIENT_ID = "menu-client";

		public final static String GROUP_ID = "menu-group";

		public final static boolean AUTO_COMMIT_CONFIG = false;

		public final static String OFFSET_RESET = "latest";
		
		public final static String JSON_FILE = Resource.class.getClass().getResource("/menu.json").toString().substring(5);

		// SSL SETTINGS

		public final static String KEYSTORE_LOCATION = "";

		public final static String TRUSTSTORE_LOCATION = "";

		public final static String KEYSTORE_PASSWORD = "";

		public final static String TRUSTSTORE_PASSWORD = "";

		public final static String KEY_PASSWORD = "";

		public final static String KAFKA_PROTOCOL = "SSL";

		public final static String SSL_PROTOCOL = "SSL";
}
