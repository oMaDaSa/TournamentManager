package windows;

import objects.Match;
import objects.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow {
    private JPanel panelMain;
    private JButton addPlayerBtn;
    private JButton addMatchResultBtn;
    private JButton scoreBoardBtn;
    private JButton matchHistoryBtn;
    private JButton button1;

    public MainWindow() {
        addPlayerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addPlayerWindow = new JFrame();
                addPlayerWindow.setContentPane(new AddPlayerWindow().getPanelMain());
                addPlayerWindow.setVisible(true);
                addPlayerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addPlayerWindow.setSize(800,450);
            }
        });

        scoreBoardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame scoreBoardWindow = new JFrame();
                scoreBoardWindow.setContentPane(new ScoreBoardWindow().getPanelMain());
                scoreBoardWindow.setVisible(true);
                scoreBoardWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                scoreBoardWindow.setSize(800, 450);
            }
        });

        addMatchResultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addMatchResultWindow = new JFrame();
                addMatchResultWindow.setContentPane(new AddMatchResultWindow().getPanelMain());
                addMatchResultWindow.setVisible(true);
                addMatchResultWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addMatchResultWindow.setSize(800, 450);
            }
        });
        matchHistoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame matchHistoryWindow = new JFrame();
                matchHistoryWindow.setContentPane(new MatchHistoryWindow().getPanelMain());
                matchHistoryWindow.setVisible(true);
                matchHistoryWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                matchHistoryWindow.setSize(800, 450);
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
