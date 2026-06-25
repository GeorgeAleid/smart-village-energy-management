package WeatherPortal.WeatherPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import WeatherPortal.WeatherPortal.Config.Scheduler;
import WeatherPortal.WeatherPortal.MqttConnection.MqttSubscriberImpl;

@SpringBootApplication
public class MqttJavaApplication extends SpringBootServletInitializer {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MqttJavaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MqttJavaApplication.class, args);
        new Scheduler();
        MqttSubscriberImpl subscriber = new MqttSubscriberImpl();
        subscriber.subscribeMessage("weather");
    }

}