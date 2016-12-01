package resource;

import java.util.Map;

/**
 * This method is used as a delegate for component.
 * 
 * @author cenxui
 * 2016/10/23
 */
public class Resource {
	final Component mComponent;
	
	protected Resource(Component component) {
		mComponent = component;
	}
	
	protected Map<String, Object> getOutput() {
		return null;
	}

	@Override
	public String toString() {
		return  mComponent.toComponent();
	}
}
