package windows;

import objects.Match;
import objects.Player;
import utils.FileHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class AddPlayerWindow {

    private JPanel panelMain;
    private JButton addPlayerBtn;
    private JLabel insertPlayerNameLbl;
    private JTextField playerNameTextField;

    public AddPlayerWindow() {
        addPlayerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(playerNameTextField.getText());
                FileHandler fileHandler = new FileHandler("players.dat");
                fileHandler.savePlayers(player);
                playerNameTextField.setText("");
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
