package com.saptool.utils;

import com.saptool.ui.executionlab.RunExecutor;
import com.saptool.ui.main.Main;


import java.io.*;

public class ProcessCommander {



    public static void createProject_Maven(String projectName,String mainName){

        // creating a file object with path to your project directory where pom.xml file exist
        File projectDirectory = new File(GlobalConstants.PROJECTS_FOLDER_PATH);

        String[] commandsToExecute = new String[] { "cmd.exe", "/c", "mvn", "archetype:generate", "-DgroupId=com."+mainName, "-DartifactId="+projectName,"-DarchetypeArtifactId=maven-archetype-quickstart", "-DinteractiveMode=false"};

        // Create an instance of process builder with string array.
        ProcessBuilder builder = new ProcessBuilder(commandsToExecute);

        // Set project directory in builder to execute process builder from that directory.
        builder.directory(projectDirectory);

        builder.redirectErrorStream(true);

        Process process = null;
        try {
            // builder.start() will start execution of command
            process = builder.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

// Get input stream to get all lines which are printed on command prompt
        InputStream inputStream = process.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        try {
            while ((line = r.readLine()) != null) {
                // Print lines

                //print_createproject(line);
              //  NewProject.print(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void print_createproject(String string){
//        NewProject.cmdTxtArea.append(string+"\n");
//        // setText(string);
//    }

    public static void print(String string){
        Main.txtAreaTerminal.append(string+"\n");
               // setText(string);
    }




}
