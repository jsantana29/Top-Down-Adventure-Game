package com.mygdx.game.Abstract;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Jean on 1/21/2016.
 */
public abstract class ObjectCollision {

    protected Texture img;
    protected float mass;
    protected float angles;
    protected boolean interactable;
    protected Vector3 position;
    protected Rectangle collision;
    protected int physicalState;
    // solid = 0
    // liquid = 0
    // gss = 0
    // plasma = 0

    public ObjectCollision() {

    }

    public abstract void setPos(float inputX, float inputY);

    public abstract Texture getImg();

    public abstract float getPosY();

    public abstract float getPosX();

    public abstract Rectangle getCollisions();
}
