package test;

import dynamodb.AttributeType;
import dynamodb.Tables;
import resource.Template;

public class TestDynamoDB {

	public static void main(String[] args) {
		Tables tables = Tables.getTables();
		tables.addAttribute("id", AttributeType.N);
		tables.addAttribute("name", AttributeType.S);
		tables.setHashKey("id");
		tables.setRangeKey("name");
		tables.setReadCapacityUnits(1);
		tables.setWriteCapacityUnits(1);
		tables.setTableName("test");
		Template template = Template.getTemplate();
		template.addResource("MyTable", tables);
		System.out.println(template);

	}

}
