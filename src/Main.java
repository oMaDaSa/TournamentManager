import objects.Match;
import objects.Player;
import utils.FileHandler;
import windows.MainWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception e){
            System.out.println("erro look and feel windows");
        }

        JFrame mainWindow = new JFrame();
        mainWindow.setContentPane(new MainWindow().getPanelMain());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(800, 450);
        mainWindow.setVisible(true);
    }
}