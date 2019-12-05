package screens;

import Actors.Boss;
import Actors.Frog;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Levels implements Screen {

    private SpriteBatch batch;
    private Texture mapText;
    private Sprite mapSprite;
    private Game game;
    private Frog frog;
    private Boss baby;

    private boolean win;
    private long startTime;
    @Override
    public void show() {

    batch = new SpriteBatch();
    mapText = new Texture(Gdx.files.internal("Map/Castle.png"));
    mapSprite = new Sprite(mapText);
    frog = new Frog();
    baby = new Boss();
    win = false;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        frog.update();
        baby.update();

//        frogHitBox.setPosition(frogX,frogY);
//        if(frogHitBox.overlaps(babyHitBox)){
//            win = true;
//        }
        frog.frogSprite.setPosition(frog.frogX,frog.frogY);
        batch.begin();
        batch.draw(mapText,0,0);
        batch.draw(baby.babyTexture,baby.babyX, baby.babyY);
 //       batch.draw(frogTexture,frogX,frogY);
        frog.frogSprite.draw(batch);
        batch.end();

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
    }


}
