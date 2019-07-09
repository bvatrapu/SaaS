package com.saptool.tables;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ViewExecutionLabTestScriptsTable {
    private int no;
    private String scriptName;


    public ViewExecutionLabTestScriptsTable(int no, String scriptName){
        this.no = no;
        this.scriptName = scriptName;
    }


    public String getScriptName() {
        return scriptName;
    }

    public int getno()
    {
        return no;
    }

    public void setselectName(int no)
    {
        this.no = no;
    }
}
