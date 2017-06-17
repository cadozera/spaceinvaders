/*Classe dos aliens onde possui as posi;'oes para cria;'ao do objeto na classe
GameScreen*/

package br.cc.unp.spaceinvaders;

public class Alien extends GameObject {

    public Alien(String nomTexture, float x, float y) {
        super(nomTexture, x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (getRectangle().overlaps(GameScreen.ship.getRectangle())) {
            GameScreen.ship.setLive(false); //condicao para que se o alien encostar na nave ela seta a vida da nave como falsa e assim faz com que o jogo termine
        }
    }

}
