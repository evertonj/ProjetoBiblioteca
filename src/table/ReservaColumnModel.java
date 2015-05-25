/*
 * LivroColumnModel.java
 *
 * Created on 29 de Novembro de 2006, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package table;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author aalano
 */
public class ReservaColumnModel extends DefaultTableColumnModel{
    private TableColumn criaColuna(int columnIndex, int largura,
            FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo)
            largura = larguraTitulo;
        TableColumn col = new TableColumn(columnIndex);
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }
    /** Creates a new instance of TarefasColumnModel */
    public ReservaColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 6 * letra, fm, true, "Posição"));
        addColumn(criaColuna(1, 6 * letra, fm, true, "Data Reserva"));
        addColumn(criaColuna(2, 6 * letra, fm, true, "Usuário"));
        addColumn(criaColuna(3, 19 * letra, fm, true, "Telefone"));
        addColumn(criaColuna(4, 16 * letra, fm, true, "Email"));
        addColumn(criaColuna(5, 10 * letra, fm, true, "Título"));
        addColumn(criaColuna(5, 10 * letra, fm, true, "Assunto"));
        addColumn(criaColuna(5, 10 * letra, fm, true, "Edição"));
    } 
}
