package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Metaphor;

/**
 * Created by Jean on 2/20/2016.
 */
public class Hud {
    public Stage stage;
    public Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label worldLabel;
    Label marioLabel;

    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(Metaphor.V_WIDTH,Metaphor.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);

        //Creates a table that holds all the labels we created
        //This table goes inside our stage, which holds all the tables that make up the HUD
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //Creating the labels
        countdownLabel = new Label(String.format("%03d",worldTimer),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("Asgard",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("Player",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //Adding the labels inside of the table
        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(countdownLabel).expandX();

        //adding the table inside the stage
        stage.addActor(table);
    }

}
