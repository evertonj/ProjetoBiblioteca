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
public class ExemplarColumnModel extends DefaultTableColumnModel{
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
    public ExemplarColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 10 * letra, fm, true, "Fornecedor"));
        addColumn(criaColuna(1, 13 * letra, fm, true, "Data de Cadastro"));
        addColumn(criaColuna(2, 13 * letra, fm, true, "Data de Aquisição"));
        addColumn(criaColuna(3, 10* letra, fm, true, "Numero Sequencial"));
        addColumn(criaColuna(4, 17 * letra, fm, true, "Obra"));
        addColumn(criaColuna(5, 17 * letra, fm, true, "Situação"));
    } 
}
