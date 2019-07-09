package com.saptool.frameworkbuilder;

import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.io.File;

/**
 * Developed By: Bharath Kumar Reddy Vatrapu
 */
public class ScriptBuilder {

    static StringBuilder stringBuilder = null;


    static boolean returnStatus;

    public static void scriptBuilder(String body){
        String scriptPath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME.toLowerCase()+File.separator+GlobalConstants.SCRIPT_NAME+".java";
        String readScriptModel = Generic.readText(scriptPath);
        //Package Update
        readScriptModel = readScriptModel.replaceAll("package com.testProject.testSuites","package com.testProject.testSuites."+GlobalConstants.TEST_MODULE_NAME.toLowerCase());
        //TestScript Update
        readScriptModel = readScriptModel.replaceAll("public class Temp_TestScript extends","public class "+GlobalConstants.SCRIPT_NAME+" extends");
        //Test name updated
        readScriptModel = readScriptModel.replaceAll("public void Temp_TestScript","public void "+GlobalConstants.SCRIPT_NAME);
        //Group Update
        readScriptModel = readScriptModel.replaceAll("groups=","groups={\""+GlobalConstants.TEST_MODULE_NAME.toLowerCase()+"\"}");
        //Group Update
        readScriptModel = readScriptModel.replaceAll("configTestData.testModule","\""+GlobalConstants.TEST_MODULE_NAME.toLowerCase()+"\"");
        //Script body update
        readScriptModel = readScriptModel.replaceAll("//SAP-END - TEST SCRIPT",body+"//SAP-END - TEST SCRIPT");
        Generic.writeText(readScriptModel,scriptPath,false);
    }
    public static String script_body_builder(DefaultListModel steps){
        stringBuilder = new StringBuilder();
        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t"+steps.getElementAt(i).toString());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        //stringBuilder.append("\t\treturn \"true\";");
//        stringBuilder.append(System.lineSeparator());
//        stringBuilder.append("\t}");

        return stringBuilder.toString();
    }
}
