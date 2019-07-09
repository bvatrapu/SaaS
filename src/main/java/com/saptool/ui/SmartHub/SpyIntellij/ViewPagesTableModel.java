package com.saptool.ui.SmartHub.SpyIntellij;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPagesTableModel extends AbstractTableModel {
    private final List<ViewPagesTable> viewContsantsTables;

    private final String[] columnNames = new String[] {
            "Sno", "Name", "Select"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,boolean.class
    };

    public ViewPagesTableModel(List<ViewPagesTable> viewContsantsTables)
    {
        this.viewContsantsTables = viewContsantsTables;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {

        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return viewContsantsTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewPagesTable row = viewContsantsTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
       else if(2 == columnIndex){
            return row.getselection();
        }
        return null;
    }
}
