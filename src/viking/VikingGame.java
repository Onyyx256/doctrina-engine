package viking;

import doctrina.Game;
import doctrina.GameConfig;
import doctrina.RenderingEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class VikingGame extends Game {

    private Player player;
    private GamePad gamePad;
    private World world;
    private Tree tree;
    private Platform platform;
    private int soundCooldown;

    @Override
    protected void initialize() {
        GameConfig.enableDebug();
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 396);
        world = new World();
        world.load();
        tree = new Tree(300, 350);
        platform = new Platform(250, 200);

        if (!GameConfig.isDebugEnabled()) {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream stream = AudioSystem.getAudioInputStream(
                        this.getClass().getClassLoader().getResourceAsStream("audios/music.wav"));
                clip.open(stream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // RenderingEngine.getInstance().getScreen().toggleFullScreen();
        RenderingEngine.getInstance().getScreen().hideCursor();
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (player.getY() < platform.getY() - 31) {
            platform.enableBlockade();
        } else {
            platform.disableBlockade();
        }

        soundCooldown--;
        if (soundCooldown < 0) {
            soundCooldown = 0;
        }

        if (gamePad.isFirePressed() && soundCooldown == 0) {
            soundCooldown = 100;
            SoundEffect.MURLOC.play();
        }
    }

    @Override
    protected void draw(doctrina.Canvas canvas) {
        world.draw(canvas);
        // 80 (tree height) - 28 (max for layer switch)
        platform.draw(canvas);
        if (player.getY() < tree.getY() + 52) {
            player.draw(canvas);
            tree.draw(canvas);
        } else {
            tree.draw(canvas);
            player.draw(canvas);
        }
    }
}