package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Abstract.MovingObjects;
import com.mygdx.game.Metaphor;
import com.mygdx.game.Player;
import com.mygdx.game.Screens.PlayScreen;

/**
 * Created by Jean on 2/23/2016.
 */
public class Bullets extends MovingObjects{
    Texture img;

    static float totalVelocity = 0;

    private float currentX;
    private float currentY;

    public Bullets(){
        img = new Texture("shots.png");
        velocity = new Vector3(0,0,0);
        position = new Vector3(0,0,0);
    }

    public Bullets(float x, float y, float width, float height){
        position = new Vector3(x+width/2,y+height/2,0);
        img = new Texture("shots.png");
        velocity = new Vector3(0,0,0);
    }


    @Override
    public void addPosition(float x, float y) {
        position.add(x,y,0);
    }

    @Override
    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }

    @Override
    public Vector3 getVelocity() {
        return velocity;
    }

    @Override
    public void setPosition(float x, float y) {
        this.position = position.set(x,y,0);
    }

    @Override
    public Vector3 getPosition() {
        return position;
    }

    @Override
    public Texture getImg() {
        return this.img;
    }

    @Override
    public float getPosY() {
        return this.currentY;
    }

    @Override
    public float getPosX() {
        return this.currentX;
    }

    @Override
    public Rectangle getCollisions() {
        return null;
    }

    @Override
    public boolean isMoving() {
        return isMoving;
    }

    @Override
    public void setMoving(boolean move) {
        isMoving = move;
    }

    @Override
    public void setLaunched(boolean launch) {
        isLaunched = launch;
    }

    @Override
    public boolean isLaunched() {
        return isLaunched;
    }

    @Override
    public void move(float x, float y, float dt) {
        velocity.set(0, 0, 0);
        velocity.add(x, y, 0);
        velocity.scl(dt);
        this.position.add(velocity.x, velocity.y, 0);
        totalVelocity += velocity.x;
        velocity.scl(1 / dt);

        if(totalVelocity >= 1000){
            totalVelocity = 0;
        }

    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
