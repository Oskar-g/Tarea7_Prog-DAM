package swing.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Roach
 */
public class MsgDialog {

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param message contenido del mensaje
     */
    public static void showError(String mensaje) {
        showError("ERROR", mensaje);
    }

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param title titulo del mensaje
     * @param message contenido del mensaje
     */
    public static void showError(String title, String mensaje) {
        showMessageDialog(title, mensaje, JOptionPane.ERROR_MESSAGE);
    }

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param message contenido del mensaje
     */
    public static void showInfo(String mensaje) {
        showInfo("INFORMACION", mensaje);
    }

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param title titulo del mensaje
     * @param message contenido del mensaje
     */
    public static void showInfo(String title, String mensaje) {
        showMessageDialog(title, mensaje, JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param title titulo del mensaje
     * @param message contenido del mensaje
     */
    public static void showWarning(String mensaje) {
        showWarning("ADVERTENCIA", mensaje);
    }

    /*
     * Metodo que invoca un MsgDialog de swing de tipo Warning
     *
     * @param title titulo del mensaje
     * @param message contenido del mensaje
     */
    public static void showWarning(String title, String mensaje) {
        showMessageDialog(title, mensaje, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Metodo que invoca un MsgDialog de swing de tipo, titulo y texto
 pasados como parametro.
     *
     * Sobre los codigos de los mensajes ver:
     *
     * @see javax.?swing.?JOptionPane
     *
     * @param title titulo del mensaje
     * @param message contenido del mensaje
     * @param type tipo del menssaje
     */
    public static void showMessageDialog(String title, String message, int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
}
