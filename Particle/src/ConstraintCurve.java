public interface ConstraintCurve {
    float constraint_radius(float t);

    default float constraint_radius() {
        return constraint_radius(Sketch.t);
    }

    default void invoke() {
        // do nothing for default
    }
}
