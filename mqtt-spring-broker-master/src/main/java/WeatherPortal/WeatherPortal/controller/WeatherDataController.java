package WeatherPortal.WeatherPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WeatherPortal.WeatherPortal.MqttConnection.MqttPublisherImpl;
import WeatherPortal.WeatherPortal.MqttConnection.MqttSubscriberImpl;
import WeatherPortal.WeatherPortal.service.WeatherService;

@RestController
@RequestMapping(value = "api/v1")
public class WeatherDataController {
	@Autowired
	private WeatherService ws;
	
	public WeatherDataController(WeatherService ws) {
		this.ws = ws;
	}
	@GetMapping(value = "/weather-show")
	@CrossOrigin("*") 
	public String getWeatherData() {
		this.ws.getWeatherDAta();
		return "Done";
	}
}
