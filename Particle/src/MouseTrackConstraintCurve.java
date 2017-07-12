import processing.core.PApplet;

public class MouseTrackConstraintCurve implements ConstraintCurve {

    private PApplet p;

    private float preT = -1;
    private float preC = 0;

    MouseTrackConstraintCurve(PApplet p) {
        this.p = p;
    }

    @Override
    public float constraint_radius() {
        return constraint_radius(Sketch.t);
    }

    @Override
    public float constraint_radius(float t) {
        if (preT == Sketch.t) {
            return preC;
        }
        float d = PApplet.dist(p.mouseX, p.mouseY, p.width / 2, p.height / 2);
        preT = Sketch.t;
        preC = d;
        return d;
    }
}
