package com.saptool.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.*;

public class DomExtractor_old {


    StringBuilder stringBuilder = new StringBuilder();
    Document document;
    List<String> listStrings = new ArrayList<String>();
    String innerxpath=null;
    String id = null;
    String text = null;
    String xpath=null;
    String findby=null;
    String cachelookup = "\t@CacheLookup";
    String webelement = null;


    String pageObjectmodel=null;
    String enumPropertiesmodel=null;
    // String pageName;

    String all;
    String all_links;
    String all_buttons;
    String all_radiobuttons;
    String all_texts;
    String all_lists;
    String all_images;
    String all_checkboxes;
    String all_edits;
    String all_comboboxes;
    String all_textarea;
    HashMap<Integer,String> hmLinks = new HashMap<Integer,String>();
    HashMap<Integer,String> hmEdits = new HashMap<Integer,String>();
    HashMap<Integer,String> hmButtons = new HashMap<Integer,String>();
    HashMap<Integer,String> hmRadioButtons = new HashMap<Integer,String>();
    HashMap<Integer,String> hmCheckBox = new HashMap<Integer,String>();
    HashMap<Integer,String> hmComboBox = new HashMap<Integer,String>();
    HashMap<Integer,String> hmTexts = new HashMap<Integer,String>();
    HashMap<Integer,String> hmImages = new HashMap<Integer,String>();
    //operations
    String allLinkOperations;
    String allInputOperations;
    String allButtonOperations;
    String allRadioButtonOperations;
    String allCheckBoxOperations;
    String allTextOperations;
    String allImageOperations;
    String allListOperations;
    String all_operations;



    public String smartExtractor(String htmlContent, ArrayList<String> objList){
        try
        {
            if(objList.size()!=0) {
                if(htmlContent.contains("</")) {
                    document = Jsoup.parse(htmlContent);
                }else{
                    document = Jsoup.connect(htmlContent).get();
                }
                Elements input_elements = document.getElementsByTag("input");
                for (int k = 0; k <= objList.size() - 1; k++) {
                    switch (objList.get(k)) {
                        case "Link":
                            getLinks();
                            getLinkOperation();
                            break;
                        case "Button":
                            getButtons(input_elements);
                            getButtonOperation();
                            break;
                        case "CheckBox":
                            getCheckbox(input_elements);
                            getCheckBoxOperations();
                            break;
                        case "EditBox":
                            getEdit(input_elements);
                            getTextArea();
                            getInputOperation();
                            break;
                        case "Image":
                           // getImages();
                            getImages(input_elements);
                            // getImageOperations();
                            break;
                        case "List":
                            //  getList(pomType);

                            break;
                        case "RadioButton":
                            getRadioButton(input_elements);
                            getRadioButtonOperations();
                            break;
                        case "ComboBox":
                            getCombobox();
                            getListOperations();
                            break;
                        case "Text (Headers)":
                            getText();
                            //   getTextOperations();
                            break;
                    }
                }

                if(!StringUtils.isEmpty(all_links)){

                    if(!StringUtils.isEmpty(all)){
                        all = all+all_links;
                    } else {
                        all = all_links;
                    }
                }
                if(!StringUtils.isEmpty(all_buttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_buttons;
                    } else {
                        all = all_buttons;
                    }
                }
                if(!StringUtils.isEmpty(all_checkboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_checkboxes;
                    } else {
                        all = all_checkboxes;
                    }
                }
                if(!StringUtils.isEmpty(all_edits)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_edits;
                    } else {
                        all = all_edits;
                    }
                }
                if(!StringUtils.isEmpty(all_textarea)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_textarea;
                    } else {
                        all = all_textarea;
                    }
                }
                if(!StringUtils.isEmpty(all_images)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_images+System.lineSeparator();
                    } else {
                        all = all_images+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_lists)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_lists;
                    } else {
                        all = all_lists;
                    }
                }
                if(!StringUtils.isEmpty(all_radiobuttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_radiobuttons;
                    } else {
                        all = all_radiobuttons;
                    }
                }
                if(!StringUtils.isEmpty(all_comboboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_comboboxes;
                    } else {
                        all = all_comboboxes;
                    }
                }
                if(!StringUtils.isEmpty(all_texts)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_texts;
                    } else {
                        all = all_texts;
                    }
                }

                //Operations
                if(!StringUtils.isEmpty(allLinkOperations)){
                    if(!StringUtils.isEmpty(all_operations)){
                        all_operations = all_operations+allLinkOperations+System.lineSeparator();
                    } else{
                        all_operations = allLinkOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allInputOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allInputOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allInputOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allButtonOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allButtonOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allButtonOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allRadioButtonOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allRadioButtonOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allRadioButtonOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allListOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allListOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allListOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allCheckBoxOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allCheckBoxOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allCheckBoxOperations+System.lineSeparator();
                    }
                }
