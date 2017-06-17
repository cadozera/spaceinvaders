/*Classe responsavel pelos arquivos internos do programa com as imagens e sons do programa*/

package br.cc.unp.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Assets {
    //Variaveis com os arquivos como resolucao imagens e sons
    public static int LARGURA = 480;
    public static int ALTURA = 650;
    public static String n_alien = "alien.png";
    public static String n_missile = "missile.png";
    public static String n_starfighter = "starfighter.png";
    public static String fundotela = "fundotela.jpg";
    public static String fundogameover = "fundogameover.png";
    public static String fundomenu = "fundomenu.png";
    public static Sound missile;
    public static Sound explosion;
    public static Music fundo;

    public static void init() {
        missile = Gdx.audio.newSound(Gdx.files.internal("missile.wav"));
        explosion = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
        fundo = Gdx.audio.newMusic(Gdx.files.internal("ring.mp3"));
    }

    public static void dispose() {
        missile.dispose();
        explosion.dispose();
        fundo.dispose();

    }

}
