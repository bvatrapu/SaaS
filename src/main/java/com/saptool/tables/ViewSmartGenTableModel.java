package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ViewSmartGenTableModel extends AbstractTableModel {
    private final List<ViewSmartGenTable> viewSmartGenTables;

    private final String[] columnNames = new String[] {
            "# No", "Script Name"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewSmartGenTableModel(List<ViewSmartGenTable> viewFileList)
    {
        this.viewSmartGenTables = viewFileList;
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
        return viewSmartGenTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewSmartGenTable row = viewSmartGenTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getno();
        }
        else if(1 == columnIndex) {
            return row.getScriptName();
        }

        return null;
    }
}
