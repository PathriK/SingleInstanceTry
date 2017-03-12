package in.pathri.singleinstance;

import net.minidev.json.JSONObject;

public class MyApp {
	public static final String appId = "in.pathri.singleinstance.MyApp";
	// private Scanner input;
	// private static MyApp myApp = new MyApp("init");
	private MyData myData;

	public MyApp(MyData msg) {
		// input = new Scanner(System.in);
		this.myData = msg;
		System.out.println("Init msg::" + Thread.currentThread().getId());
		// init();
	}

	public void init() {
		try {
			synchronized (myData) {
				System.out.println("before waiting" + Thread.currentThread().getId());
				myData.wait();
				System.out.println("after waiting" + myData.getMyData() + Thread.currentThread().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String recieveMessage(String msg) {
		//System.out.println("Recieved msg::" + msg + Thread.currentThread().getId());
		NativeMessagingHelper.log("Recieved msg::" + msg + Thread.currentThread().getId());
		String hasError = "true";
		try {
			synchronized (myData) {
				myData.setMyData(msg);
				JSONObject val = myData.getMyData();
				NativeMessagingHelper.log("JSON val msg::" + val.toJSONString() + Thread.currentThread().getId());
				if(val.containsKey("song_ids") && val.containsKey("album_ids")){
					hasError = "false";
					myData.notify();
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.waitForExit();
		return hasError;
	}

	// public void waitForExit() {
	// System.out.println("waiting for input" + Thread.currentThread().getId());
	// // input.nextLine();
	// // input.close();
	// }
}
