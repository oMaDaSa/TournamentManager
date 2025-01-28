package windows;

import objects.Player;
import utils.FileHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ScoreBoardWindow {

    private JPanel panelMain;
    private JList nameLst;
    private JList pointsLst;
    private JList pointBalanceLst;
    private JLabel nameLbl;
    private JLabel pointsLbl;
    private JLabel pointBalanceLbl;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public ScoreBoardWindow(){
        FileHandler file = new FileHandler("players.dat");
        ArrayList<Player> players = file.readPlayers();
        players.sort(Comparator.comparingInt(Player::getPoints).thenComparingInt(Player::getPointBalance).reversed());

        players.forEach(player -> System.out.println(player.getName() + player.getPoints() + player.getPointBalance()));

        DefaultListModel<String> listNames = new DefaultListModel<>();
        players.forEach(player -> listNames.addElement(player.getName()));
        nameLst.setModel(listNames);

        DefaultListModel<String> listPoints = new DefaultListModel<>();
        players.forEach(player -> listPoints.addElement(String.valueOf(player.getPoints())));
        pointsLst.setModel(listPoints);

        DefaultListModel<String> listPointBalance = new DefaultListModel<>();
        players.forEach(player -> listPointBalance.addElement(String.valueOf(player.getPointBalance())));
        pointBalanceLst.setModel(listPointBalance);
    }
}
