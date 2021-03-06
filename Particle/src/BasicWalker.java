import processing.core.PApplet;
import processing.core.PConstants;

public class BasicWalker implements ParticleWalker{

    ConstraintCurve curve;

    BasicWalker(ConstraintCurve curve) {
        this.curve = curve;
    }

    @Override
    public void update(Particle pt) {
        brownianMove(pt);

        float dis = PApplet.dist(pt.x, pt.y, 0, 0);
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x += -h * pt.x * 0.3;
        pt.y += -h * pt.y * 0.3;

        pt.x *= 0.99;
        pt.y *= 0.99;
    }
}
