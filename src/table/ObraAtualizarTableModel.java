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
        return 6;
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
            case 4:
                if (!obra.getAutores().isEmpty()) {
                    return obra.getAutores().get(0);
                } else {
                    return "Nenhum Autor Cadastrado";
                }
            case 5:
                if (!obra.getExemplar().isEmpty()) {
                    return obra.getExemplar().get(obra.getExemplar().size() - 1).getNumeroSequancial();
                } else {
                    return 1;
                }
        }
        return null;
    }

      public Obra get(int row) {
        return valores.get(row);
    }
}
