import processing.core.PApplet;

public class PerlinConstraintCurve implements ConstraintCurve {

    private PApplet p;

    private float preT = -1;
    private float preC = 0;

    private float seed;

    PerlinConstraintCurve(PApplet p) {
        this.p = p;
        seed = p.random(-100, 100);
    }

    @Override
    public float constraint_radius(float t) {
        if (preT == Sketch.t) {
            return preC;
        }

        float d = p.noise(seed, t) * 250;
        preT = t;
        preC = d;
        return d;
    }
}
