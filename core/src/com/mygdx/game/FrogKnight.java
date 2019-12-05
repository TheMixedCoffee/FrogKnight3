package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;

public class FrogKnight extends GameBeta {
	private Game game;
	private Frog player;
	private BaseActor castle;
	private PillarLeft leftPillar;
	private PillarRight rightPillar;

	public FrogKnight(){
		game = this;
	}

	@Override
	public void initialize() {
		castle = new BaseActor(0,0,mainStage);
		castle.loadTexture("Map/Castle.png");
		castle.setSize(1280,720);
		leftPillar = new PillarLeft(0,Gdx.graphics.getHeight()-140,mainStage);
		rightPillar = new PillarRight(Gdx.graphics.getWidth()-214,Gdx.graphics.getHeight()-156,mainStage);
		BaseActor.setWorldBounds(castle);
		player = new Frog(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2, mainStage);
	}


	@Override
	public void update(float dt) {
		player.preventOverlap(leftPillar);
		player.preventOverlap(rightPillar);
		mainStage.act(1/60f);
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mainStage.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}