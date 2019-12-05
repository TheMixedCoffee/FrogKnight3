package com.mygdx.game;

public class FrogKnightGame extends BaseGame{
    public void create()
    {
        super.create();
        setActiveScreen(new MenuScreen());
    }
}
