package com.saptool.utils;

import java.io.*;

public class ReplaceFileContents {
//    public static void main(String[] args) {
//        new ReplaceFileContents().replace();
//    }

    public static void replace(String filePath,String fileName,String searchStm,String newStm) {
//        String vatStatement = "//OBJECTS VARIABLES DECLARAITON";
//        String newStatement = "//OBJECTS VARIABLES DECLARAITON\n" +
//                "    @CacheLookup\n" +
//                "    @FindBy(xpath = \"//a/ng-transclude/span[text()=\\\"Terms of Use\\\"]\")\n" +
//                "    public WebElement lnknewOnew;"+System.lineSeparator();
        String oldFileName = fileName;
        String tmpFileName = "tmp_"+fileName;
        String oldFilePath = filePath+File.separator+fileName;
        String tmpFilePath = filePath+File.separator+tmpFileName;

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFilePath));
            bw = new BufferedWriter(new FileWriter(tmpFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchStm))
                    line = line.replace(searchStm, newStm);
                bw.write(line+"\n");
            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(oldFilePath);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFilePath);
        newFile.renameTo(oldFile);

    }
}