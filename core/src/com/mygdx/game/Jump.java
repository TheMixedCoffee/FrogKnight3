package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Jump extends BaseActor{
    public Jump(float x, float y, Stage s) {
        super(x, y, s);
        String[] jumpFiles = {"Player/jump1.png","Player/jump2.png","Player/jump3.png","Player/jump4.png",
                "Player/jump3.png","Player/jump2.png"
        };
        loadAnimationFromFiles(jumpFiles,0.1f, true);
    }
}
