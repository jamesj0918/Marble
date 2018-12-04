package Util;

import UI.GameBoard;
import UI.Main;
import UI.ScoreBoard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class PhaseListener implements PropertyChangeListener {

    private Dice dice1, dice2;
    private ScoreBoard scoreBoard;
    private GameBoard gameBoard;
    private Main main;
    private Phase phase;

    public PhaseListener(Dice dice1, Dice dice2, ScoreBoard scoreBoard, GameBoard gameBoard, Main main, Phase phase){
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.scoreBoard = scoreBoard;
        this.gameBoard = gameBoard;
        this.main = main;
        this.phase = phase;

    }

    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("START")){
            System.out.println("start");
        }
        else if (event.getPropertyName().equals("BEFORE_START")){
            System.out.println("before start");
        }
        else if (event.getPropertyName().equals("ROLL")){
            System.out.println("roll");
            dice1.roll_dice();
            dice2.roll_dice();
            gameBoard.show_dice(dice1.get_dice(), dice2.get_dice());

        }
        else if (event.getPropertyName().equals("MOVE")){
            System.out.println("move");
            main.move_player(dice1.get_dice()+dice2.get_dice());
            main.next();
        }
        else if (event.getPropertyName().equals("ACQUIRE")){
            System.out.println("acquire");
        }
        else if (event.getPropertyName().equals("BILL")){
            System.out.println("bill");
        }
        else if (event.getPropertyName().equals("END")){
            System.out.println("end");
        }
        else if (event.getPropertyName().equals("RESTART")){
            System.out.println("restart");
        }
    }
}