package windows;

import objects.Match;
import objects.Player;
import utils.FileHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMatchResultWindow {

    private JPanel panelMain;
    private JComboBox playerOneNameCmbBox;
    private JComboBox playerTwoNameCmbBox;
    private JSpinner playerOnePointsSpnr;
    private JSpinner playerTwoPointsSpnr;
    private JButton addMatchBtn;
    private JLabel playerOneNameLbl;
    private JLabel playerTwoNameLbl;
    private JLabel playerOnePointsLbl;
    private JLabel playerTwoPoints;
    private JLabel roundLbl;
    private JSpinner roundSpnr;

    public AddMatchResultWindow(){
        FileHandler fileHandler = new FileHandler("players.dat");
        ArrayList<Player> players = fileHandler.readPlayers();

        DefaultComboBoxModel<Player> playerOneNames = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Player> playerTwoNames = new DefaultComboBoxModel<>();
        players.forEach(playerOneNames::addElement);
        players.forEach(playerTwoNames::addElement);
        playerOneNameCmbBox.setModel(playerOneNames);
        playerTwoNameCmbBox.setModel(playerTwoNames);

        SpinnerNumberModel spinnerOneNumberModel = new SpinnerNumberModel(0, 0, 3, 1);
        SpinnerNumberModel spinnerTwoNumberModel = new SpinnerNumberModel(0, 0, 3, 1);
        playerOnePointsSpnr.setModel(spinnerOneNumberModel);
        playerTwoPointsSpnr.setModel(spinnerTwoNumberModel);

        addMatchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player pOne = (Player) playerOneNameCmbBox.getSelectedItem();
                Player pTwo = (Player) playerTwoNameCmbBox.getSelectedItem();
                int pOnePoints = (int) playerOnePointsSpnr.getValue();
                int pTwoPoints = (int) playerTwoPointsSpnr.getValue();
                int rodada = (int) roundSpnr.getValue();

                FileHandler fileHandler = new FileHandler("matches.dat");
                Match match = new Match(pOne, pOnePoints, pTwo, pTwoPoints, rodada);
                fileHandler.saveMatches(match);

                fileHandler = new FileHandler("players.dat");;
                fileHandler.updatePlayers(match);
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
