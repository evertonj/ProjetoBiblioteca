/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.entity.exceptions;

/**
 *
 * @author Bya
 */
public class PasswordException extends Exception {

    /**
     * Creates a new instance of <code>PasswordException</code> without detail
     * message.
     */
    public PasswordException() {
    }

    /**
     * Constructs an instance of <code>PasswordException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordException(String msg) {
        super(msg);
    }
}
