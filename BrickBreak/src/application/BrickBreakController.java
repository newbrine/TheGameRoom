package application;

import java.util.ArrayList;

import game.Ball;
import game.Brick;
import game.Game;
import game.Paddle;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BrickBreakController {

    @FXML
    private Rectangle d52;

    @FXML
    private Rectangle d51;

    @FXML
    private Rectangle d54;

    @FXML
    private Rectangle d53;

    @FXML
    private Rectangle d56;

    @FXML
    private Rectangle d55;

    @FXML
    private Rectangle d57;

    @FXML
    private Rectangle l52;

    @FXML
    private Rectangle l51;

    @FXML
    private Rectangle l54;

    @FXML
    private Rectangle l53;

    @FXML
    private Rectangle l56;

    @FXML
    private Rectangle l55;

    @FXML
    private Rectangle l57;

    @FXML
    private Rectangle r12;

    @FXML
    private Rectangle r11;

    @FXML
    private Rectangle r14;

    @FXML
    private Rectangle r13;

    @FXML
    private Rectangle r16;

    @FXML
    private Rectangle r15;

    @FXML
    private Rectangle r17;

    @FXML
    private Rectangle d61;

    @FXML
    private Rectangle d63;

    @FXML
    private Rectangle d62;

    @FXML
    private Rectangle d65;

    @FXML
    private Rectangle d64;

    @FXML
    private Rectangle d67;

    @FXML
    private Rectangle d66;

    @FXML
    private Rectangle l61;

    @FXML
    private Rectangle l63;

    @FXML
    private Rectangle l62;

    @FXML
    private Rectangle l65;

    @FXML
    private Rectangle l64;

    @FXML
    private Rectangle l67;

    @FXML
    private Rectangle l66;

    @FXML
    private Rectangle r21;

    @FXML
    private Rectangle r23;

    @FXML
    private Rectangle r22;

    @FXML
    private Rectangle r25;

    @FXML
    private Rectangle r24;

    @FXML
    private Rectangle r27;

    @FXML
    private Rectangle r26;

    @FXML
    private Rectangle r32;

    @FXML
    private Rectangle r31;

    @FXML
    private Rectangle r34;

    @FXML
    private Rectangle r33;

    @FXML
    private Rectangle u11;

    @FXML
    private Rectangle r36;

    @FXML
    private Rectangle r35;

    @FXML
    private Rectangle u13;

    @FXML
    private Rectangle u12;

    @FXML
    private Rectangle r37;

    @FXML
    private Rectangle u15;

    @FXML
    private Rectangle u14;

    @FXML
    private Rectangle u17;

    @FXML
    private Rectangle u16;

    @FXML
    private Rectangle r41;

    @FXML
    private Rectangle r43;

    @FXML
    private Rectangle r42;

    @FXML
    private Rectangle r45;

    @FXML
    private Rectangle r44;

    @FXML
    private Rectangle u22;

    @FXML
    private Rectangle r47;

    @FXML
    private Rectangle u21;

    @FXML
    private Rectangle r46;

    @FXML
    private Rectangle u24;

    @FXML
    private Rectangle u23;

    @FXML
    private Rectangle u26;

    @FXML
    private Rectangle u25;

    @FXML
    private Rectangle u27;

    @FXML
    private Rectangle d12;

    @FXML
    private Rectangle d11;

    @FXML
    private Rectangle d14;

    @FXML
    private Rectangle d13;

    @FXML
    private Rectangle d16;

    @FXML
    private Rectangle d15;

    @FXML
    private Rectangle d17;

    @FXML
    private Rectangle l12;

    @FXML
    private Rectangle l11;

    @FXML
    private Rectangle r52;

    @FXML
    private Rectangle l14;

    @FXML
    private Rectangle r51;

    @FXML
    private Rectangle l13;

    @FXML
    private Rectangle r54;

    @FXML
    private Rectangle l16;

    @FXML
    private Rectangle r53;

    @FXML
    private Rectangle l15;

    @FXML
    private Rectangle u31;

    @FXML
    private Rectangle r56;

    @FXML
    private Rectangle l17;

    @FXML
    private Rectangle r55;

    @FXML
    private Rectangle u33;

    @FXML
    private Rectangle u32;

    @FXML
    private Rectangle r57;

    @FXML
    private Rectangle u35;

    @FXML
    private Rectangle u34;

    @FXML
    private Rectangle u37;

    @FXML
    private Rectangle u36;

    @FXML
    private Rectangle d21;

    @FXML
    private Rectangle d23;

    @FXML
    private Rectangle d22;

    @FXML
    private Rectangle d25;

    @FXML
    private Rectangle d24;

    @FXML
    private Rectangle d27;

    @FXML
    private Rectangle d26;

    @FXML
    private Rectangle l21;

    @FXML
    private Rectangle r61;

    @FXML
    private Rectangle l23;

    @FXML
    private Rectangle l22;

    @FXML
    private Rectangle r63;

    @FXML
    private Rectangle l25;

    @FXML
    private Rectangle r62;

    @FXML
    private Rectangle l24;

    @FXML
    private Rectangle l27;

    @FXML
    private Rectangle r65;

    @FXML
    private Rectangle r64;

    @FXML
    private Rectangle l26;

    @FXML
    private Rectangle u42;

    @FXML
    private Rectangle r67;

    @FXML
    private Rectangle u41;

    @FXML
    private Rectangle r66;

    @FXML
    private Rectangle u44;

    @FXML
    private Rectangle u43;

    @FXML
    private Rectangle u46;

    @FXML
    private Rectangle u45;

    @FXML
    private Rectangle u47;

    @FXML
    private Rectangle d32;

    @FXML
    private Rectangle d31;

    @FXML
    private Rectangle d34;

    @FXML
    private Rectangle d33;

    @FXML
    private Rectangle d36;

    @FXML
    private Rectangle d35;

    @FXML
    private Rectangle d37;

    @FXML
    private Rectangle l32;

    @FXML
    private Rectangle l31;

    @FXML
    private Rectangle l34;

    @FXML
    private Rectangle l33;

    @FXML
    private Rectangle paddle;

    @FXML
    private Rectangle l36;

    @FXML
    private Rectangle l35;

    @FXML
    private Rectangle u51;

    @FXML
    private Circle ball;

    @FXML
    private Rectangle l37;

    @FXML
    private Rectangle u53;

    @FXML
    private Rectangle u52;

    @FXML
    private Rectangle u55;

    @FXML
    private Rectangle u54;

    @FXML
    private Rectangle u57;

    @FXML
    private Rectangle u56;

    @FXML
    private Rectangle d41;

    @FXML
    private Rectangle d43;

    @FXML
    private Rectangle d42;

    @FXML
    private Rectangle d45;

    @FXML
    private Rectangle d44;

    @FXML
    private Rectangle d47;

    @FXML
    private Rectangle d46;

    @FXML
    private Rectangle l41;

    @FXML
    private Rectangle l43;

    @FXML
    private Rectangle l42;

    @FXML
    private Rectangle l45;

    @FXML
    private Rectangle l44;

    @FXML
    private Rectangle l47;

    @FXML
    private Rectangle l46;

    @FXML
    private Rectangle u62;

    @FXML
    private Rectangle u61;

    @FXML
    private Rectangle u64;

    @FXML
    private Rectangle u63;

    @FXML
    private Rectangle u66;

    @FXML
    private Rectangle u65;

    @FXML
    private Rectangle u67;

    @FXML
    private Pane pane;

    @FXML
    private Label score;

    @FXML
    private Label time;

    private Scene scene;

    private Ball gameBall;
    private Paddle gamePaddle;
    private Game game;

    private long fps = 60L;
	private long interval = 100000000L / fps;

	private boolean left  = false;
	private boolean right = false;

	private Movement clock;


	@FXML
    public void initialize() {
		Platform.runLater(() -> {
			ArrayList<Brick> bricks = new ArrayList<Brick>();
	    	bricks.add(new Brick(l11, r11, u11, d11));
	    	bricks.add(new Brick(l21, r21, u21, d21));
	    	bricks.add(new Brick(l31, r31, u31, d31));
	    	bricks.add(new Brick(l41, r41, u41, d41));
	    	bricks.add(new Brick(l51, r51, u51, d51));
	    	bricks.add(new Brick(l61, r61, u61, d61));
	    	bricks.add(new Brick(l12, r12, u12, d12));
	    	bricks.add(new Brick(l22, r22, u22, d22));
	    	bricks.add(new Brick(l32, r32, u32, d32));
	    	bricks.add(new Brick(l42, r42, u42, d42));
	    	bricks.add(new Brick(l52, r52, u52, d52));
	    	bricks.add(new Brick(l62, r62, u62, d62));
	    	bricks.add(new Brick(l13, r13, u13, d13));
	    	bricks.add(new Brick(l23, r23, u23, d23));
	    	bricks.add(new Brick(l33, r33, u33, d33));
	    	bricks.add(new Brick(l43, r43, u43, d43));
	    	bricks.add(new Brick(l53, r53, u53, d53));
	    	bricks.add(new Brick(l63, r63, u63, d63));
	    	bricks.add(new Brick(l14, r14, u14, d14));
	    	bricks.add(new Brick(l24, r24, u24, d24));
	    	bricks.add(new Brick(l34, r34, u34, d34));
	    	bricks.add(new Brick(l44, r44, u44, d44));
	    	bricks.add(new Brick(l54, r54, u54, d54));
	    	bricks.add(new Brick(l64, r64, u64, d64));
	    	bricks.add(new Brick(l15, r15, u15, d15));
	    	bricks.add(new Brick(l25, r25, u25, d25));
	    	bricks.add(new Brick(l35, r35, u35, d35));
	    	bricks.add(new Brick(l45, r45, u45, d45));
	    	bricks.add(new Brick(l55, r55, u55, d55));
	    	bricks.add(new Brick(l65, r65, u65, d65));
	    	bricks.add(new Brick(l16, r16, u16, d16));
	    	bricks.add(new Brick(l26, r26, u26, d26));
	    	bricks.add(new Brick(l36, r36, u36, d36));
	    	bricks.add(new Brick(l46, r46, u46, d46));
	    	bricks.add(new Brick(l56, r56, u56, d56));
	    	bricks.add(new Brick(l66, r66, u66, d66));
	    	bricks.add(new Brick(l17, r17, u17, d17));
	    	bricks.add(new Brick(l27, r27, u27, d27));
	    	bricks.add(new Brick(l37, r37, u37, d37));
	    	bricks.add(new Brick(l47, r47, u47, d47));
	    	bricks.add(new Brick(l57, r57, u57, d57));
	    	bricks.add(new Brick(l67, r67, u67, d67));

	    	gameBall   = new Ball(ball);
	    	gamePaddle = new Paddle(paddle);
	    	game       = new Game(bricks, gameBall, gamePaddle);

	    	listenForKeys();
	    	pane.requestFocus();

	    	clock = new Movement();
	    	clock.start();
		});
    }

    private class Movement extends AnimationTimer {
    	private long lastGameInterval = 0;
    	private boolean play = true;

    	@Override
		public void handle(long now) {
    		if (play) {
    			if (now - lastGameInterval >= interval) {
        			lastGameInterval = now;
        				game.handleCollisions();
            			gameBall.draw();

           			if (left) {
           				gamePaddle.moveLeft();
           				left  = false;
           				right = false;
           			} else if (right) {
            			gamePaddle.moveRight();
            			right = false;
            		}

           			play = game.countDown();
           			updateGUI();

           			if (game.checkLoss() || game.checkWin()) {
           				play = false;
           			}
        		}
    		} else {
    			updateGUI();
    			gameOver("Your score is :" + game.getScore());
    		}
    	}
    }

    private void listenForKeys() {
    	this.scene = Main.getScene();
    	scene.setOnKeyPressed(new javafx.event.EventHandler<javafx.scene.input.KeyEvent>() {
    		@Override
    		public void handle(javafx.scene.input.KeyEvent event) {

				switch (event.getCode()) {
				case A:
					left = true;
					break;
				case D:
					right = true;
					break;
				}
			}
    	});
    }

    private void updateGUI() {
    	score.setText(game.getScore() + "");
    	time.setText(game.getTime() + "");
    }

    private void gameOver(String info) {
    	Platform.runLater(() -> {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("BrickBreaker");
    		alert.setHeaderText("Game Over");
    		alert.setContentText(info);
    		alert.show();
    	});
		clock.stop();
	}
}
