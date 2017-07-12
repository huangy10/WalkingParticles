/*
 * Created by Woody Huang on 2017/7/12.
 *
 * From Tsinghua University.
 */

import processing.core.PApplet;

class Particle {
    PApplet p;

    int idx;

    float x, y;
    float v, dir;
    float seed;

    ParticleWalker walker;

    Particle(PApplet p, int idx, float v) {
        this.idx = idx;
        this.p = p;
        this.v = v;

        init();
    }

    void init() {
        this.x = p.random(-p.width / 2, p.width / 2);
        this.y = p.random(-p.height / 2, p.height / 2);
        this.dir = p.random(0, PApplet.PI);
        this.seed = p.random(-100, 100);
    }

    void update() {
        walker.update(this);
    }

    void draw() {
        walker.draw(this);
    }

    void reborn() {
        init();
    }

    boolean outOfBound() {
        return outOfBound(100);
    }

    boolean outOfBound(float tolerance) {
        return x < -tolerance - p.width / 2 || x > p.width / 2 + tolerance ||
                y < -tolerance - p.height / 2 || y > p.height / 2 + tolerance;
    }
}
