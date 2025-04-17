package myproject.tijada_oop;

import javax.swing.table.DefaultTableModel;

public class Table_edit extends DefaultTableModel {

    public Table_edit(Object[][] data, String[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
