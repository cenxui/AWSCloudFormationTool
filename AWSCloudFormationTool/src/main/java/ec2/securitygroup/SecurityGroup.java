package ec2.securitygroup;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import intrinsic.Ref;
import resource.Component;

/**
 * This class is to build the security properties in JSON format
 * implement Componentable is to make component properties result to
 * add in Resouce format. 
 * @author xenxui
 *
 */

final class SecurityGroup extends Component {
	public static final String TCP = "tcp";
	
	public final String Type = "AWS::EC2::SecurityGroup";
		
	private final Properties Properties = new Properties();
	
	public void setVpcId(String id) {
		if (Properties.VpcId != null) {
			throw new RuntimeErrorException(null, "You can only either setVpcId or setVpcRf for once");
		}
		Properties.VpcId = id;
	}
	
	public void setVpcRf(String rf) {
		if (Properties.VpcId != null) {
			throw new RuntimeErrorException(null, "You can only either setVpcId or setVpcRf for once");
		}
		Properties.VpcId = new Ref(rf);
	}
	
	public void setGroupDescription(String description) {
		Properties.GroupDescription = description;
	}
	
	public OutBoundRule setSecurityGroupEgress() {
		if (Properties.SecurityGroupEgress == null) {
			Properties.SecurityGroupEgress = new ArrayList<>();
		}
		
		OutBoundRule OutBoundRule = new OutBoundRule();
		Properties.SecurityGroupEgress.add(OutBoundRule);
		return OutBoundRule;
	}
	
	public InBoundRule setSecurityGroupIngress() {
		if (Properties.SecurityGroupIngress == null) {
			Properties.SecurityGroupIngress = new ArrayList<>();
		}
		InBoundRule inBoundRule = new InBoundRule();
		Properties.SecurityGroupIngress.add(inBoundRule);
		return inBoundRule;
	}
	
	public SecurityGroup addTag(String tag) {
		if (Properties.Tag == null) {
			Properties.Tag = new ArrayList<>();
		}
		Properties.Tag.add(tag);
		return this;
	}
	
	private class Properties {
		String GroupDescription;
		Object VpcId;
		List<OutBoundRule> SecurityGroupEgress;
		List<InBoundRule> SecurityGroupIngress;	
		List<String> Tag;	
	}
	
	public final class OutBoundRule {
		@SuppressWarnings("unused")
		private String DestinationSecurityGroupId;
		@SuppressWarnings("unused")
		private String GroupId;
		@SuppressWarnings("unused")
		private String IpProtocol;
		@SuppressWarnings("unused")
		private String CidrIp;
		@SuppressWarnings("unused")
		private int FromPort;
		@SuppressWarnings("unused")
		private int ToPort;
		
		public OutBoundRule setDefaultHttp() {
			IpProtocol = TCP;
			FromPort = 80;
			ToPort = 80;
			return this;
		}
		
		public OutBoundRule setDefaultHttps() {
			IpProtocol = TCP;
			FromPort = 443;
			ToPort = 443;
			return this;
		}			
		
		public OutBoundRule setCidrIp(String cidrIp) {
			CidrIp = cidrIp;
			return this;
		}
		
		public OutBoundRule setFromPort(int fromPort) {
			if (fromPort<0||fromPort>65535) {
				throw new RuntimeErrorException(null, "Error FromPort range");
			}
			
			FromPort = fromPort;
			return this;
		}
		
		public OutBoundRule setToPort(int toPort) {			
			if (toPort<0||toPort>65535) {
				throw new RuntimeErrorException(null, "Error ToPort range");
			}
			ToPort = toPort;
			return this;
		}
		
		public OutBoundRule setIpProtocol(String ipProtocol) {
			IpProtocol = ipProtocol;
			return this;
		}

		public OutBoundRule setDestinationSecurityGroupId(String destinationSecurityGroupId) {
			DestinationSecurityGroupId = destinationSecurityGroupId;
			return this;
		}

		public OutBoundRule setGroupId(String groupId) {
			GroupId = groupId;
			return this;
		}

		public OutBoundRule addMoreRule() {
			OutBoundRule rule = new OutBoundRule();
			Properties.SecurityGroupEgress.add(rule);
			return rule;
		}
	}
	
	public final class InBoundRule {
		@SuppressWarnings("unused")
		private String GroupId;
		@SuppressWarnings("unused")
		private String GroupName;
		@SuppressWarnings("unused")
		private String SourceSecurityGroupName;
		@SuppressWarnings("unused")
		private String SourceSecurityGroupId;
		@SuppressWarnings("unused")
		private String SourceSecurityGroupOwnerId;
		
		@SuppressWarnings("unused")
		private String IpProtocol;
		@SuppressWarnings("unused")
		private String CidrIp;
		
		private int FromPort;
		private int ToPort;
		
		public InBoundRule setGroupId(String groupId) {
			GroupId = groupId;
			return this;
		}
		
		public InBoundRule setGroupName(String groupName) {
			GroupName = groupName;
			return this;
		}
		
		public InBoundRule setSourceSecurityGroupId(String sourceSecurityGroupId) {
			SourceSecurityGroupId = sourceSecurityGroupId;
			return this;
		}
		
		public InBoundRule setSourceSecurityGroupName(String sourceSecurityGroupName) {
			SourceSecurityGroupName = sourceSecurityGroupName;
			return this;
		}
		
		public InBoundRule setSourceSecurityGroupOwnerId(String sourceSecurityGroupOwnerId) {
			SourceSecurityGroupOwnerId = sourceSecurityGroupOwnerId;
			return this;
		}
		
		public InBoundRule setDefaultHttp() {
			setIpProtocol(TCP);
			setFromPort(80);
			setToPort(80);
			return this;
		}
		
		public InBoundRule setDefaultHttps() {
			setIpProtocol(TCP);
			setFromPort(443);
			setToPort(443);
			return this;
		}
			
		public InBoundRule setCidrIp(String cidrIp) {
			CidrIp = cidrIp;
			return this;
		}
		
		public InBoundRule setFromPort(int fromPort) {
			if (fromPort<0||fromPort>65535) {
				throw new RuntimeErrorException(null, "Error FromPort range");
			}
			
			FromPort = fromPort;
			return this;
		}
		
		public InBoundRule setToPort(int toPort) {
			if (toPort<0||toPort>65535) {
				throw new RuntimeErrorException(null, "Error ToPort range");
			}
			ToPort = toPort;
			return this;
		}
		
		public InBoundRule setIpProtocol(String ipProtocol) {
			IpProtocol = ipProtocol.toLowerCase();
			return this;
		}
		
		public InBoundRule addMoreRule() {
			edit();
			InBoundRule rule = new InBoundRule();
			Properties.SecurityGroupIngress.add(rule);
			return rule;
		}
		
		private void edit() {
			if (FromPort<0||FromPort>65535) {
				throw new RuntimeErrorException(null, "Error ToPort range");
			}
			
			if (ToPort<0||ToPort>65535) {
				throw new RuntimeErrorException(null, "Error ToPort range");
			}
		}
	}

	@Override
	protected void validate() {
		if (Properties.GroupDescription == null) {
			throw new RuntimeErrorException(null,"GroupDescription can not be null");
		}
		
		if (Properties.VpcId == null) {
			throw new RuntimeErrorException(null, "VpcId can not be null");
		}
	}
	
}
