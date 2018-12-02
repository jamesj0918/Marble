import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private JPanel                  gameBoardGridPanel, gameControllerPanel;
    private JPanel[]                place;
    private JLabel[]                placeNameLabel;
    private JLabel                  projectName;
    private Font                    placeNameFont;
    private GridBagConstraints[]    gbc;
    private GridBagConstraints      gameControllerGbc;
    private Color                   goldEggColor;

    public GameBoard() {
        setBounds(0,0,800,550);
        setBackground(Color.white);
        setLayout(null);

        placeNameFont = new Font("RixVideoGame3D",Font.PLAIN, 20);

        gameBoardGridPanel = new JPanel();
        gameBoardGridPanel.setBounds(0,0, 800, 550);
        gameBoardGridPanel.setBackground(Color.white);
        gameBoardGridPanel.setLayout(new GridBagLayout());
        add(gameBoardGridPanel);

        gbc = new GridBagConstraints[24];
        place = new JPanel[24];
        placeNameLabel = new JLabel[24];

        //Start
        place[0] = new JPanel();
        place[0].setPreferredSize(new Dimension(125, 125));
        place[0].setBackground(new Color(14, 46,64));
        place[0].setBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, Color.black));
        place[0].setLayout(null);

        gbc[0] = new GridBagConstraints();
        gbc[0].gridx=6;
        gbc[0].gridy=6;
        gbc[0].weightx = 1;
        gbc[0].weighty = 1;
        gbc[0].fill = GridBagConstraints.BOTH;


        gameBoardGridPanel.add(place[0], gbc[0]);

        //South 0~5
        for(int i=1;i<6;i++){
            place[i] = new JPanel();
            place[i].setPreferredSize(new Dimension(110, 125));
            place[i].setBackground(Color.white);
            place[i].setBorder(BorderFactory.createMatteBorder(3, 1, 0, 0, Color.black));

            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 6-i;
            gbc[i].gridy = 6;
            gbc[i].weightx = 1;
            gbc[i].weighty = 1;
            gbc[i].fill = GridBagConstraints.BOTH;
            gameBoardGridPanel.add(place[i], gbc[i]);
        }
        place[5].setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.black));

        //지그재그
        place[6] = new JPanel();
        place[6].setPreferredSize(new Dimension(125,125));
        place[6].setBackground(new Color(101,35,42));
        place[6].setBorder(BorderFactory.createMatteBorder(3, 0, 0, 3, Color.black));


        gbc[6] = new GridBagConstraints();
        gbc[6].gridx = 0;
        gbc[6].gridy = 6;
        gbc[6].weightx = 1;
        gbc[6].weighty = 1;
        gbc[6].fill = GridBagConstraints.BOTH;
        gameBoardGridPanel.add(place[6], gbc[6]);


        //West
        for(int i=7;i<12;i++){
            place[i] = new JPanel();
            place[i].setPreferredSize(new Dimension(125, 100));
            place[i].setBackground(Color.white);
            place[i].setBorder(BorderFactory.createLineBorder(Color.black));
            place[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 3, Color.black));

            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 0;
            gbc[i].gridy = 12-i;
            gbc[i].weightx = 1;
            gbc[i].weighty = 1;
            gbc[i].fill = GridBagConstraints.BOTH;
            gameBoardGridPanel.add(place[i], gbc[i]);
        }
        place[11].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.black));

        //사회복지기금
        place[12] = new JPanel();
        place[12].setPreferredSize(new Dimension(125,125));
        place[12].setBackground(new Color(14, 46,64));
        place[12].setBorder(BorderFactory.createLineBorder(Color.black));
        place[12].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, Color.black));


        gbc[12] = new GridBagConstraints();
        gbc[12].gridx = 0;
        gbc[12].gridy = 0;
        gbc[12].weightx = 1;
        gbc[12].weighty = 1;
        gbc[12].fill = GridBagConstraints.BOTH;
        gameBoardGridPanel.add(place[12], gbc[12]);

        //North
        for(int i=13; i<18;i++){
            place[i] = new JPanel();
            place[i].setPreferredSize(new Dimension(110,125));
            place[i].setBackground(Color.white);
            place[i].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 1, Color.black));


            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = i-12;
            gbc[i].gridy = 0;
            gbc[i].weightx = 1;
            gbc[i].weighty = 1;
            gbc[i].fill = GridBagConstraints.BOTH;
            gameBoardGridPanel.add(place[i], gbc[i]);
        }
        place[17].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //헬기장
        place[18] = new JPanel();
        place[18].setPreferredSize(new Dimension(125,125));
        place[18].setBackground(new Color(101,35,42));
        place[18].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, Color.black));


        gbc[18] = new GridBagConstraints();
        gbc[18].gridx = 6;
        gbc[18].gridy = 0;
        gbc[18].weightx = 1;
        gbc[18].weighty = 1;
        gbc[18].fill = GridBagConstraints.BOTH;
        gameBoardGridPanel.add(place[18], gbc[18]);

        //East
        for(int i=19;i<24;i++){
            place[i] = new JPanel();
            place[i].setPreferredSize(new Dimension(125, 100));
            place[i].setBackground(Color.white);
            place[i].setBorder(BorderFactory.createMatteBorder(1, 3, 0, 0, Color.black));


            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 6;
            gbc[i].gridy = i-18;
            gbc[i].weightx = 1;
            gbc[i].weighty = 1;
            gbc[i].fill = GridBagConstraints.BOTH;
            gameBoardGridPanel.add(place[i], gbc[i]);
        }
        place[19].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.black));

        //황금오리
        goldEggColor = new Color(245, 182, 73);
        place[3].setBackground(goldEggColor);
        place[9].setBackground(goldEggColor);
        place[15].setBackground(goldEggColor);
        place[21].setBackground(goldEggColor);

        for(int i=0;i<24;i++){
            place[i].setLayout(null);
            placeNameLabel[i] = new JLabel(PlaceConstants.PLACE_NAME[i]);
            placeNameLabel[i].setBounds(0,0,800/7,550/7);
            placeNameLabel[i].setFont(placeNameFont);
            placeNameLabel[i].setHorizontalAlignment(SwingConstants.CENTER);

            place[i].add(placeNameLabel[i]);
        }

        placeNameLabel[0].setForeground(Color.white);
        placeNameLabel[6].setForeground(Color.white);
        placeNameLabel[12].setForeground(Color.white);
        placeNameLabel[18].setForeground(Color.white);

        gameControllerPanel = new JPanel();
        gameControllerPanel.setBackground(Color.white);
        gameControllerPanel.setLayout(null);

        gameControllerGbc = new GridBagConstraints();
        gameControllerGbc.gridx = 1;
        gameControllerGbc.gridy = 1;
        gameControllerGbc.gridheight = 5;
        gameControllerGbc.gridwidth = 5;
        gameControllerGbc.fill = GridBagConstraints.BOTH;
        gameBoardGridPanel.add(gameControllerPanel, gameControllerGbc);

        projectName = new JLabel("<html><div style='text-align: center;'>파란구슬<BR>놀이</div></html>");
        projectName.setBounds(165,100,220,200);
        projectName.setVerticalAlignment(SwingConstants.CENTER);
        projectName.setHorizontalAlignment(SwingConstants.CENTER);
        projectName.setFont(new Font("RixVideoGame3D", Font.ITALIC, 50));
        projectName.setForeground(new Color(52, 81, 138));
        gameControllerPanel.add(projectName);
    }
}
