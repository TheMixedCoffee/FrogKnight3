package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameOver extends BaseScreen {
    @Override
    public void initialize() {
        BaseActor splash = new BaseActor(0,0,mainStage);
        splash.loadTexture("Menu/GameOver.png");
        splash.setSize(1280,720);
    }

    @Override
    public void update(float dt) {
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            FrogKnightGame.setActiveScreen(new LevelScreen());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
}
