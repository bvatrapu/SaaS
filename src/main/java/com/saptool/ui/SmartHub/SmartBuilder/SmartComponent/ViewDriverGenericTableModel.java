package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewDriverGenericTableModel extends AbstractTableModel {
    private final List<ViewPageMethodsTable> viewDriverGenericTables;
    private final String[] columnNames = new String[] {
            "Sno", "Method Name", "Method Description"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewDriverGenericTableModel(List<ViewPageMethodsTable> viewDriverGeneric)
    {
        this.viewDriverGenericTables = viewDriverGeneric;
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
        return viewDriverGenericTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewPageMethodsTable row = viewDriverGenericTables.get(rowIndex);
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
