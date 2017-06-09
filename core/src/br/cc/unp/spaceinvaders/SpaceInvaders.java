package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.Game;

public class SpaceInvaders extends Game {

    @Override
    public void create() {
        Assets.init();
        setScreen(new MainScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}
