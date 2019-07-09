package com.saptool.tables;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPagesTable {

    private int sno;
    private String pageName;

    public ViewPagesTable(int sno, String fileName){
        this.sno = sno;
        this.pageName = fileName;
    }


    public String getPageName() {
        return pageName;
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
