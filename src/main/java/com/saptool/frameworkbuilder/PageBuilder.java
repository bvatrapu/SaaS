package com.saptool.frameworkbuilder;

import com.saptool.ui.SmartHub.SmartBuilder.CreateNewPage.NavigationByUrl;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;
import java.util.Map;

/**
 * Developed By: Bharath Kumar Reddy Vatrapu
 */
public class PageBuilder {

    static StringBuilder stringBuilder = null;

    static boolean returnStatus;



    public static void pageBuilder(String body,String type){
        String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
        String readPageModel = Generic.readText(pagePath);

        switch (type.toUpperCase()){
            case "VARIABLE":
                readPageModel = readPageModel.replaceAll("//SAP-END - VARIABLE DECLARAITON","\t"+body+System.lineSeparator()+"//SAP-END - VARIABLE DECLARAITON");

                break;
            case "OBJECT":
                if(readPageModel.contains(body)){
                    JOptionPane.showMessageDialog(null, "Object is already exists in the Page", "Warning ", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    readPageModel = readPageModel.replaceAll("//SAP-END - OBJECT DECLARAITON", body + "//SAP-END - OBJECT DECLARAITON");
                }
                break;
            case "OPERATION":
                readPageModel = readPageModel.replaceAll("//SAP-END - OPERATION DECLARAITON", body +"//SAP-END - OPERATION DECLARAITON");
                break;
            case "METHOD":
                readPageModel = readPageModel.replaceAll("//SAP-END - METHOD DECLARAITON",System.lineSeparator()+body+System.lineSeparator()+"//SAP-END - METHOD DECLARAITON");
                break;

        }
        Generic.writeText(readPageModel,pagePath,false);

    }
    public static void pageObjectBuilder(String body,String webElement){
        String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
        String readPageModel = Generic.readText(pagePath);

        if(readPageModel.contains(webElement)){
            JOptionPane.showMessageDialog(null, "Object is already exists in the Page", "Warning ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            readPageModel = readPageModel.replaceAll("//SAP-END - OBJECT DECLARAITON", body + "//SAP-END - OBJECT DECLARAITON");
        }
        Generic.writeText(readPageModel,pagePath,false);
    }
    public static void pageOperationBuilder(String body){
        String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
        String readPageModel = Generic.readText(pagePath);

        readPageModel = readPageModel.replaceAll("//SAP-END - OPERATION DECLARAITON", body + "//SAP-END - OPERATION DECLARAITON");
        Generic.writeText(readPageModel,pagePath,false);
    }
    public static void updatepageObjectBuilder(String body,String val){
        String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
        String readPageModel1 = Generic.readText(pagePath);

//        if(readPageModel.contains(webElement)){
//            JOptionPane.showMessageDialog(null, "Object is already exists in the Page", "Warning ", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            readPageModel = readPageModel.replaceAll("//SAP-END - OBJECT DECLARAITON", body + "//SAP-END - OBJECT DECLARAITON");
//        }
//        Generic.writeText(readPageModel,pagePath,false);
        String readPageModel=readPageModel1;
        String[] str=readPageModel.split(body.trim()+";");

       // str=readPageModel.split("public WebElement "+body+";");
        readPageModel=str[0]+body.trim()+";";
        int start = readPageModel.indexOf("@CacheLookup");
        int last=0;
        while(start != -1) {

            last=start;
            start = readPageModel.indexOf("@CacheLookup", ++start);
        }


        String bod= readPageModel.substring(last,readPageModel.indexOf(body.trim()));

        String repStr=bod.substring(bod.indexOf("= \"")+3,bod.indexOf("\")"));

        String finalstr=readPageModel1.replaceAll(repStr,val);

    }
    public static void init_PageBuilder(String pagePath,DefaultListModel pageUrl,String pageName,String objects){
        String readPageModel = Generic.readText(pagePath);
//        readPageModel = readPageModel.replaceAll("//SAP-END - VARIABLE DECLARAITON","List<String> pageObjElements = new ArrayList<String>();"+System.lineSeparator()+"//SAP-END - VARIABLE DECLARAITON");

        readPageModel = readPageModel.replaceAll("//SAP-END - VARIABLE DECLARAITON",strVariableBuilder(pageName+"PageUrl",null)+System.lineSeparator()+"//SAP-END - VARIABLE DECLARAITON");
        if(!StringUtils.isEmpty(objects)) {
            readPageModel = readPageModel.replaceAll("//SAP-END - OBJECT DECLARAITON", objects + "//SAP-END - OBJECT DECLARAITON");
        }
        if(!StringUtils.isEmpty(GlobalConstants.all_operations)) {
            readPageModel = readPageModel.replaceAll("//SAP-END - OPERATION DECLARAITON", GlobalConstants.all_operations +"//SAP-END - OPERATION DECLARAITON");
        }

        readPageModel = readPageModel.replaceAll("//SAP-END - METHOD DECLARAITON",navigate_Method_Builder(pageUrl,pageName)+"//SAP-END - METHOD DECLARAITON");
        readPageModel = readPageModel.replaceAll("//SAP-END - METHOD DECLARAITON",verifyPageUrl_method_Builder(pageName)+"//SAP-END - METHOD DECLARAITON");

        Generic.writeText(readPageModel,pagePath,false);


    }
    public static String navigate_Method_Builder(DefaultListModel pageUrl,String pageName){
      //  String returVal=null;
        stringBuilder = new StringBuilder();
        if(GlobalConstants.NAVIGATION_TYPE.contains("BY_URL")){
            stringBuilder =navigateToUrl_Method_Builder(pageUrl,pageName);
        } else if(GlobalConstants.NAVIGATION_TYPE.contains("By_Steps")){
            stringBuilder =goToUrl_Method_Builder(pageUrl,pageName);
        } else {
            stringBuilder =navigateToUrl_Method_Builder(pageUrl,pageName);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(System.lineSeparator());
            stringBuilder =goToUrl_Method_Builder(pageUrl,pageName);

        }
        return stringBuilder.toString();
    }
    public static StringBuilder navigateToUrl_Method_Builder(DefaultListModel pageUrl,String pageName){
        stringBuilder = new StringBuilder();
        String[] urls=null;
        stringBuilder.append("\tpublic String navigateToUrl(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tconfigTestData.stepDescription = \"Navigate to "+pageName+" Page.\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.startLog(\""+pageName+"Page:::'goto"+pageName+"Page'\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tswitch (configTestData.testEnvironment){");
        stringBuilder.append(System.lineSeparator());
        for(int j=0;j<=pageUrl.size()-1;j++){

            urls = pageUrl.getElementAt(j).toString().split("#=#");
            stringBuilder.append("\t\t\tcase \""+urls[0]+"\":");
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("\t\t\t\tbrowser.navigateToUrl(\""+urls[1]+"\");");
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("\t\t\t\t"+pageName+"PageUrl=\""+urls[1]+"\";");
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("\t\t\t\tbreak;");
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
//        stringBuilder.append("\t\tbrowser.navigateToUrl("+pageName+"PageUrl);");
//        stringBuilder.append(System.lineSeparator());
//        stringBuilder.append("\t\tLog.info(\"Navigated URL is :"+pageName+"PageUrl\");");
//        stringBuilder.append(System.lineSeparator());
//        stringBuilder.append("\t\tif (browser.verifyPageUrl("+pageName+"PageUrl)!=\"true\"){");
//        stringBuilder.append(System.lineSeparator());
//        stringBuilder.append("\t\t\treturn \"false\";");
//        stringBuilder.append(System.lineSeparator());
        //stringBuilder.append("\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.endLog(\""+pageName+"Page:::'goto"+pageName+"Page'\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn \"true\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder;
    }
    public static StringBuilder goToUrl_Method_Builder(DefaultListModel pageSteps,String pageName){
        stringBuilder = new StringBuilder();
        String[] urls=null;
        stringBuilder.append("\tpublic String goTo"+pageName+"(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tconfigTestData.stepDescription = \"Navigate to "+pageName+" Page.\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.startLog(\""+pageName+"Page:::'goto"+pageName+"Page'\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry{");
        stringBuilder.append(System.lineSeparator());
        for(int j=0;j<=pageSteps.size()-1;j++){
            stringBuilder.append("\t\t\t"+pageSteps.getElementAt(j).toString().trim()+";");
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append("\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn \"true\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
       // stringBuilder.append("\t"+"//SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder;
    }
    public static String strVariableBuilder(String varName){
        return ("    String "+varName+";");
    }

    public static String strVariableBuilder(String varName,String value){
        if(value==null){
            return ("\tString " + varName + " = null;");
        }else {
            return ("\tString " + varName + " = \"" + value + "\";");
        }
    }

    public static String navigateMethodBuilder(String pageUrl,String pageName){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\tpublic String goto"+pageName+"Page(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tconfigTestData.stepDescription = \"Navigate to "+pageName+" Page.\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.startLog(\""+pageName+"Page:::'goto"+pageName+"Page'\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tbrowser.navigateToUrl("+pageName+"PageUrl);");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.info(\"Navigated URL is :"+pageName+"PageUrl\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tif (browser.verifyPageUrl("+pageName+"PageUrl)!=\"true\"){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\treturn \"false\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tLog.endLog(\""+pageName+"Page:::'goto"+pageName+"Page'\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn \"true\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public static String verifyPageUrl_method_Builder(String pageName){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\tpublic String verifyPage(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tconfigTestData.stepDescription = \"Verify "+pageName+" Page.\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tboolean result=true;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry{");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tif(browser.verifyPageUrl("+pageName+"PageUrl)!=\"true\"){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tif(element.isExist("+GlobalConstants.PAGE_WEBELEMENT+")!=\"true\"){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tresult=false;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t}");
        stringBuilder.append(System.lineSeparator());

        stringBuilder.append("\t\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn String.valueOf(result);");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public static String clickOnLinkAndVerifyTargetPage_method_Builder(DefaultListModel steps){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
    public static String method_Builder(DefaultListModel steps){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        if(GlobalConstants.Method_args_status) {
            stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(String... args){");
        } else{
            stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(){");
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tconfigTestData.stepDescription = \""+GlobalConstants.Method_Description+"\";");
        stringBuilder.append(System.lineSeparator());

        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t"+steps.getElementAt(i).toString()+";");
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn \"true\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append("\t"+"SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder.toString();
    }
    public static String method_temp_Submit_form_Builder(DefaultListModel steps,String methodDesc){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t/**");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t* Method Description :: "+methodDesc);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*/");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(String... args){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry {");
        stringBuilder.append(System.lineSeparator());
        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t\t"+steps.getElementAt(i).toString().trim()+";");
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append("\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn \"true\";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"//SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder.toString();
    }
    public static String method_temp_vreify_Obj_Builder(DefaultListModel steps,String methodDesc){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t/**");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t* Method Description :: "+methodDesc);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*/");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tboolean result = true;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tpageObjElements.clear();");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t//SAP - ");
        stringBuilder.append(System.lineSeparator());
        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t\t"+"pageObjElements.add("+steps.getElementAt(i).toString().trim()+");");
            stringBuilder.append(System.lineSeparator());
        }

        stringBuilder.append("\t\t\tfor (WebElement listObj : pageObjElements) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tif (!element.isDisplayed(listObj).equalsIgnoreCase(\"true\")) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tresult = false;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tLog.info(listObj + \"Dose not exist\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn String.valueOf(result);");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"//SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder.toString();
    }

    public static String method_temp_vreify_notObj_Builder(DefaultListModel steps,String methodDesc){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t/**");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t* Method Description :: "+methodDesc);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*/");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tboolean result = true;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tpageObjElements.clear();");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t//SAP - ");
        stringBuilder.append(System.lineSeparator());
        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t\t"+"pageObjElements.add("+steps.getElementAt(i).toString().trim()+");");
            stringBuilder.append(System.lineSeparator());
        }

        stringBuilder.append("\t\t\tfor (WebElement listObj : pageObjElements) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tif (element.isDisplayed(listObj).equalsIgnoreCase(\"true\")) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tresult = false;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tLog.info(listObj + \"Dose not exist\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn String.valueOf(result);");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"//SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder.toString();
    }

    public static String method_temp_click_link_verify_TargetPage_Builder(DefaultListModel steps,String methodDesc){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\t//"+"SAP - "+GlobalConstants.Method_Name+" - START");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t/**");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t* Method Description :: "+methodDesc);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t*/");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"public String "+GlobalConstants.Method_Name+ "(){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\tboolean result = true;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\ttry {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\tpageObjElements.clear();");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t//SAP - ");
        stringBuilder.append(System.lineSeparator());
        for(int i=0;i<=steps.size()-1;i++){
            stringBuilder.append("\t\t\t"+"pageObjElements.add("+steps.getElementAt(i).toString().trim()+");");
            stringBuilder.append(System.lineSeparator());
        }

        stringBuilder.append("\t\t\tfor (WebElement listObj : pageObjElements) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tif (!element.clickOnLink_VerifyTargetPage(listObj).equalsIgnoreCase(\"true\")) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tresult = false;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t\tLog.info(listObj + \"Dose not exist\");");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t} catch (Exception e){");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t\tLog.error(\"Exception in "+GlobalConstants.Method_Name+" method :\"+ e.getMessage());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn String.valueOf(result);");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t"+"//SAP - "+GlobalConstants.Method_Name+" - END");
        return stringBuilder.toString();
    }

}
