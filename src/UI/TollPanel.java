package UI;
//주석 완료
import Player.PlayerConstants;
import Property.Place;
import Property.PlaceConstants;
import Util.GameFont;
import Util.Phase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//통행료 패널
public class TollPanel extends JPanel {

    private Color          mainBackgroundColor, mainColor, placeColor;
    private Phase          phase;
    private int            position, owner;
    private int            bill;

    private JButton        payButton;
    private JLabel         placeLabel, noticeLabel, billLabel;

    private ButtonListener buttonListener;

    public TollPanel (Phase phase) {
        //패널 설정
        this.phase = phase;

        mainBackgroundColor = Color.white;
        mainColor = new Color(52, 81, 138);
        buttonListener = new ButtonListener();
        setBackground(mainBackgroundColor);
        setBounds(40, 40, 800/7*5-80, 550/7*5-80);
        setBorder(BorderFactory.createLineBorder(mainColor, 6));
        setLayout(null);

        //지역 이름 라벨
        placeLabel = new JLabel();
        placeLabel.setBounds(0,0,800/7*5-80, 80);
        placeLabel.setFont(new GameFont("Rix전자오락 3D", Font.PLAIN, 50));
        //placeLabel.setFont(new Font("RixVideoGame3D", Font.PLAIN, 40));
        placeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        placeLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(placeLabel);

        //안내 라벨
        noticeLabel = new JLabel("통행료를 지불하세요!!!");
        noticeLabel.setBounds(0 , 80, 800/7*5-80, 30);
        noticeLabel.setFont(new GameFont("Rix전자오락 Bold", Font.PLAIN, 20));
        //placeLabel.setFont(new Font("RixVideoGameB", Font.PLAIN, 40));
        noticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        noticeLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(noticeLabel);

        //가격 라벨
        billLabel = new JLabel();
        billLabel.setBounds(0, 110, 800/7*5-80, 120);
        billLabel.setFont(new Font("Drid Herder Solid", Font.PLAIN, 35));
        billLabel.setHorizontalAlignment(SwingConstants.CENTER);
        billLabel.setVerticalAlignment(SwingConstants.CENTER);
        billLabel.setForeground(Color.black);
        add(billLabel);

        //통행료 지불 버튼
        payButton = new JButton("PAY");
        payButton.setBounds((800/7*5-160)/2, 250, 80, 40);
        payButton.setFont(new Font("drid herder solid", Font.PLAIN, 20));
        payButton.setBackground(Color.white);
        payButton.setForeground(mainColor);
        payButton.setBorder(BorderFactory.createLineBorder(mainColor, 2));
        payButton.setVerticalAlignment(SwingConstants.CENTER);
        payButton.setHorizontalAlignment(SwingConstants.CENTER);
        payButton.addMouseListener(buttonListener);
        add(payButton);
    }

    //통행료 정보 설정
    public void set_toll_panel_info(Place place) {
        position = Main.nextPosition;
        owner = place.get_land_owner_id();
        placeColor = PlayerConstants.PLAYER_COLOR[owner];
        bill = 0;

        placeLabel.setText(PlaceConstants.PLACE_LINE_NAME[Main.nextPosition]);
        placeLabel.setForeground(placeColor);

        bill = place.get_city_price();
        billLabel.setText("-"+(bill*10000)+" won");
    }

    //통행료 반환
    public int get_bill() { return bill; }

    private class ButtonListener implements MouseListener {
        public void mouseClicked(MouseEvent event){
            Object object = event.getSource();

            //통행료 지불 버튼을 눌렀을 경우 현재 패널은 사라지고, bill phase로 넘어간다.
            setVisible(false);
            phase.bill();
        }
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event){}
        //button hovering
        public void mouseEntered(MouseEvent event){
            JButton object = (JButton)event.getSource();

            object.setBackground(Color.white);
            object.setOpaque(true);
            object.setForeground(mainColor);
        }
        public void mouseExited(MouseEvent event){
            JButton object = (JButton)event.getSource();

            object.setBackground(mainColor);
            object.setOpaque(true);
            object.setForeground(Color.white);
        }
    }

}
