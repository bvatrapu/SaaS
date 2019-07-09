package com.saptool.tables;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ViewTestScriptTable {
    private int stepno;
    private String stepDesc;
    private String stepExpected;

    public ViewTestScriptTable(int stepno, String stepDesc, String stepExpected){
        this.stepno = stepno;
        this.stepDesc = stepDesc;
        this.stepExpected = stepExpected;
    }


    public String getStepDesc() {
        return stepDesc;
    }
    public String getStepExpected(){
        return stepExpected;
    }

    public int getStepno()
    {
        return stepno;
    }

    public void setselectName(int sno)
    {
        this.stepno = stepno;
    }
}
