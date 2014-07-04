/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.table;

import biblioteca.entity.Login;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class LoginTableModel extends AbstractTableModel {

    private List<Login> valores;

    public LoginTableModel(List<Login> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Login login = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return login.getId();
            case 1:
                return login.getNome();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Código";
            case 1:
                return coluna = "Nome";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
        }
        return null;
    }

    public Login get(int row) {
        return valores.get(row);
    }
}
