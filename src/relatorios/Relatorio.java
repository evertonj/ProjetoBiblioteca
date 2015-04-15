/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

/**
 *
 * @author Thiago
 */
public class Relatorio {

    private String stringConnect;
    private String stringRel;

    public boolean defineStringConnect(String tipo) {

        if (tipo.equals("UsuarioNome")) {
            setStringConnect("SELECT\n"
                    + "     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     email_usuario.`email` AS email_usuario_email\n"
                    + "FROM\n"
                    + "     `usuario` usuario INNER JOIN `telefone_usuario` telefone_usuario ON usuario.`id` = telefone_usuario.`idUsuario`\n"
                    + "     INNER JOIN `email_usuario` email_usuario ON usuario.`id` = email_usuario.`idUsuario`\n"
                    + "GROUP BY\n"
                    + "     usuario.`id`\n"
                    + "ORDER BY\n"
                    + "     usuario.`nome` ASC");
            setStringRel("/relatorios/RelatorioUsuarioNome.jasper");
            return true;
        } else if (tipo.equals("UsuarioSérie")) {
            setStringConnect("SELECT\n"
                    + "     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     email_usuario.`email` AS email_usuario_email\n"
                    + "FROM\n"
                    + "     `usuario` usuario INNER JOIN `telefone_usuario` telefone_usuario ON usuario.`id` = telefone_usuario.`idUsuario`\n"
                    + "     INNER JOIN `email_usuario` email_usuario ON usuario.`id` = email_usuario.`idUsuario`\n"
                    + "GROUP BY\n"
                    + "     usuario.`id`\n"
                    + "ORDER BY\n"
                    + "     usuario.`serie`");
            setStringRel("/relatorios/RelatorioUsuarioSerie.jasper");
            return true;
        } else if (tipo.equals("AutorNome")) {
            setStringConnect("select * from autor order by nome;");
            setStringRel("/relatorios/RelatorioAutorNome.jasper");
            return true;
        } else if (tipo.equals("AutorSobrenome")) {
            setStringConnect("select * from autor order by sobrenome;");
            setStringRel("/relatorios/RelatorioAutorSobrenome.jasper");
            return true;
        } else if (tipo.equals("EditorasNome")) {
            setStringConnect("select  * from editora order by nome;");
            setStringRel("/relatorios/RelatorioEditorasNome.jasper");
            return true;
        }else if (tipo.equals("EditorasCidade")) {
            setStringConnect("select  * from editora order by cidade;");
            setStringRel("/relatorios/RelatorioEditorasCidade.jasper");
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return the stringConnect
     */
    public String getStringConnect() {
        return stringConnect;
    }

    /**
     * @param stringConnect the stringConnect to set
     */
    public void setStringConnect(String stringConnect) {
        this.stringConnect = stringConnect;
    }

    /**
     * @return the stringRel
     */
    public String getStringRel() {
        return stringRel;
    }

    /**
     * @param stringRel the stringRel to set
     */
    public void setStringRel(String stringRel) {
        this.stringRel = stringRel;
    }

}
