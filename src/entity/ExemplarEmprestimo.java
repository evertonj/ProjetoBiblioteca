/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Alex
 */
public class ExemplarEmprestimo {

    public ExemplarEmprestimo(Exemplar exemplar, Obra obra) {
        this.exemplar = exemplar;
        this.obra = obra;
    }

        
    
    public ExemplarEmprestimo(){};
 
   private Exemplar exemplar;
   private Obra obra;

    /**
     * @return the exemplar
     */
    public Exemplar getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the obra
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * @param obra the obra to set
     */
    public void setObra(Obra obra) {
        this.obra = obra;
    }

}
