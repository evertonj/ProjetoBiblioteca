/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> valores;

    public UsuarioTableModel(List<Usuario> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getNome();
            case 1:
                return usuario.getSerie();
           case 2:
             return usuario.getListEmail().get(0);
           case 3:
               return usuario.getListTelefone().get(0);
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
                return coluna = "Série";
            case 2:
                return coluna = "E-mail";
            case 3:
                return coluna = "Telefone";
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
    
    public Usuario get(int row) {
        return valores.get(row);
    }
    //Teste
}
