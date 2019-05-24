package com.javacore.aiix.dbservice.data.query;
/*
id = 1; //WERE

id = 5;

operatorEQ.operate(5, 1)

"<" - взять оператор (LESSTHAN) по символу и вернуть true или false

*/
@Deprecated
public class OperatorEQ {

    public static boolean operate(Object operand1, Object operand2){
        return operand1.equals(operand2);
    }


}

class OperatorAND {
    public static boolean operate(Boolean operand1, Boolean operand2){
        return operand1 && operand2;
    }

}

class OperatorLESSTHAN {
    public static boolean operate(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }
}