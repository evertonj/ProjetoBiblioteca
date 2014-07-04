/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDeEditora.entity.exceptions;

/**
 *
 * @author Marcos
 */
public class NameException extends Exception {

    /**
     * Creates a new instance of
     * <code>NameException</code> without detail message.
     */
    public NameException() {
    }

    /**
     * Constructs an instance of
     * <code>NameException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NameException(String msg) {
        super(msg);
    }
}
