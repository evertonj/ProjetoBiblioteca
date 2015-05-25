/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Reserva;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class ReservaTableModel extends AbstractTableModel {

    private List<Reserva> valores;

    public ReservaTableModel(List<Reserva> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reserva = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reserva.getId();
            case 1:
                return reserva.getDataReserva().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            case 2:
                return reserva.getUsuario().getNome();
            case 3:
                return reserva.getUsuario().getListTelefone().get(0) != null ? reserva.getUsuario().getListTelefone().get(0).getTelefone() : "Telefone não cadastrado";
            case 4:
                return reserva.getUsuario().getListEmail().get(0) != null ? reserva.getUsuario().getListEmail().get(0).getEmail() : "Email não cadastrado";
            case 5:
                return reserva.getObra().getTitulo();
            case 6:
                return reserva.getObra().getAssunto();
            case 7:
                return reserva.getObra().getEdicao();
        }
        return null;
    }

    public Reserva get(int row) {
        return valores.get(row);
    }
}
