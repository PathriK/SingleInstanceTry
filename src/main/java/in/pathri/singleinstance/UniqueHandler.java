package in.pathri.singleinstance;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;
import it.sauronsoftware.junique.MessageHandler;

public class UniqueHandler {
	static String appId = MyApp.appId;	
	public static void main(String[] args) {
		System.out.println("Into Handler");
		boolean alreadyRunning;
		try {
			JUnique.acquireLock(appId, new MessageHandler(){

				@Override
				public String handle(String msg) {
					MyApp.recieveMessage(msg);
					return null;
				}
				
			});
			alreadyRunning = false;
		} catch (AlreadyLockedException e) {
			alreadyRunning = true;
		}
		if (!alreadyRunning) {
			System.out.println("App NOT already running");
			MyApp.recieveMessage("not alredy running");
		}else{
			System.out.println("App already running");
			JUnique.sendMessage(appId,"already running");
		}
	}
}
