package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Frog extends BaseActor{
    private Game game;
    public Sprite frogSprite;
    public float frogX;
    public float frogY;
    public Rectangle frogHitBox;
    private Animation crawlAnim;
    private Animation idleAnim;
    private Animation attackAnim;
    private Animation currentAnim;
    private boolean canMove;
    private int health;

    public Frog(float x, float y, Stage s){
        super(x,y,s);
        health = 100;
        setAcceleration(250);
        setMaxSpeed(300);
        setDeceleration(1000);
        canMove = true;
        String[] crawlFiles = {"Player/crawl1.png","Player/crawl2.png","Player/crawl3.png",
                "Player/crawl4.png","Player/crawl5.png","Player/crawl6.png",
                "Player/crawl5.png","Player/crawl4.png","Player/crawl3.png","Player/crawl2.png"
        };
        crawlAnim = loadAnimationFromFiles(crawlFiles,0.2f,true);
        String[] idleFiles = {"Player/idle1.png","Player/idle2.png","Player/idle3.png","Player/idle4.png","Player/idle5.png",
                "Player/idle6.png","Player/idle7.png","Player/idle8.png","Player/idle9.png","Player/idle10.png",
                "Player/idle9.png","Player/idle8.png","Player/idle7.png","Player/idle6.png","Player/idle5.png",
                "Player/idle4.png","Player/idle3.png","Player/idle2.png"
        };
        idleAnim = loadAnimationFromFiles(idleFiles,0.2f,true);
        String[] attackFiles = {"Player/atk1.png","Player/atk2.png","Player/atk3.png","Player/atk4.png",
                "Player/atk5.png","Player/atk6.png","Player/atk7.png","Player/atk8.png","Player/atk9.png"
        };
        attackAnim = loadAnimationFromFiles(attackFiles,0.1f,true);
        setBoundaryPolygon(8);
    }

    public void update(){

    }

    public int getHealth()
    {
        return this.health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void act(float dt)
    {
            super.act( dt );
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                accelerateAtAngle(180);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                accelerateAtAngle(0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                accelerateAtAngle(90);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                accelerateAtAngle(270);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && !isMoving()){
                setAnimation(attackAnim);
                canMove = false;
                if(isAnimationFinished()){
                    canMove = true;
                }
            }else if(!isMoving() && canMove){
                setAnimation(idleAnim);
            }else if(isMoving() && canMove){
                setAnimation(crawlAnim);
            }
            applyPhysics(dt);
            if ( getSpeed() > 0 ){
                setRotation( getMotionAngle() );
            }
            boundToWorld();
    }
}
