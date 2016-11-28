package resource;

import javax.management.RuntimeErrorException;

public class Resource implements Componentable{
	private final String mResourceName;
	private Componentable mComponentable;
	protected Resource(Componentable component, String resourceName) {
		setResourceName(resourceName);
		mResourceName = resourceName;
		mComponentable = component;
	}

	public String getResourceName() {
		if (mResourceName == null) {
			throw new RuntimeErrorException(null, "Please setName");
		}
		return mResourceName;
	}

	private void setResourceName(String resourceName) {
		if (resourceName == null || resourceName.length() == 0) 
			throw new RuntimeErrorException(null,"resourceName can not be empty");		
	}

	@Override
	public String toString() {
		return  mResourceName + "\":" + mComponentable.toString();
	}
}
