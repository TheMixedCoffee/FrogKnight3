package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LevelScreen extends BaseScreen {
    private Game game;
    private Frog player;
    private BaseActor castle;
    private PillarLeft leftPillar;
    private PillarRight rightPillar;
    private ArrayList<Maggot> maggots;


    @Override
    public void initialize() {
        castle = new BaseActor(0,0,mainStage);
        castle.loadTexture("Map/Castle.png");
        castle.setSize(1280,720);
        leftPillar = new PillarLeft(0, Gdx.graphics.getHeight()-140,mainStage);
        rightPillar = new PillarRight(Gdx.graphics.getWidth()-214,Gdx.graphics.getHeight()-156,mainStage);
        BaseActor.setWorldBounds(castle);
        player = new Frog(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2, mainStage);
        new Maggot(1300,800,mainStage);
        new Maggot(2000,100,mainStage);
        new Maggot(300,800,mainStage);
        new Maggot(100,20,mainStage);
        new Maggot(500,500,mainStage);
     }

    @Override
    public void update(float dt) {
        player.preventOverlap(leftPillar);
        player.preventOverlap(rightPillar);
        for(BaseActor maggotActor : BaseActor.getList(mainStage,Maggot.class.getCanonicalName()))
            if(maggotActor.overlaps(player)){
            player.setHealth(player.getHealth()-20);
            MaggotDecay decay = new MaggotDecay(0,0,mainStage);
            decay.centerAtActor(maggotActor);
            maggotActor.remove();
            }

        if(player.getHealth() <= 0){
            FrogKnightGame.setActiveScreen(new GameOver());
        }
        mainStage.act(1/60f);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
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
