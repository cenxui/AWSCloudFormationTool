package sns;

import resource.Resource;

/**
 * 
 * @author xenxui
 * 2016/7/23
 */
public class Topics extends Resource implements Subscriptionable {
	private final Topic mSns;

	private Topics(Topic component, String resourceName) {
		super(component, resourceName);
		mSns = component;
	}
	
	
	/**
	 * 
	 * @return the SNSS instance
	 */
	public static Topics getTopic(String resourceName) {
		Topic sns = new Topic();
		Topics snss = new Topics(sns, resourceName);
		return snss;
	}
	
	public void setDisplayName(String displayName) {
		mSns.setDisplayName(displayName);
	}
	
	public void setTopicName(String topicName) {
		mSns.setTopicName(topicName);
	}

	@Override
	public Subscriptionable addSubscription(String subscription) {
		mSns.addSubscription(subscription);
		return this;
	}
}
