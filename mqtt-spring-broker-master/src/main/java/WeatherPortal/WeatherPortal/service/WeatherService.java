package WeatherPortal.WeatherPortal.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import WeatherPortal.WeatherPortal.MqttConnection.MqttPublisherImpl;
@Service
public class WeatherService {

private final MqttPublisherImpl publischer = new MqttPublisherImpl();
	
 public void getWeatherDAta() {
		try {
			String apiKey = System.getenv("WEATHER_API_KEY");
			if (apiKey == null || apiKey.isBlank()) {
				return;
			}
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://weather-by-api-ninjas.p.rapidapi.com/v1/weather?city=Seattle"))
					.header("X-RapidAPI-Key", apiKey)
					.header("X-RapidAPI-Host", "weather-by-api-ninjas.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
				HttpResponse<String> response;
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			publischer.publishMessage("weather", response.body());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Weather request interrupted", e);
		} catch (IOException e) {
			throw new RuntimeException("Failed to fetch weather data", e);
		}
 }
}
