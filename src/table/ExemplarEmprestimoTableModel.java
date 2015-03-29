/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.ExemplarEmprestimo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class ExemplarEmprestimoTableModel extends AbstractTableModel {

    private List<ExemplarEmprestimo> valores;

    public ExemplarEmprestimoTableModel(List<ExemplarEmprestimo> valores) {
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
        ExemplarEmprestimo exemplar = valores.get(rowIndex);
        String numeroExemplar = String.valueOf(exemplar.getObra().getId());
        numeroExemplar += String.valueOf(exemplar.getExemplar().getId());
        numeroExemplar += String.valueOf(exemplar.getExemplar().getNumeroSequancial());
        switch (columnIndex) {
            case 0:
                return exemplar.getExemplar().getId();
            case 1:
                return exemplar.getObra().getTitulo();
            case 2:
                return exemplar.getObra().getAutores()!= null ? exemplar.getObra().getAutores().get(0).getNome() +" "+ exemplar.getObra().getAutores().get(0).getSobrenome():"";
            case 3:
                return exemplar.getObra().getEdicao();
            case 4:
               return exemplar.getObra().getAno();
            case 5:
                return exemplar.getObra().getEditora().getNome();
            case 6:
                return exemplar.getExemplar().getSituacao().toString();
        }
        return null;
    }

      public ExemplarEmprestimo get(int row) {
        return valores.get(row);
    }
}
