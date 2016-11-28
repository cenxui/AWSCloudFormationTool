package resource;

import com.google.gson.Gson;

public class Component implements Componentable {

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
