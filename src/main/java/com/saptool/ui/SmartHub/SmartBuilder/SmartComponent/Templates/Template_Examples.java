package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Template_Examples {

    public static String Objects_existance="public String Objects_isDisplayed(){\n" +
            "   //Developed By Bharath\n" +
            "   boolean result = true;\n" +
            "   try {\n" +
            "\tpageObjElements.clear();\t\t\t\n" +
            "\tpageObjElements.add(object_1);\n" +
            "\tpageObjElements.add(object_2);\n" +
            "\tpageObjElements.add(object_3);\n" +
            "\t....\n" +
            "\t....\n" +
            "\t....\n" +
            "\tpageObjElements.add(object_N);\n" +
            "\tfor (WebElement listObj : pageObjElements) {\n" +
            "\t   if (!element.isDisplayed(listObj).equalsIgnoreCase(\"true\")) {\n" +
            "\t\t  result = false;\n" +
            "\t\t  Log.info(listObj + \"Dose not exist\");\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\t} catch (Exception e){\n" +
            "\t\tLog.error(\"Exception in verifyHeader method :\"+ e.getMessage());\n" +
            "\t}\n" +
            "\treturn String.valueOf(result);\n" +
            "}";

    public static String Objects_not_existance="public String Objects_isDisplayed(){\n" +
            "   //Developed By Bharath\n" +
            "   boolean result = true;\n" +
            "   try {\n" +
            "\tpageObjElements.clear();\t\t\t\n" +
            "\tpageObjElements.add(object_1);\n" +
            "\tpageObjElements.add(object_2);\n" +
            "\tpageObjElements.add(object_3);\n" +
            "\t....\n" +
            "\t....\n" +
            "\t....\n" +
            "\tpageObjElements.add(object_N);\n" +
            "\tfor (WebElement listObj : pageObjElements) {\n" +
            "\t   if (element.isDisplayed(listObj).equalsIgnoreCase(\"true\")) {\n" +
            "\t\t  result = false;\n" +
            "\t\t  Log.info(listObj + \"Dose not exist\");\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\t} catch (Exception e){\n" +
            "\t\tLog.error(\"Exception in verifyHeader method :\"+ e.getMessage());\n" +
            "\t}\n" +
            "\treturn String.valueOf(result);\n" +
            "}";
}
