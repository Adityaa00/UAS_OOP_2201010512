/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gymm;

import java.sql.SQLException;

/**
 *
 * @author adit
 */
public class GYMM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
         GYMMFORM inputform = new GYMMFORM();
        inputform.setVisible(true);
        inputform.setResizable(false);
        inputform.setAlwaysOnTop(true);
    }
    
}
