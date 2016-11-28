package s3;

import java.util.ArrayList;
import java.util.List;

import resource.Component;

class Bucket extends Component {
	
	public final String Type = "AWS::S3::Bucket";
	
	private final Properties Properties = new Properties();
	
	private class Properties {
		@SuppressWarnings("unused")
		String AccessControl;
		@SuppressWarnings("unused")
		String BucketName;
		@SuppressWarnings("unused")
		String CorsConfiguration;
		@SuppressWarnings("unused")
		String LifecycleConfiguration;
		@SuppressWarnings("unused")
		String LoggingConfiguration;
		@SuppressWarnings("unused")
		String NotificationConfiguration;
		@SuppressWarnings("unused")
		String ReplicationConfiguration;
		List<String> Tags;
		@SuppressWarnings("unused")
		String VersioningConfiguration;
		@SuppressWarnings("unused")
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
	
	public void setLifecycleConfiguration(String lifecycleConfiguration) {
		Properties.LifecycleConfiguration = lifecycleConfiguration;
	}
	
	public void setLoggingConfiguration(String loggingConfiguration) {
		Properties.LoggingConfiguration = loggingConfiguration;
	}
	
	public void setNotificationConfiguration(String notificationConfiguration) {
		Properties.NotificationConfiguration = notificationConfiguration;
	}
	
	public void setReplicationConfiguration(String replicationConfiguration) {
		Properties.ReplicationConfiguration = replicationConfiguration;
	}
	
	public void setVersioningConfiguration(String versioningConfiguration) {
		Properties.VersioningConfiguration = versioningConfiguration;
	}
	
	public void setWebsiteConfiguration(String websiteConfiguration) {
		Properties.WebsiteConfiguration = websiteConfiguration;
	}
	
	public Bucket addTags(String tag) {
		if (Properties.Tags == null) {
			Properties.Tags = new ArrayList<>();
		}
		Properties.Tags.add(tag);
		return this;
	}
}
