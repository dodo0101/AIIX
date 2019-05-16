package com.javacore.aiix.dbservice.misc;

public interface DBQueryRegEx {

String OPERATION_GROUP = "(SELECT|DELETE)";
String FIELD_GROUP = "([*a-zA-Z, ]+)";
String SPACE = "([\\s])";
String FROM_GROUP = "(FROM)";
String TABLE_GROUP = "([a-zA-Z]+)$";

}
