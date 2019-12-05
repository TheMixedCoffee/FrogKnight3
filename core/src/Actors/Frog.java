package Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import screens.GameOver;

public class Frog extends Mob{
    private Game game;
    public Texture frogTexture;
    public Sprite frogSprite;
    public float frogX;
    public float frogY;
    public Rectangle frogHitBox;

    public Frog(){
        frogTexture = new Texture(Gdx.files.internal("Player/idle1real.png"));
        frogSprite = new Sprite(frogTexture);
        frogX = Gdx.graphics.getWidth()/2;
        frogY = Gdx.graphics.getHeight()/2;
        frogHitBox = new Rectangle(frogX,frogY,frogTexture.getWidth(),frogTexture.getHeight());
    }

    public void update(){
        if(frogSprite.getX() > Gdx.graphics.getWidth()){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(frogSprite.getX() < 0){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(frogSprite.getY() > Gdx.graphics.getHeight()){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(frogSprite.getY() < 0){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            frogX-=10;
            frogSprite.setRotation(90f);
            if(frogX < 0){
                frogX += 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            frogX+=10;
            frogSprite.setRotation(-90f);
            if(frogX > Gdx.graphics.getWidth()-frogSprite.getWidth()){
                frogX -= 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            frogY-=10;
            frogSprite.setRotation(180f);
            if(frogY < 0){
                frogY += 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            frogY+=10;
            frogSprite.setRotation(0f);
            if(frogY > Gdx.graphics.getHeight()-frogSprite.getHeight()){
                frogY -= 10;
            }
        }
    }
}
