package resource;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

/**
 * 
 * @author cenxui
 * 2016/12/1
 */

public class Template {
	@SuppressWarnings("unused")
	private String  AWSTemplateFormatVersion =  "2010-09-09";
	
	private Map<String, Component> Resources = new TreeMap<>();
	
	private Map<String, Object> Outputs = new TreeMap<>();
	
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
		
		Resources.put(name, resource.mComponent);
		
		Map<String, Object> output = resource.getOutput();
		
		if (output != null && output.isEmpty() == false) {
			Outputs.putAll(output);
		}

	}
	
	@Override
	public String toString() {
		if (Outputs.isEmpty()) {
			Outputs = null;
		}
		return new Gson().toJson(this) ;
	}
	
}
