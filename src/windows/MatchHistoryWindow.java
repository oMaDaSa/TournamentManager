package windows;

import objects.Match;
import objects.Player;

import javax.swing.*;
import java.util.ArrayList;

public class MatchHistoryWindow {
    private JPanel panelMain;
    private JList matchRoundLst;
    private JList playerOneLst;
    private JList playerTwoLst;
    private JLabel matchRoundLbl;
    private JLabel playerOneLbl;
    private JLabel playerTwoLbl;

    private void createUIComponents(ArrayList<Match> matches) {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
