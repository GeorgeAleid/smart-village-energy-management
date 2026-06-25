package congif;

import java.util.Timer;
import java.util.TimerTask;

import com.renewableenergy.SGS.service.TarifService;



public class Scheduler {
	 Timer timer;
	 int delay = 5000;   // delay for 5 sec.
	 int period = 5000 * 100; 
	 TarifService service = new TarifService();

	    public Scheduler() {
	        timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() {
	                
	            	service.getTarif();
	            }
	        }, delay, period);
	    }

	    class RemindTask extends TimerTask {
	        public void run() {
	        	
	            timer.cancel(); //Terminate the timer thread
	        }
	    }
}
