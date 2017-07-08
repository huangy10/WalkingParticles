final int WIDTH = 800;
final int HEIGHT = 800;
float t = 0;

final int N = 3000;
Particle p[];


float constraint_stable = 100;
float constraint_r = constraint_stable;

boolean flag = false;
int stage = 0;
int counter = 0; 
int T_STAGE_1 = 100;
int T_STAGE_2 = 200;

void setup(){
  size(800, 800);
  noStroke();
  frameRate(30);
  
  p = new Particle[N];
  for(int i=0; i<N; i++){
    p[i] = new Particle(random(WIDTH)-WIDTH/2, random(HEIGHT)-HEIGHT/2, random(8,10));
  }
}

void draw(){
  fill(255, 40);
  rect(0,0,WIDTH,HEIGHT);
  translate(WIDTH/2, HEIGHT/2);
  // rotate(t*2);
  noStroke();
  fill(0,100);
  
  if(flag){
    if(stage == 0){
       constraint_r = constraint_stable*(1+log(1+counter)*0.5);
      // constraint_r += (4*constraint_stable - constraint_r)*0.1;
    }else{
      constraint_r += (constraint_stable-constraint_r)*0.05;
    }
    counter++;
    if(counter > T_STAGE_1){
      stage = 1;
    }else if(counter > T_STAGE_2){
      stage = 0;
      flag = false;
      counter = 0;
    }
    println(constraint_r);
  }
  
  
  
  for(int i=0; i<N; i++){
    p[i].update();
  }
  
  for(int i=0; i<N; i++){
    p[i].draw();
  }
  
  t+=0.01;
}
void mousePressed(){
  flag = true;
  counter = 0;
  stage = 0;
}