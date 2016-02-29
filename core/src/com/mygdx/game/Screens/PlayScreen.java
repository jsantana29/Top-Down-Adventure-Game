package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Abstract.MovingObjects;
import com.mygdx.game.Abstract.ObjectCollision;
import com.mygdx.game.Metaphor;
import com.mygdx.game.Objects.Bullets;
import com.mygdx.game.Objects.Wall;
import com.mygdx.game.Player;
import com.mygdx.game.Scenes.Hud;

import java.util.Stack;

/**
 * Created by Jean on 2/16/2016.
 */
public class PlayScreen implements Screen {
    private Metaphor game;
    private Player p1;
    private ObjectCollision collsionObjects;
    private MovingObjects movingObjects;
    //private MovingObjects bullet;
    private Hud hud;

    private Stack<MovingObjects> bullets;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public OrthographicCamera gamecam;
    private Viewport gameport;

    float currentPosX = 0;
    float currentPosY = 0;

    public PlayScreen(Metaphor game){
        this.game = game;
        collsionObjects = new Wall();
        p1 = new Player(currentPosX,currentPosY);
        movingObjects = new Bullets();
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(Metaphor.V_WIDTH,Metaphor.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);

        bullets = new Stack<MovingObjects>();

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map-1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    public void update(float dt){
        p1.checkInput(dt);

        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        //Updates anything that needs to be constantly checked
        update(delta);

        //Clears the screen every frame
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        //The spritebatch focuses on only the dimensions of the gamecam
        //Gamecam's position is set to follow player's position and updates position every frame
        game.batch.setProjectionMatrix(gamecam.combined);
        gamecam.position.set(p1.getPosition());
        gamecam.update();

        //Spritebatch is opened and the games objects are being drawn to the screen before closing
		game.batch.begin();
		game.batch.draw(collsionObjects.getImg(), collsionObjects.getPosX(), collsionObjects.getPosY());
        game.batch.draw(p1.getSpr(), p1.getPosX(), p1.getPosY());

        for(MovingObjects bill : bullets){
            game.batch.draw(bill.getImg(),bill.getPosition().x,bill.getPosition().y);
        }

        if(movingObjects.isMoving()){

            bullets.push(new Bullets(p1.getPosX(),p1.getPosY(),p1.getSpW(),p1.getSpH()));
            System.out.println(bullets.size());

        }
        movingObjects.setMoving(false);

        for(MovingObjects bill : bullets){
                bill.move(500,0,delta);
        }

		game.batch.end();

        //Projection is set on the HUD's camera, which has the same dimensions as the gamecam
        //HUD is drawn on the screen
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
        bullets.get(0).dispose();
    }
}
