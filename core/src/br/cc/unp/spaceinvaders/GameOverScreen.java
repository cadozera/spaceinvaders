package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen extends ScreenAdapter {

    private SpaceInvaders game;
    private BitmapFont font;
    private SpriteBatch batch;
    Texture img;
    private Sprite sprite;

    public GameOverScreen(SpaceInvaders game) {
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("fundogameover.png");
        sprite = new Sprite(img);
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, "GAME OVER", 120, 400);
        font.getData().setScale(1.5f);
        font.draw(batch, "Pressione o botao para continuar", 80, 350);
        sprite.draw(batch);
        batch.end();
        
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainScreen(game));
        }

    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
        img.dispose();
    }

}
