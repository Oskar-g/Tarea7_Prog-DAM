/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.dam.tarea7.dao.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class DAMDaoException extends Exception {

    public DAMDaoException(String exception) {
        super(exception);
    }

    @Override
    public void setStackTrace(StackTraceElement[] stes) {
        super.setStackTrace(stes); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace(PrintStream stream) {
        super.printStackTrace(stream); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable initCause(Throwable thrwbl) {
        return super.initCause(thrwbl); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }

}
