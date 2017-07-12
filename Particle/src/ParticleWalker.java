import processing.core.PApplet;
import processing.core.PConstants;

public interface ParticleWalker {
    void update(Particle pt);
    default void draw(Particle pt) {
        PApplet p = pt.p;
        float h = 1 + 2 * (PApplet.dist(pt.x, pt.y, 0, 0) - 150) / 600;
        p.ellipse(pt.x, pt.y, h, h);
    }

    default void brownianMove(Particle pt) {
        float magicNumber = 4.5534515f;
        pt.dir = magicNumber * PConstants.PI * pt.p.noise(pt.seed, Sketch.t);

        pt.x += pt.v * Math.cos(pt.dir);
        pt.y += pt.v * Math.sin(pt.dir);
    }

    default void drawSettings(PApplet p) {
        p.noStroke();
        p.fill(0, 100);
    }
}
