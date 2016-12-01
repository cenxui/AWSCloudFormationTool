package test;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClient;
import com.amazonaws.services.cloudformation.model.CreateChangeSetRequest;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;

import dynamodb.AttributeType;
import dynamodb.Tables;
import resource.Template;

public class TestCloudFormation {

	public static void main(String[] args) {
		AWSCredentials awsCredentials = getCredentials();
		AmazonCloudFormationClient client = new AmazonCloudFormationClient(awsCredentials);
		Region apNorthEast2 = Region.getRegion(Regions.AP_NORTHEAST_1);
		client.setRegion(apNorthEast2);
		
		CreateStackRequest request = new CreateStackRequest();
		Tables tables = Tables.getTables();
		tables.addAttribute("id1", AttributeType.N);
		tables.addAttribute("name1", AttributeType.S);
		tables.setHashKey("id1");
		tables.setRangeKey("name1");
		tables.setReadCapacityUnits(1);
		tables.setWriteCapacityUnits(1);
		tables.setTableName("test1");
		Template template = Template.getTemplate();
		template.addResource("MyTable1", tables);
		request.setStackName("MyCloudFromation1");
		request.setTemplateBody(template.toString());
		client.createStack(request);

	}
	
	
	
	
	private static AWSCredentials getCredentials() {
		/*
		 * The ProfileCredentialsProvider will return your [CKmates (Tokyo)]
		 * credential profile by reading from the credentials file located at
		 * (/Users/cenxui/.aws/credentials).
		 */
		AWSCredentials credentials = null;
		try {
			credentials = new ProfileCredentialsProvider("CKmates (Tokyo)").getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (/Users/cenxui/.aws/credentials), and is in valid format.", e);
		}
		return credentials;
	}
		
}
