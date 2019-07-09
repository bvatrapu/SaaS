package com.saptool.tables;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPageObjectsTable {

    private int sno;
    private String name;
    private String description;


    public ViewPageObjectsTable(int sno, String name, String description){
        this.sno = sno;
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
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
