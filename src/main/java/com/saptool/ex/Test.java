package com.saptool.ex;

public class Test {

    public static void main(String[] args){
        String str="{\"browser\",\"platform\"/*SAP-Parameters-BeforeMethod-Start*/,\"environment\"/*SAP-Parameters-BeforeMethod-End*/";
        String str1,str2;
        str1 = str.substring(str.indexOf("/*SAP-Parameters-BeforeMethod-Start*/"),str.indexOf("/*SAP-Parameters-BeforeMethod-End*/"));
//        str = str.substring(str.indexOf("/*SAP-Parameters-BeforeMethod-Start*/"));
        str2 = str.replaceAll("environment",",bharath");
        System.out.println(str1);
        System.out.println(str2);
    }
}
