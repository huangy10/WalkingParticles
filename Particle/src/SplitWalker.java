import processing.core.PApplet;

public class SplitWalker implements ParticleWalker {

    ConstraintCurve curve;

    SplitWalker(ConstraintCurve curve) {
        this.curve = curve;
    }

    @Override
    public void update(Particle pt) {
        brownianMove(pt);

        float dis = pt.getRadius();
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x += -Math.sin(h * Math.PI * 4) * pt.x * 0.3;
        pt.y += -h * pt.y * 0.3;

        pt.x *= 0.99;
        pt.y *= 0.99;
    }
}
