package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPagesTableModel extends AbstractTableModel {
    private final List<ViewPagesTable> viewPagesTables;

    private final String[] columnNames = new String[] {
            "Sno", "Page Name"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class
    };

    public ViewPagesTableModel(List<ViewPagesTable> viewFileList)
    {
        this.viewPagesTables = viewFileList;
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
        return viewPagesTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewPagesTable row = viewPagesTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getPageName();
        }

        return null;
    }
}
