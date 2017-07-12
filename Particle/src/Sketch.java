/*
 * Created by Woody Huang on 2017/7/12.
 *
 * From Tsinghua University.
 */
import processing.core.PApplet;

public class Sketch extends PApplet {

    /**
     * Global time variable
     */
    static float t = 0;
    private Particle[] pts;
    /**
     * Number of particles
     */
    private final int N = 3000;

    private ParticleWalker walker;
    private ConstraintCurve curve;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        createWalker();
        createParticles();

        frameRate(30);
    }

    public void draw() {
        clearBg();
        preparePanel();
        updateParticles();

        updateTime();
    }

    public void mouseClicked() {
        curve.invoke();
    }

    private void updateTime() {
        t += 0.01;
    }

    // drawing
    private void clearBg() {
        fill(255, 40);
        rect(0, 0, width, height);
    }

    private void preparePanel() {
        translate(width / 2, height / 2);
        walker.drawSettings(this);
    }

    private void updateParticles() {
        for (Particle p: pts) {
            p.update();
        }
        for (Particle p: pts) {
            p.draw();
        }
    }

    // setup
    private void createWalker() {
        curve = new MouseTrackConstraintCurve(this);
        walker = new SplitWalker(curve);
    }

    private void createParticles() {
        pts = new Particle[N];

        for (int idx = 0; idx < N; idx += 1) {
            pts[idx] = new Particle(this, idx, random(8, 10));
            pts[idx].walker = walker;
        }
    }
}
