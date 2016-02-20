package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Abstract.ObjectCollision;

/**
 * Created by Jean on 1/29/2016.
 */
public class Wall extends ObjectCollision {
    private boolean interactable = false;
    private int physicalState = 0;
    private float x = 200;
    private float y = 200;

    public Wall(){
        position = new Vector3(x,y,0);
        img = new Texture("wall.png");
        collision = new Rectangle(x,y,img.getWidth(),img.getHeight());
    }

    public void setPos(float x, float y) {
        this.x =  x;
        this.y = y;
    }

    public Texture getImg() {
        return img;
    }

    public float getPosY() {
        return y;
    }

    public float getPosX() {
        return x;
    }

    public Rectangle getCollisions() {
        return collision;
    }
}
