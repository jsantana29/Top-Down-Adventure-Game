package com.mygdx.game.Abstract;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.*;

/**
 * Created by Jean on 1/26/2016.
 */
public abstract class MovingObjects extends ObjectCollision {
    private Vector3 velocity;
    private boolean playerMoveable;
    private float momentum;

    public MovingObjects(){

    }

}
