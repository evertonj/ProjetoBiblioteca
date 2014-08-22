/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Autor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class AutorTableModel extends AbstractTableModel {

    private List<Autor> valores;

    public AutorTableModel(List<Autor> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor obra = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obra.getNome();
            case 1:
                return obra.getSobrenome();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Nome";
            case 1:
                return coluna = "Sobrenome";
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
    
    public Autor get(int row) {
        return valores.get(row);
    }
}
