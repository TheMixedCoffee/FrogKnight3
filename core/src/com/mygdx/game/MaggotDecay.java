package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class MaggotDecay extends BaseActor {
    public MaggotDecay(float x, float y, Stage s) {
        super(x, y, s);
        String[] decayFiles = {"Mob/Maggot/decay1.png","Mob/Maggot/decay2.png"};
        loadAnimationFromFiles(decayFiles,0.5f,false);
    }

    public void act(float dt)
    {
        super.act(dt);
        if(isAnimationFinished()){
            remove();
        }
    }
}
