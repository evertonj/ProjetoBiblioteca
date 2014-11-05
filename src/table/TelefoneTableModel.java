/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Telefone;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago
 */
public class TelefoneTableModel extends AbstractTableModel {

    private List<Telefone> valores;

    public TelefoneTableModel(List<Telefone> valores) {
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
       Telefone telefone  = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return telefone.getTelefone();
           }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Telefone";
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
    
    public Telefone get(int row) {
        return valores.get(row);
    }
    //Teste
}
