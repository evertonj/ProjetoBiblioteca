/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.ExcluirEmprestimo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class ExcluirEmprestimoTableModel extends AbstractTableModel {

    private List<ExcluirEmprestimo> valores;

    public ExcluirEmprestimoTableModel(List<ExcluirEmprestimo> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExcluirEmprestimo exemplar = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return exemplar.getIdUsuario();
            case 1:
                return exemplar.getUsuario();
            case 2:
                return exemplar.getTitulo();
            case 3:
                return exemplar.getAutor();
            case 4:
                return exemplar.getEdicao();
            case 5:
                return exemplar.getAno();
            case 6:
                return exemplar.getEditora();
        }
        return null;
    }

    public ExcluirEmprestimo get(int row) {
        return valores.get(row);
    }
}
