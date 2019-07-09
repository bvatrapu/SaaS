package com.saptool.ui.SmartHub.SpyIntellij;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPagesTable {

    private int sno;
    private String name;
    private boolean selection;


    public ViewPagesTable(int sno, String name, boolean selection){
        this.sno = sno;
        this.name = name;
        this.selection = selection;
    }


    public String getName() {
        return name;
    }
    public boolean getselection(){
        return selection;
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
