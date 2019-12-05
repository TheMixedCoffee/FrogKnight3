package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PillarRight extends BaseActor {
    public PillarRight(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Map/CastlePillarRight.png");
        setBoundaryPolygon(8);
    }
}
