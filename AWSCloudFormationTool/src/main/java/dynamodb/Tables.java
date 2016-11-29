package dynamodb;

import resource.Resource;

/**
 * 
 * @author cenxui
 * 2016/11/29
 */

public class Tables extends Resource implements AttributeDefine, GSIndex, LSIndex {
	private final Table mTable;
	
	private Tables(Table component) {
		super(component);
		mTable = component;
	}
	
	public static Tables getTables() {
		final Table table = new Table();
		final Tables tables = new Tables(table);
		return tables;
	}
	

	@Override
	public LSIndex LocalSecondaryIndexe(String localSecondaryIndex) {
		mTable.addLocalSecondaryIndexes(localSecondaryIndex);
		return this;
	}

	
	public void setHashKey(String attribute) {
		mTable.setHashKey(attribute);
	}
	
	public void setRangeKey(String attribute) {
		mTable.setRangeKey(attribute);
	}

	@Override
	public GSIndex addGlobalSecondaryIndex(String globalSecondaryIndex) {
		mTable.addGlobalSecondaryIndexes(globalSecondaryIndex);
		return this;
	}

	public void setReadCapacityUnits(int readCapacityUnits) {
		mTable.setReadCapacityUnits(readCapacityUnits);
	}
	
	
	public void setWriteCapacityUnits(int writeCapacityUnits) {
		mTable.setWriteCapacityUnits(writeCapacityUnits);
	}

	public void setStreamSpecification(int streamSpecification) {
		mTable.setStreamSpecification(streamSpecification);
	}

	public void setTableName(String tableName) {
		mTable.setTableName(tableName);
	}

	@Override
	public AttributeDefine addAttribute(String attributeName, AttributeType type) {
		mTable.addAttribute(attributeName, type);
		return null;
	}

}
