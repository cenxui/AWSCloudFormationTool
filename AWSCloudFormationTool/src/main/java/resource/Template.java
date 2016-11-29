package resource;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class Template {
	@SuppressWarnings("unused")
	private String  AWSTemplateFormatVersion =  "2010-09-09";
	
	private Map<String, Componentable> Resources = new HashMap<>();  
	
	private Template() {
		
	}
	
	public static Template getTemplate() {
		return new Template();
	}
	
	public void addResource(String name, Resource resource) {
		if (name == null || name.length() == 0 ) {
			throw new RuntimeException("name can not be empty");
		}
		
		if (Resources.containsKey(name)) {
			throw new RuntimeException("each resource name must unique");
		}
		
		Resources.put(name, resource.mComponentable);
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this) ;
	}
}
