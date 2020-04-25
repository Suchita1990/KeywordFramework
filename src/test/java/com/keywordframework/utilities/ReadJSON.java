package com.keywordframework.utilities;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {

		public static JSONArray topics;
		public static String readJSONfile(String topicname) {

			JSONParser parser = new JSONParser();
			try {
				Object unitObj = parser.parse(new FileReader("E:\\Eclipse Workspace\\keywords\\src\\main\\resources\\ExpectedHelpTopics.json"));
				JSONObject jObject = (JSONObject) unitObj;
				JSONArray jArray = (JSONArray) jObject.get(topicname);
				System.out.println(jArray);
				for (int i = 0; i < jArray.size(); i++) {
					System.out.println(jArray.get(i));
				}	

			} catch (Exception e) {
				e.printStackTrace();
			}
			return topicname;
		}

	}


