/*Classe dos objetos do jogo ela fica responsavel pela parte da matriz do jogo posicao x e y dos objetos como o jogo e em 2d*/
package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameObject extends Image {

    private Rectangle rectangle;

    public GameObject(String nomTexture, float x, float y) {
        super(new Texture(nomTexture));
        rectangle = new Rectangle(x, y, getWidth(), getHeight());
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        rectangle.setPosition(getX(), getY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

}
