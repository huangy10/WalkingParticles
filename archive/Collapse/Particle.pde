

class Particle{
  float x, y;      // Position
  float v, dir;    // Velocity and direction
  float seed;      // random seed
  
  Particle(float _x, float _y, float _v){
    x = _x;
    y = _y;
    v = _v;
    seed = random(-100,100);
  }
  void update(){
    dir = 4.5534515*PI*noise(seed, t);
    x += v*cos(dir);
    y += v*sin(dir);
    
    // add some constraint;
    float dis = dist(x, y, 0, 0);
    float h = abs(dis - constraint_r)/max(WIDTH, HEIGHT)/2;
    
     x += -h*x*0.39;
     y += -h*y*0.19;
    //
    // add some gravity
     x *= -0.98;
     y *= -1.02;
    // rotate the particle according to the h
    //*/
    float r = (dis - constraint_r)/max(WIDTH, HEIGHT)/2;
    float rotate = 1.5*r/h*(h+1)*PI/90;
    x = x*cos(rotate)-y*sin(rotate);
    y = x*sin(rotate)+y*cos(rotate);
    //*/
    
  }
  void draw(){
    float h = 1+2*(dist(x,y,0,0) - 150)/600;
    ellipse(x/2,y/2,h,h);
  }
}
