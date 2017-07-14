import processing.core.PApplet;

public class ZeroWalker extends SplitWalker implements ParticleWalker {

    ZeroWalker(ConstraintCurve curve) {
        super(curve);
    }

    @Override
    public void update(Particle pt) {
        brownianMove(pt);

        float dis = pt.getRadius();
        float h = Math.abs(dis - curve.constraint_radius()) / pt.p.height;

        pt.x += -Math.sin(h * Math.PI * 10) * pt.x * 0.3;
        pt.y += -Math.cos(h * Math.PI * 8) * pt.y * 0.3;

        pt.x *= 0.99;
        pt.y *= 0.99;

        // rotate
        float r = (dis - curve.constraint_radius()) / pt.p.height;
        float rotate = 5 * r * r  / h * (h + 1) * (float)Math.PI / 90;
        float c = PApplet.cos(rotate);
        float s = PApplet.sin(rotate);
        pt.x = pt.x * c + pt.y * s;
        pt.y = pt.x * s + pt.y * c;
    }
}
