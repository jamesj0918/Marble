import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {

    private StartPanel startPanel;
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;
    private StartButtonListener startButtonListener;

    public StartController(StartPanel startPanel, GameBoard gameBoard, ScoreBoard scoreBoard){
        this.startPanel = startPanel;
        this.gameBoard = gameBoard;
        this.scoreBoard = scoreBoard;

        startButtonListener = new StartButtonListener();

        this.startPanel.startButton.addActionListener(startButtonListener);
    }

    public class StartButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object object = event.getSource();

            if(object == startPanel.startButton){
                startPanel.setVisible(false);
                gameBoard.setVisible(true);
                scoreBoard.setVisible(true);
            }
        }
    }

}
