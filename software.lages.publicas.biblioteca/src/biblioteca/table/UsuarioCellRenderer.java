/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Alex
 */
public class UsuarioCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
        if (row % 2 == 0) {
            setBackground(Color.gray);
        }else {
            setBackground(null);
        }        
        if (isSelected) {
            setBackground(Color.blue);
        }
        Font fonte = new Font("Franklin Gothic Medium", Font.PLAIN, 15);
        table.setFont(fonte);
        return this;
    }
   
}
