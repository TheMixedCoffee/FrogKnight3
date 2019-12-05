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
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Splash implements Screen {
    private Game game;
    private Stage stage;
    private SpriteBatch batch;
    private Sprite splash;
    private long startTime;
    private float alpha;

    public Splash(Game aGame){
        game = aGame;
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        Texture splashTexture= new Texture("Menu/Splash.png");
        splash = new Sprite(splashTexture);
        splash.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        startTime = TimeUtils.millis();
        alpha = 1f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        splash.draw(batch,alpha);
        alpha -= .005f;
        batch.end();
        if(TimeUtils.millis()>(startTime + 3000)){
            game.setScreen(new MainMenu(game));
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
    dispose();
    }

    @Override
    public void dispose() {
    batch.dispose();
    splash.getTexture().dispose();
    }
}
