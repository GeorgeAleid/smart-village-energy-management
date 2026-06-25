package com.renewableenergy.SHS.Models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WeatherData {
	public double cloud_pct;
	public double temp;
	public double feels_like;
	public double humidity;
	public double min_temp;
	public double max_temp;
	public double wind_speed;
	public double wind_degrees;
	public long sunrise;
	public long sunset;
	WeatherData(){
	}
	
	public LocalDateTime getSunRiseConv() {
		Instant instant = Instant.ofEpochSecond(this.sunrise);
		return  LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
	public LocalDateTime getSunSetConv() {
		Instant instant = Instant.ofEpochSecond(this.sunset);
		return  LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
	public double getCloud_pct() {
		return cloud_pct;
	}
	public void setCloud_pct(double cloud_pct) {
		this.cloud_pct = cloud_pct;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getMin_temp() {
		return min_temp;
	}
	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}
	public double getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
	}
	public double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public double getWind_degrees() {
		return wind_degrees;
	}
	public void setWind_degrees(double wind_degrees) {
		this.wind_degrees = wind_degrees;
	}
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	@Override
	public String toString() {
		return "WeatherData [cloud_pct=" + cloud_pct + ", temp=" + temp + ", feels_like=" + feels_like + ", humidity="
				+ humidity + ", min_temp=" + min_temp + ", max_temp=" + max_temp + ", wind_speed=" + wind_speed
				+ ", wind_degrees=" + wind_degrees + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}
	
//	public String lat;
//	public String lon;
//	public int elevation;
//	public String timezone;
//	public String units;
//	public Current current;
//	
//	public class Current{
//		public Wind wind;
//		public String icon;
//		public int icon_num;
//		public String summary;
//		public int temperature;
//		public int feels_like;
//		public int wind_chill;
//		public int dew_point;
//	}
//	public class Wind{
//		public double speed;
//		public double gusts;
//		public double angle;
//		public String dir;
//       
//	}
//	@Override
//	public String toString() {
//		return "WeatherData [lat=" + lat + ", lon=" + lon + ", elevation=" + elevation + ", timezone=" + timezone
//				+ ", units=" + units + ", current=" + current + "]";
//	}
	
	
}
