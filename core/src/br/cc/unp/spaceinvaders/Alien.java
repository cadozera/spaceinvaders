package br.cc.unp.spaceinvaders;

public class Alien extends GameObject {

    public Alien(String nomTexture, float x, float y) {
        super(nomTexture, x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (getRectangle().overlaps(GameScreen.ship.getRectangle())) {
            GameScreen.ship.setLive(false);
        }
    }

}
