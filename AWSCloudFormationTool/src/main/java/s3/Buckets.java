package s3;

import resource.Resource;
import resource.Tagable;

public class Buckets extends Resource implements Tagable {
	
	private final Bucket mBucket;

	private Buckets(Bucket component) {
		super(component);
		mBucket = component;
	}
	
	public static Buckets getBuckets() {
		final Bucket bucket = new Bucket();
		final Buckets buckets = new Buckets(bucket);
		return buckets;
	}
	
	public void setAccessControl(String accessControl) {
		mBucket.setAccessControl(accessControl);
	}
	
	public void setBucketName(String bucketName) {
		mBucket.setBucketName(bucketName);
	}
	
	public void setCorsConfiguration(String corsConfiguration) {
		mBucket.setCorsConfiguration(corsConfiguration);
	}
	
	public void setLifecycleConfiguration(String lifecycleConfiguration) {
		mBucket.setLifecycleConfiguration(lifecycleConfiguration);
	}
	
	public void setLoggingConfiguration(String loggingConfiguration) {
		mBucket.setLoggingConfiguration(loggingConfiguration);
	}
	
	public void setNotificationConfiguration(String notificationConfiguration) {
		mBucket.setNotificationConfiguration(notificationConfiguration);
	}
	
	public void setReplicationConfiguration(String replicationConfiguration) {
		mBucket.setReplicationConfiguration(replicationConfiguration);
	}
	
	public void setVersioningConfiguration(String versioningConfiguration) {
		mBucket.setVersioningConfiguration(versioningConfiguration);
	}
	
	public void setWebsiteConfiguration(String websiteConfiguration) {
		mBucket.setWebsiteConfiguration(websiteConfiguration);
	}

	@Override
	public Tagable addTag(String tag) {
		mBucket.addTags(tag);
		return this;
	}

}
