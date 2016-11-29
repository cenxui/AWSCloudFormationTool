package resource;

import com.google.gson.Gson;

/**
 * 
 * @author cenxui
 * 
 */
public abstract class Component {
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	/**
	 * This method run validate method to check this component,
	 *  before returning toString.  
	 * @return the validate component
	 */
	
	public String toComponent() {
		validate();
		return toString();
	}
	
	/**
	 * this method is used to check if this component is validate or not.
	 * Please implement it for checking the component is validate.
	 */
	abstract protected void validate();

}
