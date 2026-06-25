package com.renewableenergy.SHS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.renewableenergy.SHS.MQTT.MqttSubscriberImpl;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.SmartMeterService;

@SpringBootApplication
public class ShsApplication {
	public static SmartMeter sm;
	public static SmartHome sh;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShsApplication.class, args);

		SmartHomeService shs = context.getBean(SmartHomeService.class);
		sh = new SmartHome("smartHome", "Dortmund");
		shs.addSmartHomeObjekt(sh);

		SmartMeterService sms = context.getBean(SmartMeterService.class);
		sm = new SmartMeter("SmartMeter");
		sms.addSmartMeterObjekt(sm);
		sh.attach(sm);

		MqttSubscriberImpl subscriber = new MqttSubscriberImpl();
		subscriber.subscribeMessage("weather");
		subscriber.subscribeMessage("Tarif");
	}
}
