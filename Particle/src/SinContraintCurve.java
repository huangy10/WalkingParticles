import processing.core.PApplet;

public class SinContraintCurve extends MouseTrackConstraintCurve implements ConstraintCurve{

    SinContraintCurve(PApplet p) {
        super(p);
    }

    @Override
    float calculateConstraint(float t) {
        return PApplet.sin(t * 2 * PApplet.PI / 6) * 200 + 200;
    }
}
