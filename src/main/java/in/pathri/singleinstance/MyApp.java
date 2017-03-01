package in.pathri.singleinstance;

import java.util.Scanner;

public class MyApp {
	public static final String appId = "in.pathri.singleinstance.MyApp";
	private Scanner input;
	private static MyApp myApp = new MyApp("init");;
		
	public MyApp(String msg) {
		 input = new Scanner(System.in);
		System.out.println("Init msg::" + msg);
	}
	
	public static void recieveMessage(String msg){
		System.out.println("Recieved msg::" + msg);
		myApp.waitForExit();
	}
	
	public void waitForExit(){
		input.nextLine();
		input.close();
	}
}
