package galalite;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest extends MainController {

    @Test
    public void testCollision(){
        this.gamePane = new Pane();
        gamePane.setMinWidth(100);
        gamePane.setMinHeight(200);
        Ship colliding1 = new PlayerShip(new Rectangle(0,0,10,10),100,200);
        Ship colliding2 = new PlayerShip(new Rectangle(0,5,10,10),100,200);
        Ship outOfBounds = new PlayerShip(new Rectangle(0,210,10,10),100,200);
        Ship notColliding = new PlayerShip(new Rectangle(50,50,10,10),100,200);
        assertEquals(this.detectCollisionHelper(colliding1, colliding2), true);
        assertEquals(this.detectCollisionHelper(colliding1, notColliding), false);
        assertEquals(this.detectOutOfBoundBullets(outOfBounds), true);
    }
}
