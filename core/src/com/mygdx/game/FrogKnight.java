package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import screens.MainMenu;
import screens.Splash;

public class FrogKnight extends Game {
	private Game game;
	private SpriteBatch batch;
	private Texture frogTexture;
	private float frogX;
	private float frogY;
	private Rectangle frogHitBox;
	private Texture babyTexture;
	private float babyX;
	private float babyY;
	private Rectangle babyHitBox;
	private boolean win;
	private long startTime;

	public FrogKnight(){
		game = this;
	}

	@Override
	public void create() {
		startTime = TimeUtils.millis();
		game.setScreen(new Splash(game));
		batch = new SpriteBatch();
		frogTexture = new Texture(Gdx.files.internal("Player/idle1.png"));
		frogX = 0;
		frogY = 0;
		frogHitBox = new Rectangle(frogX,frogY,frogTexture.getWidth(),frogTexture.getHeight());
		babyTexture = new Texture(Gdx.files.internal("babyHeadBlue.png"));
		babyX = 500;
		babyY = 500;
		babyHitBox = new Rectangle(babyX,babyY,babyTexture.getWidth(),babyTexture.getHeight());
		win = false;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

}