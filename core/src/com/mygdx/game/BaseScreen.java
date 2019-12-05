package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class BaseScreen implements Screen, InputProcessor {
    protected Stage mainStage;
    protected Stage uiStage;

    public BaseScreen(){
        mainStage = new Stage();
        uiStage = new Stage();

        initialize();
    }

    public abstract void initialize();
    public abstract void update(float dt);

    @Override
    public void show() {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.addProcessor(this);
        im.addProcessor(uiStage);
        im.addProcessor(mainStage);
    }

    @Override
    public void render(float dt) {
    uiStage.act(dt);
    mainStage.act(dt);
    update(dt);
    Gdx.gl.glClearColor(0,0,0,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    mainStage.draw();
    uiStage.draw();
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
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(uiStage);
        im.removeProcessor(mainStage);
    }

    @Override
    public void dispose() {

    }

    public boolean keyDown(int keycode)
    {
        return false;
    }

    public boolean keyUp(int keycode)
    {
        return false;
    }

    public boolean keyTyped(char c)
    {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    public boolean scrolled(int amount)
    {
        return false;
    }

}
