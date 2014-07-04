/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDeEditora.table;

import CadastroDeEditora.entity.Editora;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class EditoraTableModel extends AbstractTableModel {

    private List<Editora> valores;

    public EditoraTableModel(List<Editora> valores) {
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
        Editora obra = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obra.getNome();
            case 1:
                return obra.getCidade();
            case 2:
                return obra.getEmail();
            case 3:
                 return obra.getTelefone();
          
            
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
                return coluna = "Cidade";
            case 2:
                return coluna = "Email";
         
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
        }
        return null;
    }
    
    public Editora get(int row) {
        return valores.get(row);
    }
}
