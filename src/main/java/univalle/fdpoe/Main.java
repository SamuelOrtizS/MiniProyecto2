package univalle.fdpoe;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase principal que ejecuta el programa
 * @author SamuelOrtizS
 * @version 16/04/2023/A
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Ventana();
                frame.setSize(500,550);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null,"¿Desea salir?","Mensaje de confirmación",JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0)
                            System.exit(0);
                    }
                });
            }
        });
    }
}