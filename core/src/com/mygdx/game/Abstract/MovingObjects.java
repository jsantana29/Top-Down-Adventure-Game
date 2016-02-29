package com.mygdx.game.Abstract;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.*;

/**
 * Created by Jean on 1/26/2016.
 */
public abstract class MovingObjects extends ObjectCollision {
    protected Vector3 velocity;
    protected boolean playerMoveable;
    protected float momentum;
    protected static boolean isMoving;
    protected static boolean isLaunched;

    public MovingObjects(){

    }


    public abstract boolean isLaunched();
    public abstract void setLaunched(boolean launch);
    public abstract boolean isMoving();
    public abstract void setMoving(boolean move);
    public abstract void move(float x, float y, float dt);
    public abstract void addPosition(float x, float y);
    public abstract void setVelocity(Vector3 velocity);
    public abstract Vector3 getVelocity();
    public abstract void setPosition(float x, float y);
    public abstract Vector3 getPosition();
    public abstract Texture getImg();
    public abstract float getPosX();
    public abstract float getPosY();

}
