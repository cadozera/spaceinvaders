package br.cc.unp.spaceinvaders.desktop;

import br.cc.unp.spaceinvaders.Assets;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.cc.unp.spaceinvaders.SpaceInvaders;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = Assets.LARGURA;
                config.height= Assets.ALTURA;
		new LwjglApplication(new SpaceInvaders(), config);
	}
}
