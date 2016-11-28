package iam.user;

import iam.Policiable;
import iam.PolicyArnable;
import resource.Resource;

public class Users extends Resource implements Groupable, PolicyArnable, Policiable {
	private final User mUser;
	private Users(User component, String resourceName) {
		super(component, resourceName);
		mUser = component;
	}
	
	public static Users getUsers(String resourceName) {
		final User user = new User();
		final Users users = new Users(user, resourceName);
		return users;
	}
	
	public Groupable addGroup(String group) {
		mUser.addGroup(group);
		return this;
	}
	
	public void setLoginProfile(String loginProfile) {
		mUser.setLoginProfile(loginProfile);
	}
	
	public PolicyArnable addManagedPolicyArn(String managedPolicyArn) {
		mUser.addManagedPolicyArn(managedPolicyArn);
		return null;
	}
	
	public void setPath(String path) {
		mUser.setPath(path);
	}
	
	public Policiable addPolicy(String policy) {
		mUser.addPolicy(policy);
		return this;
	}
	
	public void setUserName(String userName) {
		mUser.setUserName(userName);
	}
}
