/*Classe da nave que anda para esquerda e para direita criacao do objeto do mesmo para ser executado na classe gamescreen*/

package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.TimeUtils;

public class Ship extends GameObject {

    private float x;
    private boolean live;
    private float vel = 250f;
    private long lastFire;
    private GameScreen gamescreen;

    public Ship(String nomTexture, float x, float y,GameScreen gamescreen) {
        super(nomTexture, x, y);
        this.gamescreen=gamescreen;
        live = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {   //classe de lancamento do missel com acriacao do objeto execucao do asstes e a condicao para tempo o proximo disparo
            if (TimeUtils.millis() - lastFire >= 300) {
                Assets.missile.play();
                Missile missile = new Missile(Assets.n_missile, getX() + getWidth() / 2 - 5, getY() + getHeight(), 300,gamescreen);
                getStage().addActor(missile);
                lastFire = TimeUtils.millis();
            }

        }

        x = getX();     // condicao para movimentacao da nave
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += delta * vel;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= delta * vel;
        }

        if (x <= 0) {
            x = 0;
        } else if (x >= Assets.LARGURA - getWidth()) {
            x = Assets.LARGURA - getWidth();
        }

        setPosition(x, 0);
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

}
