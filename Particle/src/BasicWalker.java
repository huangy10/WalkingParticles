import processing.core.PApplet;
import processing.core.PConstants;

public class BasicWalker implements ParticleWalker {

    ConstraintCurve curve;
    private final float magicNumber = 4.5534515f;

    @Override
    public void update(Particle pt) {
        pt.dir = magicNumber * PConstants.PI * pt.p.noise(pt.seed, Sketch.t);

        pt.x += pt.v * Math.cos(pt.dir);
        pt.y += pt.v * Math.sin(pt.dir);

        float dis = PApplet.dist(pt.x, pt.y, 0, 0);
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x += -Math.sin(h * PConstants.PI * 4) * pt.x * 0.3;
        pt.y += -h * pt.y * 0.3;

        pt.x *= 0.99;
        pt.y *= 0.99;
    }

    @Override
    public void draw(Particle pt) {
        PApplet p = pt.p;
        float h = 1 + 2 * (PApplet.dist(pt.x, pt.y, 0, 0) - 150) / 600;
        p.ellipse(pt.x / 2, pt.y / 2, h, h);
    }
}
