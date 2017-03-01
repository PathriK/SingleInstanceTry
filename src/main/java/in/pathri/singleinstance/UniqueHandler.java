package in.pathri.singleinstance;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;

public class UniqueHandler {
	static String appId = MyApp.appId;
	public static void main(String[] args) {
		System.out.println("Into Handler");
		boolean alreadyRunning;
		try {
			JUnique.acquireLock(appId);
			alreadyRunning = false;
		} catch (AlreadyLockedException e) {
			alreadyRunning = true;
		}
		if (!alreadyRunning) {
			System.out.println("App NOT already running");			
		}else{
			System.out.println("App already running");
		}
	}
}
