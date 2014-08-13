/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Obra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class ObraAtualizarTableModel extends AbstractTableModel {

    private List<Obra> valores;

    public ObraAtualizarTableModel(List<Obra> valores) {
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
        Obra obra = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obra.getId();
            case 1:
                return obra.getTitulo();
            case 2:
                return obra.getIsbn();
            case 3:
                return obra.getAssunto();
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
                return coluna = "Titulo";
            case 2:
                return coluna = "ISBN";

            case 3:
                return coluna = "Assunto";
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
            case 2:
                return String.class;
            case 3:
                return String.class;
        }
        return null;
    }

    public Obra get(int row) {
        return valores.get(row);
    }
}
