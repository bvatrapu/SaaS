package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewProjectsTableModel extends AbstractTableModel {
    private final List<ViewProjectsTable> viewProjectList;

    private final String[] columnNames = new String[] {
            "Sno", "Project Name", "Created Date"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewProjectsTableModel(List<ViewProjectsTable> viewFileList)
    {
        this.viewProjectList = viewFileList;
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
        return viewProjectList.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewProjectsTable row = viewProjectList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getprojectName();
        }
       else if(2 == columnIndex){
            return row.getcreateDate();
        }
        return null;
    }
}
