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

        if (pt.outOfBound()) {
            pt.reborn();
        }
    }

    @Override
    public void draw(Particle pt) {
        PApplet p = pt.p;
        float l = pt.v / 4;
        p.line(pt.x, pt.y,
                (float)(pt.x + l * Math.cos(pt.dir)),
                (float)(pt.y + l * Math.sin(pt.dir))
        );
    }

    @Override
    public void drawSettings(PApplet p) {
        p.noFill();
        p.stroke(0, 100);
    }
}
