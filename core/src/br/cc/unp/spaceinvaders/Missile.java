package br.cc.unp.spaceinvaders;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Missile extends GameObject {

    private float vel;
    
    GameScreen gamescreen;
    
    public Missile(String nomTexture, float x, float y, float vel,GameScreen gamescreen) {
        super(nomTexture, x, y);
        this.gamescreen=gamescreen;
        this.vel = vel;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        moveBy(0, vel * delta);

        if (getY() > Assets.ALTURA) {
            remove();
        } else {
            for (Actor a : GameScreen.aliens.getChildren()) {
                Alien alien = (Alien) a;
                if (getRectangle().overlaps(alien.getRectangle())) {
                    Assets.explosion.play();
                    alien.clear();
                    alien.remove();
                    gamescreen.addpontos();
                    clear();
                    remove();
                }
            }
        }
    }
}
