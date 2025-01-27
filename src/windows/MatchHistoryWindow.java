package windows;

import objects.Match;
import objects.Player;
import utils.FileHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MatchHistoryWindow {
    private JPanel panelMain;
    private JList matchRoundLst;
    private JList playerOneLst;
    private JList playerTwoLst;
    private JLabel matchRoundLbl;
    private JLabel playerOneLbl;
    private JLabel playerTwoLbl;

    public MatchHistoryWindow(){
        FileHandler file = new FileHandler("matches.dat");
        ArrayList<Match> matches = file.readMatches();

        DefaultListModel<String> listRounds = new DefaultListModel<>();
        matches.forEach(match -> listRounds.addElement(String.valueOf(match.getRound())));
        matchRoundLst.setModel(listRounds);

        DefaultListModel<String> listPlayerOne = new DefaultListModel<>();
        matches.forEach(match -> listPlayerOne.addElement(String.format("%s (%s)", String.valueOf(match.getWinner().getName()), String.valueOf(match.getWinnerPoints()))));
        playerOneLst.setModel(listPlayerOne);

        DefaultListModel<String> listPlayerTwo = new DefaultListModel<>();
        matches.forEach(match -> listPlayerTwo.addElement(String.format("%s (%s)", String.valueOf(match.getLooser().getName()), String.valueOf(match.getLooserPoints()))));
        playerTwoLst.setModel(listPlayerTwo);

    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
