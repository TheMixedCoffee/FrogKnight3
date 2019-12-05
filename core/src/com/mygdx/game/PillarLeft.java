package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PillarLeft extends BaseActor {

    public PillarLeft(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Map/CastlePillarLeft.png");
        setBoundaryPolygon(8);
    }
}
