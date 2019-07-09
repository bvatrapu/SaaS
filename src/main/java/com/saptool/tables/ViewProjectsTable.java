package com.saptool.tables;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewProjectsTable {

    private int sno;
    private String projectName;
    private String createDate;


    public ViewProjectsTable(int sno, String fileName, String createDate){
        this.sno = sno;
        this.projectName = fileName;
        this.createDate = createDate;
    }


    public String getprojectName() {
        return projectName;
    }
    public String getcreateDate(){
        return createDate;
    }

    public int getSno()
    {
        return sno;
    }

    public void setselectName(int sno)
    {
        this.sno = sno;
    }
}
