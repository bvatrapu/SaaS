package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewContsantsTableModel extends AbstractTableModel {
    private final List<ViewContsantsTable> viewContsantsTables;

    private final String[] columnNames = new String[] {
            "Sno", "Name", "Value"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewContsantsTableModel(List<ViewContsantsTable> viewContsantsTables)
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
        ViewContsantsTable row = viewContsantsTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
       else if(2 == columnIndex){
            return row.getDescription();
        }
        return null;
    }
}
