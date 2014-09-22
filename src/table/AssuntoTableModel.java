/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Assunto;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class AssuntoTableModel extends AbstractTableModel {

    private List<Assunto> valores;

    public AssuntoTableModel(List<Assunto> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Assunto assunto = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return assunto.getNome();
                       
            
          
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Nome";
           
         
           
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
           
        }
        return null;
    }
    
    public Assunto get(int row) {
        return valores.get(row);
    }
}
