import processing.core.PApplet;
import processing.core.PConstants;

public interface ParticleWalker {
    void update(Particle pt);
    default void draw(Particle pt) {
        PApplet p = pt.p;
        float l = pt.v / 2;
        p.line(pt.x, pt.y,
                (float)(pt.x + l * Math.cos(pt.dir)),
                (float)(pt.y + l * Math.sin(pt.dir))
        );
    }

    default void brownianMove(Particle pt) {
        float magicNumber = 4.5534515f;
        pt.dir = magicNumber * PConstants.PI * pt.p.noise(pt.seed, Sketch.t);

        pt.x += pt.v * Math.cos(pt.dir);
        pt.y += pt.v * Math.sin(pt.dir);
    }

    default void drawSettings(PApplet p) {
        p.noFill();
        p.stroke(0, 100);
    }
}
