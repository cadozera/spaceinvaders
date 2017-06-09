package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Timer;

public class GameScreen extends ScreenAdapter {

    private SpaceInvaders game;
    public static Ship ship;
    private Stage stage;
    public static Group aliens;
    private BitmapFont font;
    private SpriteBatch batch;
    private Sprite sprite;
    private int pontos=0;

    public GameScreen(SpaceInvaders game) {
        this.game = game;
        stage = new Stage();
        Fundotela fundo = new Fundotela(Assets.fundotela, 0, 0);
        stage.addActor(fundo);
        ship = new Ship(Assets.n_starfighter, Assets.LARGURA / 2 - 30, 0, this);
        stage.addActor(ship);
        aliens = new Group();
        stage.addActor(aliens);
        batch = new SpriteBatch();
        font = new BitmapFont();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                positionAliens();
            }
        }, 1, 0.5f);
        Assets.fundo.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
        batch.begin();
        font.getData().setScale(0.80f);
        font.draw(batch, "Pontos"+pontos, 1, 10);

        batch.end();

        if (!ship.isLive()) {
            Assets.fundo.stop();
            game.setScreen(new GameOverScreen(game));

        }
    }

    private void positionAliens() {
        float x = MathUtils.random(20, Assets.LARGURA - 40);
        Alien alien = new Alien(Assets.n_alien, x, Assets.ALTURA);
        alien.addAction(Actions.sequence(Actions.moveBy(0, -Assets.ALTURA, 5.0f), Actions.removeActor()));
        aliens.addActor(alien);
    }

    public void dispose() {
        super.dispose();
        stage.dispose();

    }

    void addpontos() {
      pontos=pontos+1;  
    }

}
