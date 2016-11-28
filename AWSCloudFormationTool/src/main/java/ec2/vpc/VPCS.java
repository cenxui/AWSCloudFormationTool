package ec2.vpc;

import resource.Resource;
import resource.Tagable;

/**
 * 
 * @author xenxui
 * 2016/7/22
 */
public class VPCS extends Resource implements Tagable {	
	public static final String DEFAULT = "default";
	public static final String DEDICATE = "dedicate";
	
	private final VPC mVPC; 

	private VPCS(VPC component, String resourceName) {
		super(component, resourceName);
		mVPC = component;
	}
	
	public static final VPCS getVPC(String resourceName) {
		VPC vpc = new VPC();
		VPCS vpcs = new VPCS(vpc, resourceName);
		return vpcs;
	}
	
	public void setCidrBlock(String cidrBlock) {
		mVPC.setCidrBlock(cidrBlock);
	}
	
	public void setEnableDnsHostnames(boolean enableDnsHostnames) {
		mVPC.setEnableDnsHostnames(enableDnsHostnames);
	}
	
	public void setEnableDnsSupport(boolean enableDnsSupport) {
		mVPC.setEnableDnsSupport(enableDnsSupport);
	}
	
	public void setInstanceTenancy(String instanceTenancy) {
		mVPC.setInstanceTenancy(instanceTenancy);
	}
	
	@Override
	public Tagable addTag(String tag) {
		mVPC.addTag(tag);
		return this;
	}
}
