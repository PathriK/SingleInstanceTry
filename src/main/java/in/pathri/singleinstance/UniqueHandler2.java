//package in.pathri.singleinstance;
//
//import java.io.IOException;
//
//import it.sauronsoftware.junique.AlreadyLockedException;
//import it.sauronsoftware.junique.JUnique;
//import it.sauronsoftware.junique.MessageHandler;
//
//public class UniqueHandler2 {
//	static String appId = MyApp.appId;	
//	static MyApp myApp;
//	public static void main(String[] args) {
////		System.out.println("Into Handler" + Thread.currentThread().getId());
////		jniquetry();
//		try {
//			NativeMessagingHelper.log("Into UniqueHandler");
//			String msg = NativeMessagingHelper.readMessage(System.in);
//			NativeMessagingHelper.sendMessage("{\"errorFlag\":false," + "\"message\":\"" + "working" + "\"}");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private static void jniquetry(){
//		boolean alreadyRunning;
//		try {
//			JUnique.acquireLock(appId, new MessageHandler(){
//
//				@Override
//				public String handle(String msg) {
//					System.out.println("Into handle"  + Thread.currentThread().getId());
//					String retVal = myApp.recieveMessage(msg);
//					return "handler returned" + retVal;
//				}
//				
//			});
//			System.out.println("Setting alreadyrunning to false" + Thread.currentThread().getId());
//			alreadyRunning = false;
//		} catch (AlreadyLockedException e) {
//			System.out.println("catching exception" + Thread.currentThread().getId());
//			alreadyRunning = true;
//		}
//		if (!alreadyRunning) {
//			System.out.println("App NOT already running" + Thread.currentThread().getId());
//			myApp = new MyApp(new MyData());
//			myApp.init();
////			myApp.recieveMessage("not alredy running");
//		}else{
//			System.out.println("App already running" + Thread.currentThread().getId());
//			String retVal = JUnique.sendMessage(appId,"already running");
//			System.out.println("Send message returned" + retVal + Thread.currentThread().getId());
//		}		
//	}
//}
