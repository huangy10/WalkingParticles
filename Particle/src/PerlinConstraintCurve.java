import processing.core.PApplet;

public class PerlinConstraintCurve extends MouseTrackConstraintCurve implements ConstraintCurve {

    private float seed;

    PerlinConstraintCurve(PApplet p) {
        super(p);
        seed = p.random(-100, 100);
    }

    @Override
    float calculateConstraint(float t) {
        return p.noise(seed, t) * 150;
    }
}
