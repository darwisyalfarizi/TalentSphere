/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;           
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author darwisy
 */
public class TalentSphere {

    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        FlatLightLaf.setup();
         
        UIManager.put("TableHeader.background", new Color(81,108,248));
        UIManager.put("TableHeader.foreground", new Color(255,255,255));
        UIManager.put("TableHeader.font", new Font("Poppins", 1, 14));
        UIManager.put("TableHeader.cellMargins", new Insets(5,4,5,4));

        UIManager.put("Table.selectionBackground", new Color(81,108,248));
        UIManager.put("Table.alternateRowColor", new Color(245,245,245));
        UIManager.put("Table.cellMargins", new Insets(10,4,10,4));
        

                  
    /* Run Login Screen First */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new views.FormLogin().setVisible(true); // Open Login first
        }
    });
    }
}
