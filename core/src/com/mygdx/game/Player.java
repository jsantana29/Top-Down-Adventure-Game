package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Abstract.ObjectCollision;
import com.mygdx.game.Objects.Wall;

/**
 * Created by Jean on 1/19/2016.
 */
public class Player {

    private static float posX;
    private static float posY;

    private ObjectCollision collisionObjects;
    private com.mygdx.game.Objects.Wall wall;

    private Vector3 movement;
    private Vector3 position;

    private Rectangle pCollision;

    private Texture spr;

    public Player(float x, float y){
        spr = new Texture("protoSprite.png");

        posX = x;
        posY = y;

        collisionObjects= new Wall();

        Float spW = new Float(spr.getWidth());
        Float spH = new Float(spr.getHeight());

        movement = new Vector3(0,0,0);
        position = new Vector3(x,y,0);


        pCollision = new Rectangle(posX,posY,spW,spH);
    }

    public void checkInput(float DT){
        //boolean input = Gdx.input.isKeyPressed(Input.Keys.RIGHT);

            if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                move(300, 0, DT);
                collisionReaction(-300,0,DT);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.W)) {
                move(0, 300, DT);
                collisionReaction(0,-300,DT);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                move(-300, 0, DT);
                collisionReaction(300,0,DT);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.S)) {
                move(0, -300, DT);
                collisionReaction(0,300,DT);
            }
        }


    public boolean checkCollision(){
        if (pCollision.overlaps(collisionObjects.getCollisions()))
            return true;
        return false;
    }

    public void collisionReaction(float x, float y, float DT){
        if(checkCollision())
            move(x,y,DT);
    }

    public void move(float x,float y,float DT) {
        movement.set(0, 0, 0);
        movement.add(x, y, 0);
        movement.scl(DT);

        position.add(movement.x, movement.y, 0);
        movement.scl(1 / DT);

        posX = position.x;
        posY = position.y;

        pCollision.setPosition(posX, posY);
    }

    public  float getPosY() {
        return posY;
    }

    public  float getPosX() {
        return posX;
    }

    public Texture getSpr() {
        return spr;
    }

    public Vector3 getPosition() {
        return position;
    }
}
