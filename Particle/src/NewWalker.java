import processing.core.PApplet;

public class NewWalker implements ParticleWalker {
    ConstraintCurve curve;

    NewWalker(ConstraintCurve curve) {
        this.curve = curve;
    }

    @Override
    public void update(Particle pt) {
        brownianMove(pt);

        float dis = pt.getRadius();
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x *= 0.98;
        pt.y *= 0.98;
    }
}
