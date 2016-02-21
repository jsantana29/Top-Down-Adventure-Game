package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Abstract.ObjectCollision;
import com.mygdx.game.Metaphor;
import com.mygdx.game.Objects.Wall;
import com.mygdx.game.Player;
import com.mygdx.game.Scenes.Hud;

/**
 * Created by Jean on 2/16/2016.
 */
public class PlayScreen implements Screen {
    private Metaphor game;
    private Player p1;
    private ObjectCollision collsionObjects;
    private Wall wall;
    private Hud hud;

    public OrthographicCamera gamecam;
    private Viewport gameport;

    float currentPosX = 0;
    float currentPosY = 0;

    public PlayScreen(Metaphor game){
        this.game = game;
        collsionObjects = new Wall();
        p1 = new Player(currentPosX,currentPosY);
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(Metaphor.V_WIDTH,Metaphor.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    public void update(float dt){
        p1.checkInput(dt, gamecam);
        //gamecam.update();
    }

    @Override
    public void render(float delta) {
        float DT = Gdx.graphics.getDeltaTime();
        update(DT);

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //System.out.println(p1.getPosX()+" "+p1.getPosY());
        System.out.println(hud.stage.getViewport().getCamera().position);
        System.out.println(gamecam.position);

        game.batch.setProjectionMatrix(gamecam.combined);
        gamecam.position.set(p1.getPosition());
        gamecam.update();

		game.batch.begin();
		game.batch.draw(collsionObjects.getImg(), collsionObjects.getPosX(), collsionObjects.getPosY());
        game.batch.draw(p1.getSpr(), p1.getPosX(), p1.getPosY());
		game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
