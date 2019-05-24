package com.javacore.aiix.dbservice.misc;

import com.javacore.aiix.dbservice.DBApplication;

public class MainDataEncryptor implements DataEncryptor {

    @Override
    public String encrypt(String text) {
        if (DBApplication.DATA_ENCRYPTION_LEVEL.equals("LOW")){
            return encryptLOW(text);
        } else if (DBApplication.DATA_ENCRYPTION_LEVEL.equals("MEDIUM")) {
            return encryptMED(text);
        } else if (DBApplication.DATA_ENCRYPTION_LEVEL.equals("HIGH")) {
            return encryptHIGH(text);
        }
        return null;
    }

    private static String encryptLOW(String text) {
        //to hex
        char[] chArr = text.toCharArray();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sBuild = new StringBuilder();
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < chArr.length;i++) {
            int n = (int) chArr[i];
            int rem;
            while (n > 0) {
                rem = n % 16;
                sBuild.append(hexChars[rem]);
                n = n / 16;
            }
            resultStr.append(sBuild + " ");
            sBuild.setLength(0);
        }
        return resultStr.toString();
    }

    private static String encryptMED(String text) {
        //to caesar
        int caesar = 13;
        char[] chArr = text.toCharArray();
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < chArr.length; i++) {
            int n = (int) chArr[i];
            n = n + caesar;
            if (n > 126) {
                n = n - 95;
            }
            resultString.append((char) n);
        }

        return resultString.toString();
    }

    private String encryptHIGH(String text) {


        return null;
    }


    //



}
