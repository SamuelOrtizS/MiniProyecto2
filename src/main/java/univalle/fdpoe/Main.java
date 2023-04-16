/*
  ____                             _  ___       _   _      ____
 / ___|  __ _ _ __ ___  _   _  ___| |/ _ \ _ __| |_(_)____/ ___|
 \___ \ / _` | '_ ` _ \| | | |/ _ \ | | | | '__| __| |_  /\___ \
  ___) | (_| | | | | | | |_| |  __/ | |_| | |  | |_| |/ /  ___) |
 |____/ \__,_|_| |_| |_|\__,_|\___|_|\___/|_|   \__|_/___||____/
 Creado por: Samuel Ortiz Sarasti (202127049)
 Para el curso de Fundamentos de Programación Orientada a Eventos
 Mini Proyecto 2
 Creación de un Cuestionario, con su respectiva GUI y funcionalidad
 Domingo 16 de Abril de 2023
 Disponible en: https://github.com/SamuelOrtizS/MiniProyecto2
 */

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