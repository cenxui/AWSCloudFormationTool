package ec2.instance;

import ec2.securitygroup.SecurityGroups;

/**
 * 
 * @author xenxui
 * 2016/7/21
 */
public interface SecurityGroupable {
	SecurityGroupable addSecurityGroup(SecurityGroups securityGroups);
}
