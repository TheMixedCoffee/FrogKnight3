package Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import screens.GameOver;

public class Boss extends Mob {
    private Game game;
    public Texture babyTexture;
    public Sprite babySprite;
    public float babyX;
    public float babyY;
    public Rectangle babyHitBox;

    public Boss(){
        babyTexture = new Texture(Gdx.files.internal("babyHeadBlue.png"));
        babySprite = new Sprite(babyTexture);
        babyX = 500;
        babyY = 500;
        babyHitBox = new Rectangle(babyX,babyY,babyTexture.getWidth(),babyTexture.getHeight());
    }

    public void update(){
        if(babySprite.getX() > Gdx.graphics.getWidth()){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(babySprite.getX() < 0){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(babySprite.getY() > Gdx.graphics.getHeight()){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }else if(babySprite.getY() < 0){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameOver(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            babyX-=10;
            babySprite.setRotation(90f);
            if(babyX < 0){
                babyX += 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            babyX+=10;
            babySprite.setRotation(-90f);
            if(babyX > Gdx.graphics.getWidth()-babySprite.getWidth()){
                babyX -= 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            babyY-=10;
            babySprite.setRotation(180f);
            if(babyY < 0){
                babyY += 10;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            babyY+=10;
            babySprite.setRotation(0f);
            if(babyY > Gdx.graphics.getHeight()-babySprite.getHeight()){
                babyY -= 10;
            }
        }
    }
}
