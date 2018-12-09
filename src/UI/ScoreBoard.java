package UI;

import Player.Player;
import Player.PlayerConstants;
import Player.PlayerData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class ScoreBoard extends JPanel {
    private JPanel scoreBoardMainPanel;
    private Player[] player;
    private JPanel[]  playerInformationPanel;
    protected JLabel[] playerNameLabel, playerCashLabel, playerIconLabel;
    protected JLabel[][] islandCountIconLabel;
    protected  JLabel tollFreeIconLabel;
    private ImageIcon[] playerIcon;
    private ImageIcon[][]  islandCountIcon;
    private ImageIcon tollFreeIcon;
    private JLabel dummy;

    public ScoreBoard(Player player[]) {
        setBounds(0,550,800,200);
        setLayout(null);
        setBackground(Color.white);
        setLayout(new GridLayout(1,4));

        playerInformationPanel = new JPanel[4];
        playerNameLabel = new JLabel[4];
        playerCashLabel = new JLabel[4];
        playerIconLabel = new JLabel[4];
        playerIcon = new ImageIcon[4];

        islandCountIconLabel = new JLabel[4][3];
        islandCountIcon = new ImageIcon[4][3];

        this.player = new Player[4];


        for(int i=0;i<4;i++){
            playerInformationPanel[i] = new JPanel();
            playerInformationPanel[i].setBackground(PlayerConstants.PLAYER_COLOR[i]);
            playerInformationPanel[i].setBounds(0,0,200,200);
            playerInformationPanel[i].setLayout(null);
            add(playerInformationPanel[i]);

            this.player[i] = player[i];

            playerNameLabel[i] = new JLabel("PLAYER " + (i + 1));
            playerNameLabel[i].setFont(new Font("boxy bold", Font.BOLD, 25));
            playerNameLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerNameLabel[i].setBounds(0,150,200,50);
            playerInformationPanel[i].add(playerNameLabel[i]);

            playerIcon[i] = new ImageIcon(PlayerConstants.PLAYER_ICON[i]);
            playerIconLabel[i] = new JLabel(playerIcon[i]);
            playerIconLabel[i].setBounds(0,0,200,120);
            playerInformationPanel[i].add(playerIconLabel[i]);

            playerCashLabel[i] = new JLabel(""+player[i].get_cash()+" won");
            playerCashLabel[i].setFont(new Font("drid herder solid",Font.PLAIN, 18));
            playerCashLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerCashLabel[i].setBounds(0,120, 200, 30);
            playerInformationPanel[i].add(playerCashLabel[i]);


            for (int j=0; j<3; j++) {
                islandCountIcon[i][j] = new ImageIcon("./image/island_count"+(j+1)+".png");
                islandCountIconLabel[i][j] = new JLabel(islandCountIcon[i][j]);
                islandCountIconLabel[i][j].setBounds(8, 25*j+5, 27, 25);
                islandCountIconLabel[i][j].setVisible(false);
                playerInformationPanel[i].add(islandCountIconLabel[i][j]);
            }

            tollFreeIcon = new ImageIcon("./image/free.png");
            tollFreeIconLabel = new JLabel(tollFreeIcon);
            tollFreeIconLabel.setBounds(162, 10, 27,25);
            tollFreeIconLabel.setVisible(false);
            playerInformationPanel[i].add(tollFreeIconLabel);
        }

    }//ScoreBoard()

    public void setBorder(int player_turn){
        if(player_turn != 0){
            playerInformationPanel[(player_turn-1)%4].setBorder(null);
        }
        playerInformationPanel[player_turn%4].setBorder(BorderFactory.createLineBorder(Color.magenta, 10));
    }

    public void set_player_cash_label(int playerId){
        playerCashLabel[playerId].setText(player[playerId].get_cash()+" won");
    }

    public void set_island_icon_count(int playerId){
        System.out.println(playerId+"가 지그재그로");
        islandCountIconLabel[playerId][2].setVisible(true);
    }
    public void sub_island_icon_count(int playerId, int count){
        System.out.println(playerId+" "+count);
        islandCountIconLabel[playerId][count].setVisible(false);
        islandCountIconLabel[playerId][count-1].setVisible(true);
    }
    public void escape_island_icon(int playerId){
        islandCountIconLabel[playerId][0].setVisible(false);
        islandCountIconLabel[playerId][1].setVisible(false);
        islandCountIconLabel[playerId][2].setVisible(false);
    }

}//ScoreBoard class
