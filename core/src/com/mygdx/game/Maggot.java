package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Maggot extends BaseActor{
    public Maggot(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Mob/Maggot/maggot.png");
        setBoundaryPolygon(8);
        float random = MathUtils.random(5);
        addAction(Actions.forever(Actions.rotateBy(5+random,1)));
        setSpeed(100+random*60);
        setMaxSpeed(100+random*60);
        setDeceleration(0);
        setMotionAngle(MathUtils.random(30));
    }

    public void act(float dt)
    {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }
}
