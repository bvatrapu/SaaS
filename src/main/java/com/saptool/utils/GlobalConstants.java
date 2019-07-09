package com.saptool.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;

public class GlobalConstants {

    public static String FS = File.separator;
    public static String resources_path = System.getProperty("user.dir")+FS+"src"+FS+"main"+FS+"resources"+FS;


    //Root Folder Paths
    public static String Tool_Name= "SaaS";
    public static String SETUP_FOLDER_PATH = System.getProperty("user.home") +FS+"AppData"+FS+"Roaming";
    public static String ROOT_FOLDER_PATH = SETUP_FOLDER_PATH+FS+Tool_Name;
    public static String PROJECTS_FOLDER_PATH = ROOT_FOLDER_PATH+FS+"Projects";
    public static String EXECUTIONS_FOLDER_PATH = ROOT_FOLDER_PATH+FS+"EXECUTIONS";
    public static String CONFIG_FOLDER_PATH = ROOT_FOLDER_PATH+FS+"Config";
    public static String CONFIG_TEMP_FOLDER_PATH=CONFIG_FOLDER_PATH+FS+"temp";
    public static String CONFIG_PROJECTS_FOLDER_PATH = CONFIG_FOLDER_PATH+FS+"Projects";

    public static String CONFIG_PROJECT_PATH = CONFIG_FOLDER_PATH+FS+"config.properties";
    //public static String PROJECTS_QUEUE_PATH = ROOT_FOLDER_PATH+FS+"Projects";


    public static String TEST_FRAMEWORK_SRC_Path=CONFIG_TEMP_FOLDER_PATH+FS+"src";
    public static String TEST_FRAMEWORK_POM_Path=CONFIG_TEMP_FOLDER_PATH+FS+"pom.xml";
    public static String TEST_FRAMEWORK_TESTPAGES_FOLDER = "src"+FS+"test"+FS+"java"+FS+"com"+FS+"testProject"+FS+"testPages";
    public static String TEST_FRAMEWORK_TESTSUITES_FOLDER = "src"+FS+"test"+FS+"java"+FS+"com"+FS+"testProject"+FS+"testSuites";
    public static String TEST_FRAMEWORK_TESTRESOURCES_FOLDER = "src"+FS+"test"+FS+"resources";
    public static String TEST_FRAMEWORK_TESTDATA_FOLDER = "src"+FS+"test"+FS+"resources"+FS+"testData";
    public static String TEST_FRAMEWORK_TESTEXECUTION_FOLDER = "src"+FS+"test"+FS+"resources"+FS+"testExecution";
    public static String TEST_FRAMEWORK_TESTREPORTS_FOLDER = "src"+FS+"test"+FS+"resources"+FS+"testReports";
    public static String TEST_FRAMEWORK_TESTBASE_FOLDER = "src"+FS+"test"+FS+"java"+FS+"com"+FS+"testProject"+FS+"testBase"+FS+"TestBase.java";
    public static String TEST_FRAMEWORK_CONFIGBASE_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"base"+FS+"ConfigBase.java";
    public static String TEST_FRAMEWORK_CONFIGTESTDATA_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"base"+FS+"ConfigTestData.java";
    public static String TEST_PROJECT_REPORTS  = "ExtentReports";

    public static String FRAMEWORK_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP";
    public static String FRAMEWORK_UTILGENERIC_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"utils"+FS+"generic";
    public static String FRAMEWORK_CONFIGBASE_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"base";
    public static String FRAMEWORK_CONSTANTS_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"constants";
    public static String FRAMEWORK_TESTCONSTANTS_FOLDER = "src"+FS+"test"+FS+"java"+FS+"com"+FS+"testProject"+FS+"testConstants";
    public static String FRAMEWORK_DRIVERGENERIC_FOLDER = "src"+FS+"main"+FS+"java"+FS+"com"+FS+"SAP"+FS+"framework"+FS+"utils"+FS+"drivergeneric";
    // Tools Path
    public static String SublimeText_Path = CONFIG_TEMP_FOLDER_PATH+FS+"SublimeText"+FS+"sublime_text.exe";
    public static String SAP_OBJECT_SPY_TOOL = CONFIG_TEMP_FOLDER_PATH+FS+"SaaS_Object_Spy.xlsm";

    // Tools Installed Path


    //UTILS
    public static String DATE_TIME = null;

    //Executions
    public static String EXECUTION_PROJECT = null;
    public static String EXECUTION_NAME=null;

