package dynamodb;

import java.util.ArrayList;
import java.util.List;

import resource.Component;

/**
 * 
 * @author cenxui 2016/11/29
 */
class Table extends Component {

	public final String Type = "AWS::DynamoDB::Table";

	private final Properties Properties = new Properties();

	private class Properties {
		private List<Attribute> AttributeDefinitions;
		private List<String> GlobalSecondaryIndexes;
		private KeySchema[] KeySchemas = new KeySchema[2];
		private List<String> LocalSecondaryIndexes;
		private final ProvisionedThroughput ProvisionedThroughput =  new ProvisionedThroughput();;
		@SuppressWarnings("unused")
		private int StreamSpecification;
		@SuppressWarnings("unused")
		private String TableName;

	}

	public Table addAttribute(String attributeName, AttributeType type) {
		if (Properties.AttributeDefinitions == null) {
			Properties.AttributeDefinitions = new ArrayList<>();
		}
		
		final Attribute attribute = new Attribute();
		attribute.AttributeName = attributeName;
		attribute.AttributeType = type;

		Properties.AttributeDefinitions.add(attribute);
		return this;
	}

	public Table addGlobalSecondaryIndexes(String globalSecondaryIndex) {
		if (Properties.GlobalSecondaryIndexes == null) {
			Properties.GlobalSecondaryIndexes = new ArrayList<>();
		}
		
		if (Properties.GlobalSecondaryIndexes.size() == 5) {
			throw new RuntimeException("can not add more than 5 global secondary index");
		}

		Properties.GlobalSecondaryIndexes.add(globalSecondaryIndex);
		return this;
	}

	public Table setHashKey(String attribute) {
		if (Properties.KeySchemas[0] != null) {
			throw new RuntimeException("Hash key has already set up");
		}
		KeySchema keySchema = new KeySchema();
		keySchema.AttributeName = attribute;
		keySchema.KeyType = "HASH";
		Properties.KeySchemas[0] = keySchema;
		return this;
	}
	
	public Table setRangeKey(String attribute) {
		if (Properties.KeySchemas[1] != null) {
			throw new RuntimeException("Range key has already set up");
		}
		KeySchema keySchema = new KeySchema();
		keySchema.AttributeName = attribute;
		keySchema.KeyType = "RANGE";
		Properties.KeySchemas[1] = keySchema;
		return this;
	}

	public Table addLocalSecondaryIndexes(String localSecondaryIndex) {
		if (Properties.LocalSecondaryIndexes == null) {
			Properties.LocalSecondaryIndexes = new ArrayList<>();
		}
		
		if (Properties.LocalSecondaryIndexes.size() == 5) {
			throw new RuntimeException("can not add more than 5 local secondary index");
		}

		Properties.LocalSecondaryIndexes.add(localSecondaryIndex);
		return this;
	}

	public void setReadCapacityUnits(int readCapacityUnits) {
		Properties.ProvisionedThroughput.ReadCapacityUnits = readCapacityUnits;
	}
	
	public void setWriteCapacityUnits(int writeCapacityUnits) {
		Properties.ProvisionedThroughput.WriteCapacityUnits = writeCapacityUnits;
	}

	public void setStreamSpecification(int streamSpecification) {
		Properties.StreamSpecification = streamSpecification;
	}

	public void setTableName(String tableName) {
		Properties.TableName = tableName;
	}

	@Override
	protected void validate() {
		if (Properties.AttributeDefinitions == null || Properties.AttributeDefinitions.size() == 0) {
			throw new RuntimeException("AttributeDefinitions cannot be null, please add at least one attribute");
		}
		if (Properties.KeySchemas[0] == null) {
			throw new RuntimeException("KeySchema can not be null, please set hash key");
		}
		if (Properties.ProvisionedThroughput.ReadCapacityUnits == 0) {
			throw new RuntimeException("ReadCapacityUnits can not be 0");
		}
		if (Properties.ProvisionedThroughput.WriteCapacityUnits == 0) {
			throw new RuntimeException("WriteCapacityUnits can not be 0");
		}
		
	}
	
	private class ProvisionedThroughput {
		int ReadCapacityUnits;
		int WriteCapacityUnits;
	}
	
	private class Attribute {
		@SuppressWarnings("unused")
		String AttributeName;
		@SuppressWarnings("unused")
		AttributeType AttributeType;
	}
	
	private class KeySchema {
		@SuppressWarnings("unused")
		String AttributeName;
		@SuppressWarnings("unused")
		String KeyType;
	}
	
}
