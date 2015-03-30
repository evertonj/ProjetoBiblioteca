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
public class ExemplarObraColumnModel extends DefaultTableColumnModel{
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
    public ExemplarObraColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 6 * digito, fm, true, "Código"));
        addColumn(criaColuna(1, 15 * letra, fm, true, "Titulo"));
        addColumn(criaColuna(2, 15 * letra, fm, true, "Autor"));
        addColumn(criaColuna(3, 6 * letra, fm, true, "Edição"));
        addColumn(criaColuna(4, 4 * digito, fm, true, "Ano"));
        addColumn(criaColuna(5, 10 * letra, fm, true, "Editora"));
        addColumn(criaColuna(6, 10 * letra, fm, true, "Situação"));
    } 
}
