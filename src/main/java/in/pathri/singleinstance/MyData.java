package in.pathri.singleinstance;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class MyData {
	private JSONObject myMsg;

	public JSONObject getMyData() {
		return myMsg;
	}

	public void setMyData(String myData) throws ParseException {
		JSONObject jsonObj = (JSONObject) JSONValue.parseWithException(myData);
		this.myMsg = jsonObj;
	}
}
