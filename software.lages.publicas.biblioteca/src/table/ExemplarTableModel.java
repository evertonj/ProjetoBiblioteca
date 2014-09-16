/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import dao.ExemplarDAO;
import entity.Exemplar;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class ExemplarTableModel extends AbstractTableModel {

    private List<Exemplar> valores;

    public ExemplarTableModel(List<Exemplar> valores) {
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
        Exemplar exemplar = valores.get(rowIndex);
        ExemplarDAO dao = new ExemplarDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (columnIndex) {
            case 0:
                return exemplar.getFornecedor();
            case 1:
                return sdf.format(exemplar.getDataDeCadastro());
            case 2:
                return sdf.format(exemplar.getDataDeAquisicao());
            case 3:
                return exemplar.getNumeroSequancial();
            case 4:
               return dao.ObtemTituloDaObra(exemplar.getIdObra());
            case 5:
                return exemplar.getSituacao();
        }
        return null;
    }

      public Exemplar get(int row) {
        return valores.get(row);
    }
}
