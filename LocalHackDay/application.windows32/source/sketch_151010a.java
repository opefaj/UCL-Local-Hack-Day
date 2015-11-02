import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_151010a extends PApplet {

int mili,sec,min,hour;
int counter = 0;
int theme = 0;

//double mili_Counter(){
  
//  mili = millis();
  
//  if((mili/1000)==counter){
//    counter++; 
//    mili = mili - (counter*1000); 
//  }
  
//  mili = millis() - (counter*1000);
  
//  //println(counter);
//  //println(abs((1000+mili))/1000.00);
  
//  return abs(((1000+mili))/1000.00);
//}

public void spiralShape(int dsp_wid, int dsp_height){
  pushMatrix();
  translate(dsp_wid, dsp_height);
  strokeWeight(2);
  beginShape();
  for(float i = 0; i<100; i++) {
    fill(255);
    curveVertex((i*2)*sin(i/2.6f), (i*2)*cos(i/2.6f));
  }
  endShape(); 
  popMatrix();
}
public void spiralSec(int dsp_wid, int dsp_height, int theme_choice){
  pushMatrix();
  sec = second();
  double shap_sec = (5.0f/3.0f)*sec;
  translate(dsp_wid, dsp_height);
  strokeWeight(2);
  beginShape();
  for(float i = 0; i<shap_sec; i++) {
    println(sec);
    switch (theme_choice){
      case 0:
      stroke(0);
      fill(41, 128, 185);
      break;
      
      case 1:
      stroke(44, 62, 80);
      fill(192, 57, 43);
      break;
      
      case 2:
      stroke(189, 195, 199);
      fill(101, 198, 187);
      break;
    }
    curveVertex((i*2)*sin(i/2.6f), (i*2)*cos(i/2.6f));
    if(shap_sec>=99.0f){
       fill(255); 
    }
  }
  endShape(); 
  popMatrix();
}
public void spiralMin(int dsp_wid, int dsp_height, int theme_choice){
  pushMatrix();
  min = minute();
  double shap_min = (5.0f/3.0f)*min;
  translate(dsp_wid, dsp_height);
  strokeWeight(2);
  beginShape();
  for(float i = 0; i<shap_min; i++) {
    switch (theme_choice){
      case 0:
      stroke(0);
      fill(22, 160, 133);
      break;
      
      case 1:
      stroke(44, 62, 80);
      fill(211, 84, 0);
      break;
      
      case 2:
      stroke(189, 195, 199);
      fill(68,108,179);
      break;
    }
    curveVertex((i*2)*sin(i/2.6f), (i*2)*cos(i/2.6f));
    //println(shap_min);
    if(shap_min>=99.0f){
       fill(255); 
    }
  }
  endShape(); 
  popMatrix();
}
public void spiralHour(int dsp_wid, int dsp_height, int theme_choice){
  pushMatrix();
  hour = hour();
  double shap_hour = (25.0f/6.0f)*hour;
  translate(dsp_wid, dsp_height);
  strokeWeight(2);
  beginShape();
  for(float i = 0; i<shap_hour; i++) {
    switch (theme_choice){
      case 0:
      stroke(0);
      fill(39, 174, 96);
      break;
      
      case 1:
      stroke(44, 62, 80);
      fill(243, 156, 18);
      break;
      
      case 2:
      stroke(189, 195, 199);
      fill(145, 61, 136);
      break;
    }
    curveVertex((i*2)*sin(i/2.6f), (i*2)*cos(i/2.6f));
    //println(shap_hour);
    if(shap_hour>=99.0f){
       fill(255); 
    }
  }
  endShape(); 
  popMatrix();
}

public void drawSec(int width, int height){
  fill(0);
  for(int i = 1; i<=5 ; i++){
    textSize(10);
    text((i*10),width,(height+(32*i))); 
  }
}

public void time_Text(){
    switch (theme){
      case 0:
      background(44, 62, 80);
      break;
      
      case 1:
      background(0);
      break;
      
      case 2:
      background(236, 240, 241);
      break;
    }
 
 PFont timeFont;
 timeFont = createFont("Gill Sans",50);
 switch (theme){
      case 0:
      fill(255);
      break;
      
      case 1:
      fill(255);
      break;
      
      case 2:
      fill(0);
      break;
    }
 textFont(timeFont);
 text(hour,170,500);
 text(min,560,500);
 text(sec,960,500);
}

public void setup(){
  
}

public void draw(){
  
  if(keyPressed){
     if(key=='a'){
        theme = 0; 
     }
     else if(key =='s'){
        theme = 1; 
     }
     else if(key == 'd'){
        theme = 2; 
     }
  }
  
  //mili_Counter();
  time_Text();
  spiralShape(206,206);
  spiralHour(206,206,theme);
  spiralShape(600,206);
  spiralMin(600,206,theme);
  spiralShape(994,206);
  spiralSec(994,206,theme);
  drawSec(990,200);
  drawSec(595,200);
  
}

  public void settings() {  size(1180,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_151010a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
