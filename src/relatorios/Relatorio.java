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
    private String situacao;
    private String nome;
    private String tipo;
    public boolean filtroLetra(String tipo){
         setStringConnect("SELECT\n"
                    + "     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     email_usuario.`email` AS email_usuario_email,\n"
                    + "     usuario.`DataCadastro` AS usuario_DataCadastro,\n"
                    + "     usuario.`situacao` AS usuario_situacao\n"
                    + "FROM\n"
                    + "     `usuario` usuario INNER JOIN `telefone_usuario` telefone_usuario ON usuario.`id` = telefone_usuario.`idUsuario`\n"
                    + "     INNER JOIN `email_usuario` email_usuario ON usuario.`id` = email_usuario.`idUsuario`\n"
                    + "GROUP BY\n"
                    + "     usuario.`id`\n"
                    + "ORDER BY\n"
                    + "     usuario.`nome` ASC where nome like'%"+tipo+"'");
            setStringRel("/relatorios/RelatorioUsuario.jasper");
        return true;
    }
    public boolean defineStringConnect(String tipo) {

        if (tipo.equals("UsuarioNome")) {
            setStringConnect("SELECT\n"
                    + "     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     email_usuario.`email` AS email_usuario_email,\n"
                    + "     usuario.`DataCadastro` AS usuario_DataCadastro,\n"
                    + "     usuario.`situacao` AS usuario_situacao\n"
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
            setStringConnect("     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     email_usuario.`email` AS email_usuario_email,\n"
                    + "     usuario.`DataCadastro` AS usuario_DataCadastro,\n"
                    + "     usuario.`situacao` AS usuario_situacao\n"
                    + "FROM\n"
                    + "     `usuario` usuario INNER JOIN `telefone_usuario` telefone_usuario ON usuario.`id` = telefone_usuario.`idUsuario`\n"
                    + "     INNER JOIN `email_usuario` email_usuario ON usuario.`id` = email_usuario.`idUsuario`\n"
                    + "GROUP BY\n"
                    + "     usuario.`id`\n"
                    + "ORDER BY\n"
                    + "     usuario.`serie` ASC");
            setStringRel("/relatorios/RelatorioUsuarioSerie.jasper");
            return true;
        } else if (tipo.equals("AutorNome")) {
            setStringConnect("select * from autor order by autor_nome;");
            setStringRel("/relatorios/RelatorioAutorNome.jasper");
            return true;
        } else if (tipo.equals("AutorSobrenome")) {
            setStringConnect("select * from autor order by sobrenome;");
            setStringRel("/relatorios/RelatorioAutorSobrenome.jasper");
            return true;
        } else if (tipo.equals("EditorasNome")) {
            setStringConnect("select  * from editora order by editora_nome;");
            setStringRel("/relatorios/RelatorioEditorasNome.jasper");
            return true;
        } else if (tipo.equals("EditorasCidade")) {
            setStringConnect("select  * from editora order by cidade;");
            setStringRel("/relatorios/RelatorioEditorasCidade.jasper");
            return true;
        } else {
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

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
