package test;

import ec2.securitygroup.SecurityGroups;
import resource.Template;
import s3.Buckets;

public class TestS3 {

	public static void main(String[] args) {
		Template template = Template.getTemplate();
		
		Buckets buckets = Buckets.getBuckets();
		SecurityGroups securityGroups = SecurityGroups.getSecurityGroups();

		buckets.setBucketName("abc-edu-123-321-456");
		buckets.setAccessControl("PublicRead");
		template.addResource("S3BucketForWebsiteContent", buckets);
		System.out.println(template);
	}

}
