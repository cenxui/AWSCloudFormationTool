package test;

import ec2.securitygroup.SecurityGroups;
import resource.Template;

public class TestSecurityGroup {

	public static void main(String[] args) {
		SecurityGroups securityGroups = SecurityGroups.getSecurityGroups();
		securityGroups.setVpcId("vpc-1d744878");
		securityGroups.setGroupDescription("test security group");
		securityGroups.setSecurityGroupEgress().setDefaultHttp().setCidrIp("0.0.0.0/0");
		securityGroups.setSecurityGroupIngress().setDefaultHttp().setCidrIp("0.0.0.0/0");
		
		Template template = Template.getTemplate();
		template.addResource("MyWebSG", securityGroups);
		
		System.out.println(template);
	}

}
