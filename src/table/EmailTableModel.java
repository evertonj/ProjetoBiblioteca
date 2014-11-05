/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago
 */
public class EmailTableModel extends AbstractTableModel {

    private List<String> valores;

    public EmailTableModel(List<String> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       String telefones  = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return telefones;
                   
           }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Email";
          
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
           
        }
        return null;
    }
    
    public String get(int row) {
        return valores.get(row);
    }
    //Teste
}
