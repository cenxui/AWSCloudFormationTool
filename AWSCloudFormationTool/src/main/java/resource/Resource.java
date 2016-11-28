package resource;

public class Resource {
	final Componentable mComponentable;
	
	protected Resource(Componentable component) {
		mComponentable = component;
	}

	@Override
	public String toString() {
		return  mComponentable.toString();
	}
}
