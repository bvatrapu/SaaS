package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent;

import com.saptool.tables.ViewPageOperationsTable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPageMethodsTableModel extends AbstractTableModel {
    private final List<ViewPageMethodsTable> viewPageMethodsList;
    private final String[] columnNames = new String[] {
            "Sno", "Method Name", "Method Description"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewPageMethodsTableModel(List<ViewPageMethodsTable> viewPageMethods)
    {
        this.viewPageMethodsList = viewPageMethods;
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
        return viewPageMethodsList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewPageMethodsTable row = viewPageMethodsList.get(rowIndex);
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
