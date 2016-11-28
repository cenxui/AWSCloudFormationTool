package ec2.natgateway;

import resource.Resource;

/**
 * 
 * @author xenxui
 * 2016/7/22
 */
public class NatGateways extends Resource {
	private final NatGateway mNatGateway;

	private NatGateways(NatGateway component, String resourceName) {
		super(component, resourceName);
		mNatGateway = component;
	}
	
	public NatGateways getNatGatways(String resourceName) {
		final NatGateway natGateway = new NatGateway();
		final NatGateways natGateways = new NatGateways(natGateway, resourceName);
		return natGateways;
	}
	
	public void setSubnetId(String subnetId) {
		mNatGateway.setSubnetId(subnetId);
	}
	
	public void setSubnetIdRf(String subnetIdRf) {
		mNatGateway.setSubnetIdRf(subnetIdRf);
	}
	
	public void setAllocationId(String allocationId) {
		mNatGateway.setAllocationId(allocationId);
	}
	
	public void setAllocationIdRf(String allocationIdRf) {
		mNatGateway.setAllocationIdRf(allocationIdRf);
	}
}
