/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.ExcluirEmprestimo;
import entity.InfoDevolucao;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class DadosDevolucaoTableModel extends AbstractTableModel {

    private List<InfoDevolucao> valores;

    public DadosDevolucaoTableModel(List<InfoDevolucao> valores) {
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
        InfoDevolucao dev = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dev.getNomeUsuario();
            case 1:
                return dev.getSerieUsuario();
            case 2:
                return dev.getNumeroSequencial();
            case 3:
                return dev.getTituloObra();
            case 4:
                return dev.getDataDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            case 5:
                return dev.getNomeOperador();
        }
        return null;
    }

    public InfoDevolucao get(int row) {
        return valores.get(row);
    }
}
