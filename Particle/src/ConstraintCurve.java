public interface ConstraintCurve {
    float constraint_radius(float t);
    float constraint_radius();

    default void invoke() {
        // do nothing for default
    }
}
