

class Particle {
  float x, y;      // Position
  float v, dir;    // Velocity and direction
  float seed;      // random seed

    Particle(float _x, float _y, float _v) {
    x = _x;
    y = _y;
    v = _v;
    seed = random(-100, 100);
  }
  void update() {
    dir = 4.5534515*PI*noise(seed, t);
    x += v*cos(dir);
    y += v*sin(dir);

    // add some constraint;
    float dis = dist(x, y, 0, 0);
    float h = abs(dis - constraint_r)/max(WIDTH, HEIGHT)/2;

    x += -sin(h * PI * 10)*x*0.5;
    y += -cos(h * PI * 8)*y*0.5 ;
    //
    // add some gravity
    x *= 0.99;  // try change to 0.99
    y *= 0.99;
    // rotate the particle according to the h

    float r = (dis - constraint_r/0.5)/max(WIDTH, HEIGHT)/2;
    float rotate = 5 * r *r/h*(h+1)*PI/90;
    // float rotate = sin(r)/h*(h+1)*PI;
    x = x*cos(rotate)-y*sin(rotate);
    y = x*sin(rotate)+y*cos(rotate);
  }
  void draw() {
    float h = 1+2*(dist(x, y, 0, 0) - 150)/600;
    // h = 1;
    ellipse(x/2, y/2, h, h);
  }
}