//                if(!StringUtils.isEmpty(allTextOperations)){
//                    if(StringUtils.isEmpty(all_operations)){
//                        all_operations = allTextOperations+System.lineSeparator()+"\t";
//                    } else{
//                        all_operations = all_operations+allTextOperations+System.lineSeparator()+"\t";
//                    }
//                }
//                if(!StringUtils.isEmpty(allImageOperations)){
//                    if(StringUtils.isEmpty(all_operations)){
//                        all_operations = allImageOperations+System.lineSeparator()+"\t";
//                    } else{
//                        all_operations = all_operations+allImageOperations+System.lineSeparator()+"\t";
//                    }
//                }


                GlobalConstants.all_operations=all_operations;

//                if(StringUtils.isEmpty(pageName)){
//                    fileName = "DomExtractor_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
//                } else {
//                    fileName = pageName+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
//                }

//                if(!StringUtils.isEmpty(all)) {
////                    if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName)) {
////                        Generic.writeText(all, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName, false);
////                    }
//
//                } else{
//                    all= "null";
//                    JOptionPane.showMessageDialog(null, "Objects not found", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
//                }
//                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName);
//                pb.start();
            } else{
                JOptionPane.showMessageDialog(null, "Select atleast one Object control", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return all;
    }

    //###############################################################################################
    //###############################################################################################




    //###############################################################################################
    //###############################################################################################
    public void getLinkOperation(){
        Set set = hmLinks.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   lnk"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allLinkOperations)){
                allLinkOperations = value;
            } else{
                allLinkOperations = allLinkOperations+value;
            }
        }

    }
    public void getButtonOperation(){
        Set set = hmButtons.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   btn"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allButtonOperations)){
                allButtonOperations = value;
            } else{
                allButtonOperations = allButtonOperations+value;
            }
        }

    }

    public void getInputOperation(){
        Set set = hmEdits.entrySet();
        String valueEdit;
        Iterator iteratorEdit = set.iterator();
        String opName;

        while(iteratorEdit.hasNext()) {
            Map.Entry mentry = (Map.Entry)iteratorEdit.next();

            if(firstFive(mentry.getValue().toString()).equalsIgnoreCase("input")) {
                opName= mentry.getValue().toString().replaceAll("input","");
                valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                        "\t\t" + mentry.getValue().toString() + ".sendKeys(input_value); " + System.lineSeparator() +
                        "\t}" + System.lineSeparator();
            } else{
                opName= mentry.getValue().toString().replaceAll("input","");
                valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                        "\t\tinput" + mentry.getValue().toString() + ".sendKeys(input_value); " + System.lineSeparator() +
                        "\t}" + System.lineSeparator();
            }

            if(StringUtils.isEmpty(allInputOperations)){
                allInputOperations = valueEdit;
            } else{
                allInputOperations = allInputOperations+valueEdit;
            }
        }

    }
    public void getRadioButtonOperations(){
        Set set = hmRadioButtons.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allRadioButtonOperations)){
                allRadioButtonOperations = value;
            } else{
                allRadioButtonOperations = allRadioButtonOperations+value;
            }
        }
    }
    public void getListOperations(){
        Set set = hmComboBox.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void select"+mentry.getValue().toString()+"(String itemToSelect){   " +System.lineSeparator()+
                    "\t\tSelect list = new Select(list"+mentry.getValue()+");"+System.lineSeparator()+
                    "\t\tlist.selectByVisibleText(itemToSelect);"+System.lineSeparator()+
                    "\t}";

            if(StringUtils.isEmpty(allListOperations)){
                allListOperations = value;
            } else{
                allListOperations = allListOperations+value;
            }
        }
    }
    public void getCheckBoxOperations(){
        Set set = hmCheckBox.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   chkbox"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allCheckBoxOperations)){
                allCheckBoxOperations = value;
            } else{
                allCheckBoxOperations = allCheckBoxOperations+value;
            }
        }
    }
