package resource;

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

	@Override
	public String toString() {
		return  mComponent.toComponent();
	}
}
