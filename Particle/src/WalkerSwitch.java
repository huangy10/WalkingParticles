import processing.core.PApplet;

public class WalkerSwitch implements ParticleWalker {

    class StateCurve implements ConstraintCurve {

        WalkerSwitch walker;

        StateCurve(WalkerSwitch walker) {
            this.walker = walker;
        }

        @Override
        public float constraint_radius(float t) {
            return 0;
        }

        @Override
        public void invoke() {
            walker.nextWalker();
        }
    }

    ParticleWalker[] walkers;
    int idx = 0;
    private ConstraintCurve curve;

    WalkerSwitch(ParticleWalker[] walkers) {
        this.walkers = walkers;
        this.curve = new StateCurve(this);
    }

    @Override
    public void brownianMove(Particle pt) {
        walkers[idx].brownianMove(pt);
    }

    @Override
    public void update(Particle pt) {
        walkers[idx].update(pt);
    }

    @Override
    public void draw(Particle pt) {
        walkers[idx].draw(pt);
    }

    @Override
    public void drawSettings(PApplet p) {
        walkers[idx].drawSettings(p);
    }

    ConstraintCurve getCurve() {
        return curve;
    }

    void nextWalker() {
        idx = (idx + 1) % walkers.length;
    }
}
