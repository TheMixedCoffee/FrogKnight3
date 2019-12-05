import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.mygdx.game.FrogKnight;

public class Launcher {
    public static void main (String[] args)
    {
        Game myGame = new FrogKnight();
        LwjglApplication launcher =
                new LwjglApplication( myGame, "Starfish Collector", 1280, 720);
    }
}
