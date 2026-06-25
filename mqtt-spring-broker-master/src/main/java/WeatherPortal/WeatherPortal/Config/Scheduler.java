package WeatherPortal.WeatherPortal.Config;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import WeatherPortal.WeatherPortal.service.WeatherService;

public class Scheduler {
	 Timer timer;
	 int delay = 5000;   // delay for 5 sec.
	 int period = 5000 * 100; 
	 WeatherService service = new WeatherService();

	    public Scheduler() {
	        timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() {
	                // Task here ...
	            	service.getWeatherDAta();
	            }
	        }, delay, period);
	    }

	    class RemindTask extends TimerTask {
	        public void run() {
	        	
	            timer.cancel(); //Terminate the timer thread
	        }
	    }
}
