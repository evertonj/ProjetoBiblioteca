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
public enum EnumSituacaoExemplar {

    EMPRESTADO("EMPRESTADO"),
    DISPONIVEL("DISPONIVEL"),
    CONSULTA_LOCAL("CONSULTA_LOCAL"),
    RESERVADO("RESERVADO"),
    INDISPONIVEL("INDISPONIVEL");

    private final String situacao;

    private EnumSituacaoExemplar(String situacao) {
        this.situacao = situacao;
    }

    public static EnumSituacaoExemplar getSituacao(String situacao) {
        switch (situacao) {
            case "EMPRESTADO":
                return EnumSituacaoExemplar.EMPRESTADO;
            case "DISPONIVEL":
                return EnumSituacaoExemplar.DISPONIVEL;
            case "CONSULTA_LOCAL":
                return EnumSituacaoExemplar.CONSULTA_LOCAL;
            case "RESERVADO":
                return EnumSituacaoExemplar.RESERVADO;
            case "INDISPONIVEL":
                return EnumSituacaoExemplar.INDISPONIVEL;
        }
        return null;
    }

}
