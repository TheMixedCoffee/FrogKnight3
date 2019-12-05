package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class GameOver implements Screen {
    private Game game;
    private Stage stage;
    private SpriteBatch batch;
    private Sprite screen;
    private long startTime;
    private float alpha;

    public GameOver(Game aGame){
        game = aGame;
        batch = new SpriteBatch();
    }
    @Override
    public void show() {
        Texture screenTexture= new Texture("Menu/GameOver.png");
        screen = new Sprite(screenTexture);
        screen.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        startTime = TimeUtils.millis();
        alpha = 1f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        screen.draw(batch,alpha);
        alpha -= .005f;
        batch.end();
        if(TimeUtils.millis()>(startTime + 3000)){
            game.setScreen(new MainMenu2(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        screen.getTexture().dispose();
    }
}
