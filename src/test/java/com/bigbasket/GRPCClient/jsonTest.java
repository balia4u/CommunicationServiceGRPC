/*package com.bigbasket.GRPCClient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class jsonTest {

	@Test
	public void getJSON_Body() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		JsonParser parser = new JsonParser();
		JsonElement json2=parser.parse(new JsonReader(new FileReader("C://Users//Balaram//Desktop//order.json")));
		JsonObject json= parser.parse(new JsonReader(new FileReader("C://Users//Balaram//Desktop//order.json"))).getAsJsonObject();
		System.out.println("<><><><><><>"+json.toString());
		System.out.println("<><><><><><>"+json2.toString());
		Set <Entry<String, JsonElement>> entrySet= json.entrySet();
		for(Map.Entry<String,JsonElement> entry : entrySet){
			if(entry.getValue().isJsonObject())
			System.out.println(entry.getKey() + " : " +entry.getValue());
		System.out.println(json.getAsJsonObject().get("evoucher_code"));
		//System.out.println(json);
	}
}
}
*/