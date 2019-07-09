package com.saptool.frameworkbuilder;

import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.testng.annotations.Optional;

import java.io.File;

/**
 * Developed By: Bharath Kumar Reddy Vatrapu
 */
public class FrameworkBuilder {

    public static void updateTestNGParam_BeforeMethod(String testNgparam){
        String readConfigBase = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_CONFIGBASE_FOLDER);
        readConfigBase = readConfigBase.replaceAll("/\\*SAP-Parameters-BeforeMethod\\*/",","+"\""+testNgparam+"\""+"/*SAP-Parameters-BeforeMethod*/");
        readConfigBase = readConfigBase.replaceAll("/\\*SAP-MethodArgs-BeforeMethod\\*/",", @Optional("+"\""+"optional"+"\""+") String "+testNgparam+"/*SAP-MethodArgs-BeforeMethod*/");
        readConfigBase = readConfigBase.replaceAll("/\\*SAP-VarDec_System.getProp-BeforeMethod\\*/","\t\tconfigTestData.test"+Generic.convertFirstcharUpperCase(testNgparam)+" = System.getProperty("+"\""+testNgparam+"\""+").toLowerCase();"+System.lineSeparator()+"\t\t/*SAP-VarDec_System.getProp-BeforeMethod*/");
        readConfigBase = readConfigBase.replaceAll("/\\*SAP-VarDec-BeforeMethod\\*/","configTestData.test"+Generic.convertFirstcharUpperCase(testNgparam)+" = "+testNgparam+".toLowerCase();"+System.lineSeparator()+"/*SAP-VarDec-BeforeMethod*/");
        Generic.writeText(readConfigBase,GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_CONFIGBASE_FOLDER,false);

        String readConfigTestData = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_CONFIGTESTDATA_FOLDER);
        readConfigTestData= readConfigTestData.replaceAll("//SAP-END    -    TestNG Params","\tpublic String test"+Generic.convertFirstcharUpperCase(testNgparam)+" = null;"+System.lineSeparator()+"\t//SAP-END    -    TestNG Params");
        Generic.writeText(readConfigTestData,GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_CONFIGTESTDATA_FOLDER,false);
    }





    public static void updatePageInit_TestBase(String pagename){
        String readTestBase = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTBASE_FOLDER);
        readTestBase = readTestBase.replaceAll("//SAP-END   - IMPORT DECLARATION","import com.testProject.testPages."+pagename+"Page;"+System.lineSeparator()+"//SAP-END   - IMPORT DECLARATION");
        readTestBase = readTestBase.replaceAll("//SAP-END   - PAGE DECLARATION","public "+pagename+"Page "+pagename.toLowerCase()+"page  = null;"+System.lineSeparator()+"\t//SAP-END   - PAGE DECLARATION");
        readTestBase = readTestBase.replaceAll("//SAP-END   - PAGE INITILAZATION",""+pagename.toLowerCase()+"page = new "+pagename+"Page(configTestData);"+System.lineSeparator()+"\t//SAP-END   - PAGE INITILAZATION");
        Generic.writeText(readTestBase,GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTBASE_FOLDER,false);
    }

    public static void updatePOM_ProjectName(String projectName){
        String readPOM = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "pom.xml");
        readPOM = readPOM.replaceAll("SAPTestFramework",projectName);
        Generic.writeText(readPOM,GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "pom.xml",false);
    }

    public static void deletePageInit_TestBase(String pagename){

        String pagesource=null;
        String readTestBase = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTBASE_FOLDER);
//        String pagedec=readTestBase.substring(readTestBase.indexOf("//PAGE DECLARATION - START"),readTestBase.indexOf("//PAGE DECLARATION - END"));
//        String pageimport=readTestBase.substring(readTestBase.indexOf("//IMPORT DECLARATION - START"),readTestBase.indexOf("//IMPORT DECLARATION - END"));
//        String pageinit=readTestBase.substring(readTestBase.indexOf("//PAGE INITILAZATION - START"),readTestBase.indexOf("//PAGE INITILAZATION - END"));
//
//        pageimport = pageimport.replaceAll("import com.testProject.pages."+pagename+";","");
//        pagedec = pagedec.replaceAll("public "+pagename+" "+pagename.toLowerCase()+"  = null;","");
//        pageinit = pageinit.replaceAll(pagename.toLowerCase()+" = new "+pagename+"(configTestData);","");
//        String pageinit =pagename.toLowerCase()+" = new "+pagename+"P(configTestData);";

        pagesource = readTestBase.replaceAll(pagename.toLowerCase()+" = new "+pagename+"\\(configTestData\\);","");

        //+pagename+"(configTestData);
        pagesource = pagesource.replaceAll("public "+pagename+" "+pagename.toLowerCase()+"  = null;","");
        pagesource = pagesource.replaceAll("import com.testProject.pages."+pagename+";","");

      //  pagesource = pagesource.replaceAll(pagesource.substring(pagesource.indexOf("//IMPORT DECLARATION - START"),pagesource.indexOf("//IMPORT DECLARATION - END")),pagesource.substring(pagesource.indexOf("//IMPORT DECLARATION - START"),pagesource.indexOf("//IMPORT DECLARATION - END")).replaceAll("\\n+",""));
                //pagesource.substring(readTestBase.indexOf("//IMPORT DECLARATION - START"),readTestBase.indexOf("//IMPORT DECLARATION - END")).replaceAll("(?m)^\\s","");
      //  pagesource = pagesource.substring(readTestBase.indexOf("//PAGE DECLARATION - START"),readTestBase.indexOf("//PAGE DECLARATION - END")).replaceAll("(?m)^\\s","");
     //   pagesource = pagesource.substring(readTestBase.indexOf("//PAGE INITILAZATION - START"),readTestBase.indexOf("//PAGE INITILAZATION - START")).replaceAll("(?m)^\\s","");
//

        Generic.writeText(pagesource,GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTBASE_FOLDER,false);
    }
}
