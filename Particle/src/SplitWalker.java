import processing.core.PApplet;
import processing.core.PConstants;

public class SplitWalker implements ParticleWalker {

    ConstraintCurve curve;

    SplitWalker(ConstraintCurve curve) {
        this.curve = curve;
    }

    @Override
    public void update(Particle pt) {
        brownianMove(pt);

        float dis = PApplet.dist(pt.x, pt.y, 0, 0);
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x += -Math.sin(h * PConstants.PI * 4) * pt.x * 0.3;
        pt.y += -h * pt.y * 0.3;

        pt.x *= 0.99;
        pt.y *= 0.99;
    }
}