    //Config Folders Path




    public static String TEST_MODULE_NAME=null;
//    public static String TEST_ENV_NAME=null;

//    public static String PROJECT_TESTBASE_PATH = "src/test/java/com/testProject/testbase/TestBase.java";
//    public static String PROJECT_PAGES_PATH = "src/test/java/com/testProject/pages/";

//    public static String TEST_SUITE_FILE_PATH="src/test/resources/testExecutionDriver";
    public static String RESULTS_FOLDER_PATH;
    public static String Project_Name=null;




    public static String SELECTED_PROJECT=null;
    public static String TABLE_SELECTED_PROJECT=null;
    public static String SELECTED_PROJECT_PATH=null;
    public static String New_Created_Page_Name=null;

    public static String Chrome_Browser_Path_32bit = "C:"+FS+"Program Files (x86)"+FS+"Google"+FS+"Chrome"+FS+"Application"+FS+"chrome.exe";
    public static String Chrome_Browser_Path_64bit = "C:"+FS+"Program Files"+FS+"Google"+FS+"Chrome"+FS+"Application"+FS+"chrome.exe";


    public static String Prop_Selected_Project = "Selected.Project";
    public static String Prop_Project_Path = "Project.path";

    public static String param_properties="params.properties";
    public static String config_properties="config.properties";
    public static String queue_suites_properties="queue";
    public static String alm_properties="alm_config.properties";
    public static String projectpaths_properties="project_paths.properties";
//    public static String parameter_name_prop = "parameter_names.properties";

    public static String project_Button_clicked_name=null;

    public static WebDriver webDriver;

    // HUB _ NODES
    public static String SELENIUM_GRID_PATH = CONFIG_TEMP_FOLDER_PATH+FS+"selenium-hub-node-configs";

    public static boolean HUB_STATUS = false;
    public static boolean NODE_STATUS = false;

    public static String GRID_DRIVERS_PATH = SELENIUM_GRID_PATH+FS+"DRIVERS"+FS;
    public static String NODES_JSON_FILE_PATH =SELENIUM_GRID_PATH+FS+"Config/GridNode.json";
    public static String HUB_JSON_FILE_PATH =SELENIUM_GRID_PATH+FS+"Config/hubConfig.json";

    public static String NODES_CONFIG_FILE_PATH =SELENIUM_GRID_PATH+FS+"Nodes_Start.bat";
    public static String HUB_CONFIG_FILE_PATH =SELENIUM_GRID_PATH+FS+"HUB_Start.bat";



    // PAGE MODEL BUILDER
    public static String PAGE_URL=null;
    public static String PAGE_NAME=null;
    public static String PAGE_PATH=null;

    //Operations
    public static String all_operations=null;

    //Methods
    public static String Method_Name=null;
    public static String Method_Description=null;
    public static String Method_AccessModifier=null;
    public static String Method_Return_Type=null;
    public static boolean Method_args_status=false;

    public static String TestScript_Selected_Page_Name=null;

    public static String TestScript_Button_Name=null;

    public static boolean Method_Verify = false;


    public static int STEP_NO = 0;
    public static String STEP_DESCRIPTION=null;
    public static String STEP_EXPECTED=null;
    public static String STEP_FAILMESSAGE=null;

    public static String SCRIPT_NAME=null;

    public static String SELECTED_METHOD=null;

    public static boolean VERIFY_SCRIPT_COMMAND=false;
    public static boolean NEGATIVE_VERIFY_SCRIPT_COMMAND=false;
    public static boolean VERIFY_METHOD_COMMAND=false;

    public static int arg_incrementer=0;

    public static String SELECTED_EXEC_NODE_MODULE=null;

    public static String SELECTED_PAGE=null;

    public static String SELECTED_PAGE_OBJECT=null;

    public static String FINAL_VERIFY_OPERATION=null;

    //public static String SELECTED_METHOD_TEMPLATE=null;

    public static String PAGE_WEBELEMENT=null;

    public static String ENTER_URL=null;

    public static boolean Navigation_Both=false;

   // public static String[] String_Frame_value=null;

//    public static boolean multi_dataType=false;
//
    public static String selected_Tree_Node=null;
    public static String selected_table_row=null;
    public static String args=null;

    public static String METHOD_ARG=null;

    public static boolean MIN_MAX=true;

    public static String NAVIGATION_TYPE=null;

    public static boolean SaaS_PROJECTS=true;
}