//    public void getTextOperations(){
//        Set set = hmTexts.entrySet();
//        String value;
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry)iterator.next();
//
//            value = "public void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
//            if(StringUtils.isEmpty(allTextOperations)){
//                allTextOperations = value;
//            } else{
//                allTextOperations = "\t"+allTextOperations+value;
//            }
//        }
//    }
//    public void getImageOperations(){
//        Set set = hmImages.entrySet();
//        String value;
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry)iterator.next();
//
//            value = "public void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
//            if(StringUtils.isEmpty(allImageOperations)){
//                allImageOperations = value;
//            } else{
//                allImageOperations = "\t"+allImageOperations+value;
//            }
//        }
//    }


    public void getLinks(){
        listStrings.clear();
        String lnkvarName=null;
        innerxpath=null;
        all_links=null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator=0;
        //     Link
        // Elements links = document.select("a[href]");
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            if (!StringUtils.isEmpty(link.text())) {
                id = link.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = link.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = link.text();
                    if (text != null) {
                        //text = "'" + text + "'";
                        text = "'" + text + "'";

                        if (innerxpath != null) {
                            xpath = "//a/" + innerxpath + "[text()=" + text + "]";
                        } else {
                            xpath = "//a[text()=" + text + "]";
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }


                    text = Generic.removeSpecialChars(text);
                    lnkvarName = "lnk" + text;
                    webelement = "public WebElement " + lnkvarName + ";";

                    iterator = iterator + 1;
                    if (findby != null) {
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    }
                    if (!stringBuilder.toString().contains(webelement)) {
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }
                }
            }
        }


        all_links = stringBuilder.toString();

    }

    public void getButtons(Elements input_buttons){
        listStrings.clear();
        innerxpath=null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator=0;
        Elements buttons = document.getElementsByTag("button");
        for (Element button : buttons) {
            text = button.text();
            if (!StringUtils.isEmpty(text) || text!=null) {
                id = button.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = button.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    //text = button.text();
                    text = "'" + text + "'";
                    if (innerxpath != null) {
                        xpath = "//button/" + innerxpath + "[text()=" + text + "]";
                    } else {
                        xpath = "//button[text()=" + text + "]";
                    }
                    xpath = "\"" + xpath + "\"";
                    findby = "@FindBy(xpath = " + xpath + ")";
                }

                text = Generic.removeSpecialChars(text);
                webelement = "public WebElement btn" + text + ";";
                hmButtons.put(iterator,text);
                iterator = iterator+1;
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
                nullvars();
            }
        }
        //Elements input_buttons = document.getElementsByTag("input");
        for (Element input_button : input_buttons) {
            if (input_button.attr("type").equalsIgnoreCase("submit")) {
                id = input_button.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_button.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_button.attr("value");
                    text = "'" + text + "'";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@value=\"" + text + "\"]";
                    } else {
                        xpath = "//input[@value=\"" + text + "\"]";
                    }
                    xpath = "\"" + xpath + "\"";
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(text);
                webelement = "public WebElement btn" + text + ";";
                hmButtons.put(iterator,text);
                iterator = iterator+1;
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
                nullvars();
            }
        }
        all_buttons = stringBuilder.toString();
    }


    public void getCheckbox(Elements input_Checkboxes){
        listStrings.clear();
        innerxpath=null;
        all_checkboxes=null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator=0;
        for (Element input_checkbox : input_Checkboxes) {
            if (input_checkbox.attr("type").equalsIgnoreCase("checkbox")) {
                id = input_checkbox.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_checkbox.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_checkbox.attr("name");
                    text = "'" + text + "'";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@name=\"" + text + "\"]";
                    } else {
                        xpath = "//input[@name=\"" + text + "\"]";
                    }
                    xpath = "\"" + xpath + "\"";
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(text);
                webelement = "public WebElement chkbox" + text + ";";
                hmCheckBox.put(iterator,text);
                iterator = iterator+1;
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
                nullvars();
            }
        }
        all_checkboxes = stringBuilder.toString();

    }
    public String firstFive(String str) {
//        if(str.length() < 5){
//            return str.substring(0, 5);
//        } else{
//            return str;
//        }
        return str.length() < 5 ? str : str.substring(0, 5);
    }
    public void getEdit(Elements input_Edits){
        listStrings.clear();
        int iterator=0;
        innerxpath=null;
        all_edits=null;
        stringBuilder.delete(0, stringBuilder.length());

        for (Element input_edit : input_Edits) {
            if (input_edit.attr("type").equalsIgnoreCase("input")||input_edit.attr("type").equalsIgnoreCase("text")||input_edit.attr("type").equalsIgnoreCase("password")||input_edit.attr("type").equalsIgnoreCase("email")||input_edit.attr("type").equalsIgnoreCase("number")||input_edit.attr("type").equalsIgnoreCase("search")||input_edit.attr("type").equalsIgnoreCase("url")||input_edit.attr("type").equalsIgnoreCase("tel")) {
                text =  input_edit.attr("name");
                if (!StringUtils.isEmpty(text) || text!=null) {
                    id = input_edit.attr("id");
                    if (!StringUtils.isEmpty(id)) {
                        id = "\"" + id + "\"";
                        findby = "@FindBy(id=" + id + ")";
                    } else {
                        String linkInnerH = input_edit.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }
                        text = input_edit.attr("name");
                        text = "'" + text + "'";
                        if (innerxpath != null) {
                            // xpath = "//input/" + innerxpath + "[@name=\"" + text + "\"]";
                            xpath = "//input/" + innerxpath + "[@name=" + text + "]";
                        } else {
                            //xpath = "//input[@name=\"" + text + "\"]";
                            xpath = "//input[@name=" + text + "]";
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";
                    }

                    text = Generic.removeSpecialChars(text);
                    if (firstFive(text).equalsIgnoreCase("input")) {
                        webelement = "public WebElement " + text + ";";
                    } else {
                        webelement = "public WebElement input" + text + ";";
                    }

                    hmEdits.put(iterator, text);
                    iterator = iterator + 1;
                    if (findby != null) {
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                }
            }
        }
        all_edits = stringBuilder.toString();

    }

    public void getImages(Elements input_img){
        listStrings.clear();
        innerxpath=null;
        all_images=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements images = document.getElementsByTag("img");
        for (Element img : images) {

            id = img.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = img.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = img.attr("alt");
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//img/" + innerxpath + "[@alt=\"" + text + "\"]";
                } else {
                    xpath = "//img[@alt=\"" + text + "\"]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement img" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
       // Elements input_images = document.getElementsByTag("img");
        for (Element img : input_img) {

            id = img.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = img.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = img.attr("alt");
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//img/" + innerxpath + "[@alt=\"" + text + "\"]";
                } else {
                    xpath = "//img[@alt=\"" + text + "\"]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement img" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_images = stringBuilder.toString();
    }

    public void getCombobox(){
        listStrings.clear();
        innerxpath=null;
        all_comboboxes=null;
        int iterator=0;
        stringBuilder.delete(0, stringBuilder.length());
        Elements comboboxes = document.getElementsByTag("select");
        for (Element cmbox : comboboxes) {

            id = cmbox.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = cmbox.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = cmbox.attr("name");
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//select/" + innerxpath + "[@name=\"" + text + "\"]";
                } else {
                    xpath = "//select[@name=\"" + text + "\"]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement list" + text + ";";
            hmComboBox.put(iterator,text);
            iterator = iterator+1;
            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_comboboxes = stringBuilder.toString();
    }
    public void getTextArea(){
        listStrings.clear();
        innerxpath=null;
        all_textarea=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements textAreas = document.getElementsByTag("textarea");
        for (Element textarea : textAreas) {

            id = textarea.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = textarea.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = textarea.attr("name");
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//textarea/" + innerxpath + "[@name=\"" + text + "\"]";
                } else {
                    xpath = "//textarea[@name=\"" + text + "\"]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement textarea" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_textarea = stringBuilder.toString();
    }
    public void getRadioButton(Elements input_radios){
        listStrings.clear();
        innerxpath=null;
        all_radiobuttons=null;
        int iterator=0;
        stringBuilder.delete(0, stringBuilder.length());
        for (Element input_radio : input_radios) {
            if (input_radio.attr("type").equalsIgnoreCase("radio")) {
                id = input_radio.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_radio.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_radio.attr("name");
                    text = "'" + text + "'";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@name=\"" + text + "\"]";
                    } else {
                        xpath = "//input[@name=\"" + text + "\"]";
                    }
                    xpath = "\"" + xpath + "\"";
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(text);
                webelement = "public WebElement radio" + text + ";";
                hmRadioButtons.put(iterator,text);
                iterator = iterator+1;
                if (findby != null) {
                    pageObjectmodel = cachelookup + System.lineSeparator()+ "\t" + findby + System.lineSeparator() + "\t"+ webelement + System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
                nullvars();
            }
        }
        all_radiobuttons = stringBuilder.toString();
    }

    public void getText(){
        all_texts = null;
        stringBuilder.delete(0, stringBuilder.length());
        geth1();
        geth2();
        geth3();
        geth4();
        // geth5(pomType);
        geth6();
        //getp();
        getsmall();
    }

    public void geth1(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h1s = document.getElementsByTag("h1");
        for (Element h1 : text_h1s) {
            id = h1.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h1.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h1.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h1/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h1[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth2(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h2s = document.getElementsByTag("h2");
        for (Element h2 : text_h2s) {
            id = h2.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h2.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h2.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h2/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h2[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth3(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h3s = document.getElementsByTag("h3");
        for (Element h3 : text_h3s) {
            id = h3.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h3.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h3.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h3/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h3[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth4(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h4s = document.getElementsByTag("h4");
        for (Element h4 : text_h4s) {
            id = h4.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h4.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h4.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h4/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h4[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void geth5(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h5s = document.getElementsByTag("h5");
        for (Element h5 : text_h5s) {
            id = h5.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h5.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }

                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h5.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h5/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h5[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth6(){
        listStrings.clear();
        innerxpath=null;
        Elements text_h6s = document.getElementsByTag("h6");
        for (Element h6 : text_h6s) {
            id = h6.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h6.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h6.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//h6/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h6[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void getsmall(){
        listStrings.clear();
        innerxpath=null;
        Elements text_smalls = document.getElementsByTag("small");
        for (Element small : text_smalls) {
            id = small.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = small.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = small.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//small/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//small[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator() + "\t"+ webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void getp(){
        listStrings.clear();
        innerxpath=null;
        Elements textps = document.getElementsByTag("p");
        for (Element p : textps) {
            id = p.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = p.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = p.text();
                text = "'" + text + "'";
                if (innerxpath != null) {
                    xpath = "//p/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//p[text()=" + text + "]";
                }
                xpath = "\"" + xpath + "\"";
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(text);
            webelement = "public WebElement txt" + text + ";";

            if (findby != null) {
                pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+ findby + System.lineSeparator()+ "\t" + webelement+System.lineSeparator();
            }
            stringBuilder.append(pageObjectmodel);
            stringBuilder.append(System.lineSeparator());
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void nullvars(){
        findby = null;
        webelement = null;
        innerxpath = null;
        text=null;
        xpath=null;
        id=null;
        enumPropertiesmodel=null;
        pageObjectmodel=null;
    }



}
