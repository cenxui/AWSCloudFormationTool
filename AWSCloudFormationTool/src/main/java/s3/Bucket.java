package s3;

import java.util.List;

import resource.Component;

public class Bucket extends Component {
	
	public final String Type = "AWS::S3::Bucket";
	
	private final Properties Properties = new Properties();
	
	private class Properties {
		@SuppressWarnings("unused")
		String AccessControl;
		@SuppressWarnings("unused")
		String BucketName;
		@SuppressWarnings("unused")
		String CorsConfiguration;
		String LifecycleConfiguration;
		String LoggingConfiguration;
		String NotificationConfiguration;
		String ReplicationConfiguration;
		List<String> Tags;
		String VersioningConfiguration;
		String WebsiteConfiguration;
	}
	
	public void setAccessControl(String accessControl) {
		Properties.AccessControl = accessControl;
	}
	
	public void setBucketName(String bucketName) {
		Properties.BucketName = bucketName;
	}
	
	public void setCorsConfiguration(String corsConfiguration) {
		Properties.CorsConfiguration = corsConfiguration;
	}
	
	
}
