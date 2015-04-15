/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Everton Spindola
 */
public enum EnumSituacaoUsuario {

    ATIVO("ATIVO"),
    INATIVO("INATIVO"),
    SUSPENSO("SUSPENSO");
    

    private final String situacao;

    private EnumSituacaoUsuario(String situacao) {
        this.situacao = situacao;
    }

    public static EnumSituacaoUsuario getSituacao(String situacao) {
        switch (situacao) {
            case "ATIVO":
                return EnumSituacaoUsuario.ATIVO;
            case "INATIVO":
                return EnumSituacaoUsuario.INATIVO;
            case "SUSPENSO":
                return EnumSituacaoUsuario.SUSPENSO;
            }
        return null;
    }

}
