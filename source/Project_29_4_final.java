import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import org.gicentre.geomap.*; 
import org.gicentre.utils.stat.*; 
import java.text.SimpleDateFormat; 
import java.util.*; 
import controlP5.*; 
import org.joda.time.DateTime; 
import org.joda.time.Seconds; 

import controlP5.*; 
import org.gicentre.geomap.*; 
import org.gicentre.geomap.io.*; 
import org.joda.time.base.*; 
import org.joda.time.chrono.*; 
import org.joda.time.*; 
import org.joda.time.convert.*; 
import org.joda.time.field.*; 
import org.joda.time.format.*; 
import org.joda.time.tz.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Project_29_4_final extends PApplet {

//import required libraries

 
 
 
 
 
 
 
ControlP5 _cp5_main_buttons;
PImage mapImage;
Table table; 
Table table2;
Table drone;
Table dronegraphtable;
GeoMap map;
float circlex;
float circley;
float circlex2;
float circley2;
int Day;
boolean Explosions ;
boolean Suicide ;
boolean Drone;
boolean Other;
String[] dates;
int balochistan=0;
int sindh=0;
int punjab=0;
int kpk=0;
int fata=0;
int gilgit=0;
int islamabad=0;
int kashmir = 0;
int balochistant=0;
int sindht=0;
int punjabt=0;
int kpkt=0;
int fatat=0;
int gilgitt=0;
int islamabadt=0;
int kashmirt = 0;
float exp;
float assault;
float assassination;
float infra;
float hostage;
float othertype;
float x;
float val;
float val2;
float y;
BarChart barChart;
int row;
BarChart barChart2;
XYChart count;
XYChart dronegraph;
PImage map2;
float total=718;
float circlesize;
float circlesize2;
float total2;
float t;
float t2;
int tab;
float[] years;
float[] counts;
float[] years2;
float[] counts2;
float[] years3;
float[] counts3;
float[] years4;
float[] counts4;
float icount3=0;
float icount4 =0;
float[] years5;
float[] counts5;
float icount5 =0;
float diedtotal=0;
float died =0;
float x2;
float y2;
float xPos;
float yPos;
float xPos2;
float yPos2;
float icount;
int ival=0;
XYChart empty;
IntDict yearandcount;
int back = color(255, 255, 255, 0);
int maxval;
int mincol, maxcol;
float num;
int mouseval;
int _total_fata;
float deathcount=0;
float wounded = 0;
float deathcount2=0;
float wounded2 = 0;
//Global Variables
int _width = 1024;
int _height = 768;
PImage backgroundImage;
int totalcount;
float totaldrone=0;
float totalsuicide;
int totalgtd=0;
int suicidedeath=0;
int suicidewound=0;
BarChart dronebar;
BarChart dronebar2;
PImage[] _btn_explosive; 
PImage[] _btn_suicide; 
PImage[] _btn_drone; 
PImage[] _btn_other; 
PImage[] _btn_play; 
PImage[] _btn_next; 
PImage[] _btn_previous;
int mouseyear, mouseyear2;
CirclePoint[] _list_circles;
FontManager _fontManager;
public void setup()
{       

  
  mincol = color(100, 220, 100);   
  maxcol = color(0, 0, 0);
  yearandcount =  new IntDict();

  backgroundImage = loadImage("background.jpg");
  _fontManager = FontManager.getInstance(this);

  //Load Button Images
  _btn_explosive = new PImage[2];
  _btn_explosive[0] = loadImage("btn_explosive.jpg");
  _btn_explosive[1] = loadImage("btn_explosive_clicked.jpg"); 

  _btn_suicide = new PImage[2];
  _btn_suicide[0] = loadImage("btn_suicide.jpg");
  _btn_suicide[1] = loadImage("btn_suicide_clicked.jpg"); 

  _btn_drone = new PImage[2];
  _btn_drone[0] = loadImage("btn_drone.jpg");
  _btn_drone[1] = loadImage("btn_drone_clicked.jpg"); 

  _btn_other = new PImage[2];
  _btn_other[0] = loadImage("btn_other.jpg");
  _btn_other[1] = loadImage("btn_other_clicked.jpg"); 

  _btn_play = new PImage[2];
  _btn_play[0] = loadImage("btn_play.png");
  _btn_play[1] = loadImage("btn_pause.png"); 

  _btn_next = new PImage[3];
  _btn_next[0] = loadImage("btn_next.png");
  _btn_next[1] = loadImage("btn_next_hover.png");
  _btn_next[2] = loadImage("btn_next.png");

  _btn_previous = new PImage[3];
  _btn_previous[0] = loadImage("btn_previous.png");
  _btn_previous[1] = loadImage("btn_previous_hover.png");
  _btn_previous[2] = loadImage("btn_previous.png");
  textSize(30);  
  //intialise and define graphs
  count = new XYChart(this);
  count.setMaxX(2015);
  count.setMinX(2000);
  count.setXFormat("####");
  count.setMinY(0);
  count.setMaxY(100);
  count.showXAxis(false);
  count.showYAxis(false);
  count.setPointColour(color(216, 44, 145));
  count.setPointSize(5);
  count.setLineColour(color(216, 44, 145));
  count.setLineWidth(2);

  empty = new XYChart(this);
  empty.setMaxX(2015);
  empty.setMinX(2006);
  empty.setXFormat("####");
  empty.setMinY(0);
  empty.setMaxY(100);
  empty.showXAxis(false);
  empty.showYAxis(true);
  empty.setPointColour(color(216, 44, 145));
  empty.setPointSize(5);
  empty.setLineColour(color(216, 44, 145));
  empty.setLineWidth(2);
  DateTime start = new DateTime(2000, 01, 01, 00, 0, 0);
  DateTime end = new DateTime(2015, 12, 30, 00, 0, 0);
  // initialise and set time slider
  timeRangeSlider = new TimeRangeSlider(this, 100, 718, 824, 50, start, end, 60 * 60 * 24 * 30);
  timeRangeSlider.setTickIntervalSeconds(60 * 60* 24*30);
  timeRangeSlider.setAnimationIntervalSeconds(60 * 60* 24*30);
  timeRangeSlider.running = false;

  noStroke();

  map = new GeoMap(this);
  map = new GeoMap(341, 35, 677, 616, this);

  //read shapefil and load tablese
  map.readFile("PAK_adm1");
  drone = loadTable("drone_attacks.tsv");
  dronegraphtable = loadTable("drone.tsv", "header,tsv");
  table = loadTable("gtd.tsv", "header,tsv");
  totalcount = table.getRowCount();
  _list_circles = new CirclePoint[table.getRowCount()];
  textAlign(LEFT, BOTTOM);
  barChart = new BarChart(this);
  barChart = new BarChart(this);
  barChart2 = new BarChart(this);
  dronebar = new BarChart(this);
//set bargraphs
  dronebar.setBarColour(color(200, 80, 80, 150));
  dronebar.setMinValue(0);
  dronebar.setMaxValue(90);
  dronebar2 = new BarChart(this);


  dronebar2.setMinValue(0);
  dronebar.setMaxValue(90);
  fillyandc();
  fillyandc3();
  fillyandc4();
  fillyandc5();
  tab=1;
  row=1;
  addButtonsToScreen();
}

public void draw()
{
  //carry out specific functions depending on selected tab
  if (mousePressed) {
    _slider_changed = true;
    if (mouseX<256 && mouseY <35) {
      tab=1;
      SetMainButtons(true);
    }
  }
  if (mousePressed) {
    if (mouseX<512 && mouseX>256 && mouseY <35) {
      tab=2;
      SetMainButtons(false);
    }
  }
  if (mousePressed) {
    if (mouseX<768 && mouseX>512 && mouseY <35) {
      tab=3;
      SetMainButtons(false);
    }
  }
  if (tab==1)
  {
    tab1();
  } 
  row=0;
  if (tab==2)
  {   
    tab2();
  }
}
//taken from http://tillnagel.com/2012/06/animated-time-range-slider/


TimeRangeSlider timeRangeSlider;


// Gets called each time the time ranger slider has changed, both by user interaction as well as by animation
public void timeUpdated(DateTime startDateTime, DateTime endDateTime) {
  _slider_changed = true;

}


// Forwarding of key and mouse events

public void keyPressed() {
  timeRangeSlider.onKeyPressed(key, keyCode);
}

public void mouseMoved() {
  timeRangeSlider.onMoved(mouseX, mouseY);
}

public void mouseDragged() {
  timeRangeSlider.onDragged(mouseX, mouseY, pmouseX, pmouseY);
}



public void play1(int theValue) {

  if (timeRangeSlider.running == false) {
    timeRangeSlider.running = true;
  } else if (timeRangeSlider.running == true) {
    timeRangeSlider.running = false ;
  }
}

public void left(int theValue) {

  timeRangeSlider.previousAnimationStep();
}
public void right(int theValue) {

  timeRangeSlider.nextAnimationStep();
}
public void circleForDates(int localRow)
{
  circlex = table.getFloat(localRow, "longitude");
  circley = table.getFloat(localRow, "latitude"); 
  float nKill = table.getInt(localRow, "nkill");
  if(Float.isNaN(circlex) || Float.isNaN(circley)  || Float.isNaN(nKill) )
    return;
    
  circlex = map(circlex, 60.8746f, 77.8931f, 341, 1024);
  circley = map(circley, 23.6948f, 37.0837f, 641, 35);

  circlesize = map(nKill, 0, 157, 5, 90);


  if (Explosions == true)
  {
    if (table.getFloat(localRow, "attacktype1") == 3)
    {
      _list_circles[localRow] = new CirclePoint(circlex,circley,circlesize,circlesize,191, 54, 12,191, 54, 12);

    }
  }  
  if (Other == true)
  {
    if (table.getFloat(localRow, "attacktype1") != 1
      && table.getFloat(localRow, "attacktype1") != 2
      &&table.getFloat(localRow, "attacktype1") != 3)
    {
      _list_circles[localRow] = new CirclePoint(circlex,circley,circlesize,circlesize,1, 87, 155,1, 87, 155);

    }
  }
    if (Suicide == true)
  {
    if (table.getFloat(localRow, "suicide") == 1)
    {
      _list_circles[localRow] = new CirclePoint(circlex,circley,circlesize,circlesize,62, 39, 35,62, 39, 35);

      
    }
  }

}

public void dronecircle(int localRow) {
  if (localRow<drone.getRowCount())
  {
    circlex2 = drone.getFloat(localRow, 6);   
    circley2 = drone.getFloat(localRow, 7);
    float nKill = drone.getInt(localRow, 2);
    
    if(Float.isNaN(circlex2) || Float.isNaN(circley2) || Float.isNaN(circlesize2))
      return;
    
    circlesize2 = map(nKill, 0, 157, 5, 50);
    circlex2 = map(circlex2, 60.8746f, 77.8931f, 341, 1024);
    circley2 = map(circley2, 23.6948f, 37.0837f, 641, 35);
    if (Drone == true)
    {
      _list_circles[localRow] = new CirclePoint(circlex,circley,circlesize,circlesize,0, 0, 0,0, 0, 0);

    }
  }
}
public void drawmap()
{
  strokeWeight(0.5f);
  background(backgroundImage);
  _cp5_main_buttons.draw();
  stroke(0);               
  fill(100, 220, 100);   
  map.draw();
}
public void province()
{
  total = 718;
  int id = map.getID(mouseX, mouseY);
  fill(0);
  // give user name of province at mouse position alongside the number of attacks within the selected time range
  if (id != -1)
  {
    fill(50, 150, 50);   
    map.draw(id);
    if (id==1)
    {
      fill(255);
      text("Event Count: "+kashmirt, mouseX-100, mouseY+40);
    }
    if (id==2)
    {
      fill(255);
      text("Event Count: "+balochistant, mouseX-100, mouseY+40);
    }
    if (id==3)
    {
      fill(255);
      text("Event Count: "+fatat, mouseX-100, mouseY+40);
    }
    if (id==4)
    {
      fill(255);
      text("Event Count: "+islamabadt, mouseX-100, mouseY+40);
    }
    if (id==5)
    {
      fill(255);
      text("Event Count: "+kpkt, mouseX-100, mouseY+40);
    }
    if (id==6)
    {
      fill(255);
      text("Event Count: "+gilgit, mouseX-100, mouseY+40);
    }
    if (id==7)
    {
      fill(255);
      text("Event Count: "+punjabt, mouseX-100, mouseY+40);
    }
    if (id==8)
    {
      fill(255);
      text("Event Count: "+sindht, mouseX-100, mouseY+40);
    }
    String name = map.getAttributeTable().findRow(str(id), 0).getString(2);
    fill(0);
    text(name, mouseX-100, mouseY+20);
  }
}
public void colourchange()
{  
  fill(lerpColor(mincol, maxcol, norm(fatat, 0, totalcount/10 )));
  map.draw(3); 
}
public void addButtonsToScreen()
{
  _cp5_main_buttons = new ControlP5(this);
  _cp5_main_buttons.addToggle("Explosions")
    .setValue(128)
    .setPosition(28, 580)
    .setSize(150, 38)
    .setImages(_btn_explosive).updateSize();

  _cp5_main_buttons.addToggle("Suicide")
    .setValue(1)
    .setPosition(180, 580)
    .setSize(150, 38)
    .setImages(_btn_suicide).updateSize();

  _cp5_main_buttons.addToggle("Drone")
    .setValue(1)
    .setPosition(28, 620)
    .setSize(150, 38)
    .setImages(_btn_drone).updateSize();

  _cp5_main_buttons.addToggle("Other")
    .setValue(1)
    .setPosition(180, 620)
    .setSize(150, 38)
    .setImages(_btn_other).updateSize();

  _cp5_main_buttons.addToggle("play1")
    .setValue(1)
    .setPosition(880, 600)
    .setSize(50, 50)
    .setImages(_btn_play).updateSize();

  _cp5_main_buttons.addButton("left")
    .setPosition(838, 605)
    .setSize(40, 40)
    .setImages(_btn_previous).updateSize();

  _cp5_main_buttons.addButton("right")
    .setPosition(932, 605)
    .setSize(40, 40)
    .setImages(_btn_next).updateSize();

  _cp5_main_buttons.setAutoDraw(false);
}

public void SetMainButtons(boolean visibility)
{
  if (visibility)
    _cp5_main_buttons.show();
  else
    _cp5_main_buttons.hide();
}

public void updateStats()
{
  DateTime date;
  DateTime sDate = timeRangeSlider.getCurrentStartDateTime();
  DateTime eDate = timeRangeSlider.getCurrentEndDateTime();
  row=0;
  sindh=0;
  punjab=0;
  balochistan = 0;
  fata=0;
  kpk=0;
  gilgit=0;
  islamabad=0;
  kashmir=0;
  totaldrone=0;
  totalsuicide=0;
  deathcount=0;
  deathcount2=0;
  wounded=0;
  wounded2=0;
  _total_fata = 0;
  totalgtd=0;
  fatat = 0;
  balochistant = 0;
  punjabt = 0;
  islamabadt = 0;
  gilgitt = 0;
  kpkt = 0;
  sindht = 0;
  kashmirt = 0;
  suicidedeath=0;
  suicidewound=0;
  exp=0;
  assault=0;
  assassination=0;
  infra=0;
  hostage=0;
  othertype=0;
  while (row < table.getRowCount())
  {  
    _list_circles[row] = null;
    DateTime localDate = DateTime.parse(table.getString(row, 0), DateTimeFormat.forPattern("dd/MM/yyyy"));
    //println(drone.getString(row2,0));
    if (localDate.isAfter(sDate)  && localDate.isBefore(eDate))
    //count deaths injuries incidents etc.
    {
      totalgtd++;

      if (table.getInt(row, "suicide")==1)
      {       
        suicidedeath=suicidedeath+table.getInt(row, "nkill");        
        suicidewound=suicidewound+table.getInt(row, "nwound");
        totalsuicide=totalsuicide+1;

        if (table.getString(row, "provstate").equals("Sindh")) 
        {
          sindh =  sindh+1;
        }
        if (table.getString(row, "provstate").equals("Punjab"))
        {
          punjab =  punjab+1;
        } 
        if (table.getString(row, "provstate").equals("Balochistan"))
        {
          balochistan =  balochistan+1;
        } 
        if (table.getString(row, "provstate").equals("Islamabad Capital Territory"))
        {
          islamabad =  islamabad+1;
        }     
        if (table.getString(row, "provstate").equals("North-West Frontier Province"))
        {
          kpk =  kpk+1;
        }
        if (table.getString(row, "provstate").equals("Federally Administered Tribal Areas")) 
        {
          fata =  fata+1;
          _total_fata++;
        }
        if (table.getString(row, "provstate").equals("Gilgit-Baltistan"))
        {
          gilgit =  gilgit+1;
        }      
        if (table.getString(row, "provstate").equals("Azad Kashmir"))
        {
          kashmir =  kashmir+1;
        }
      } else
      {

        if (table.getString(row, "provstate").equals("Sindh")) 
        {
          sindht =  sindht+1;
        }
        if (table.getString(row, "provstate").equals("Punjab"))
        {
          punjabt =  punjabt+1;
        } 
        if (table.getString(row, "provstate").equals("Balochistan"))
        {
          balochistant =  balochistant+1;
        } 
        if (table.getString(row, "provstate").equals("Islamabad Capital Territory"))
        {
          islamabadt =  islamabadt+1;
        }     
        if (table.getString(row, "provstate").equals("North-West Frontier Province"))
        {
          kpkt =  kpkt+1;
        }
        if (table.getString(row, "provstate").equals("Federally Administered Tribal Areas")) 
        {
          fatat =  fatat+1;
        }
        if (table.getString(row, "provstate").equals("Gilgit-Baltistan"))
        {
          gilgitt =  gilgitt+1;
        }      
        if (table.getString(row, "provstate").equals("Azad Kashmir"))
        {
          kashmirt =  kashmirt+1;
        }
        deathcount2 = deathcount2+table.getInt(row, "nkill");
        wounded2 = wounded2+table.getInt(row, "nwound");
      }
//draw circles
      circleForDates(row);

      String type = table.getString(row, "attacktype1");
      if (type.equals("1")) {
        assassination++;
      } else if (type.equals("2")) {
        assault++;
      } else if (type.equals("3")) {
        exp++;
      } else if (type.equals("6")) {
        hostage++;
      } else if (type.equals("7")) {
        infra++;
      } else {
        othertype++;
        //continue;
      }
    }
    row++;
  }

  int row2 = 1;
  while (row2 < drone.getRowCount())
  {
    DateTime localDate2 = DateTime.parse(drone.getString(row2, 0), DateTimeFormat.forPattern("dd/MM/yyyy"));
    if (localDate2.isAfter(sDate)  && localDate2.isBefore(eDate))
    {   
      deathcount = deathcount+drone.getInt(row2, 2);
      if (Float.isNaN(drone.getFloat(row2, 5)) == true)
      {
        continue;
      }
      wounded = wounded+drone.getInt(row2, 5);
      dronecircle(row2);
      totaldrone=totaldrone+1;
    }        
    row2++;
  }
  t=0;
  t2=0;
  row=0;
  _slider_changed = false;
}

boolean _buttons_added = false;
boolean _slider_changed = false;

public void tab1()
{
  drawmap();
  //addButtonsToScreen();
  colourchange();
  province();
  _cp5_main_buttons.draw();


  if (_slider_changed)
  {
    updateStats();
    _slider_changed = false;
  }

  for (CirclePoint point : _list_circles) {

    if (point == null)
      continue;

    stroke(point.StrokeColorR, point.StrokeColorG, point.StrokeColorB, 50);
    fill(point.FillColorR, point.FillColorG, point.FillColorB, 50);
    ellipse(point.PosX, point.PosY, point.SizX, point.SizY);
  }

  fill(255);
  stroke(255);

  //println(mouseX, mouseY);

  //text("Suicide attacks", 50, 325);
  //text("Sindh = "+sindh, 50, 350);
  //text("Punjab = "+punjab, 50, 375);
  //text("FATA = "+fata, 50, 400);
  //text("KPK = "+kpk, 50, 425);
  //text("Balochistan = "+balochistan, 50, 450);
  //text("Giligt-Baltistan = "+gilgit, 50, 475);
  //text("Azad Kashmir = "+kashmir, 50, 500);
  //text("Islamabad = "+islamabad, 50, 525);
  textSize(32);
  text("Drone Strikes and Terrorism in Pakistan", 15, 80);
  text("(2000-2015)", 450, 140);
  textSize(12);
  text("Selected Period - Information", 45, 115);
  text(timeRangeSlider.TimeRangeLabel, 90, 140);

  textFont(_fontManager.getLabelFont());
  text("Drone Attacks", 33, 185);
  text("Suicide Attacks", 33, 275);
  text("Terror Events", 33, 365);

  textFont(_fontManager.getLargeNumberFont());
  text(PApplet.parseInt(totaldrone), 225, 235);
  text(PApplet.parseInt(totalsuicide), 225, 325);
  text(PApplet.parseInt(totalgtd), 160, 415);

  textFont(_fontManager.getSmallLabelFont());
  int baseSize =  375;
  text("People Killed:", 33, 205);
  text("People Injured:", 33, 230);
  text("People Killed:", 33, 295);
  text("People Injured:", 33, 320);
  text("Total Deaths: ", 33, baseSize + 25);
  text("Total Injuries: ", 33, baseSize + 50);
  text("Number of Explosions: ", 33, baseSize + 75);
  text("Number of Armed Assaults: ", 33, baseSize + 100);
  text("Number of Hostage Takings: ", 33, baseSize + 125);
  text("Number of Assassinations: ", 33, baseSize + 150);
  text("Number of Facility/Infrastructure Attacks: ", 33, baseSize + 175);
  textFont(_fontManager.getLabelFont());
  text(PApplet.parseInt(deathcount), 107, 209);
  text(PApplet.parseInt(wounded), 114, 234);
  text(PApplet.parseInt(suicidedeath), 107, 299);
  text(PApplet.parseInt(suicidewound), 114, 324);
  text(PApplet.parseInt(deathcount2), 107, baseSize + 25+4);
  text(PApplet.parseInt(wounded2), 107, baseSize + 50+4);

  text(PApplet.parseInt(exp), 150+10, baseSize + 75+4);
  text(PApplet.parseInt(assault), 175+10, baseSize + 100+4);
  text(PApplet.parseInt(hostage), 180+10, baseSize + 125+4);
  text(PApplet.parseInt(assassination), 173+10, baseSize + 150+4);
  text(PApplet.parseInt(infra), 253+10, baseSize + 175+4);

  rectMode(CORNER);
  stroke(0);
  fill(255);

  rect(0, 0, 256, 35);
  rect(256, 0, 256, 35);
  fill(0);
  textSize(26);
  text("Geo-Spatial View", 20, 30);
  text("Timeline View", 276, 30);
  textSize(18);
  text("Peshawar", 767, 186);
  text("Karachi", 620, 606);
  text("Quetta", 570, 383);
  text("Lahore", 810, 313);
  text("Islamabad", 780, 218);
  timeRangeSlider.draw();
}
public void fillyandc()
{
  //set values for line graph
  years = new float[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015};  //initalise array
  counts = new float[16]; //initialise array

  for (int j= 0; j < 16; j++ )
  {
    icount = 0;
    for (int i =1; i<table.getRowCount()-1; i++) 
    {  
      if (table.getInt(i, "iyear") == j + 2000)
      {
        if (table.getInt(i, "suicide")==1)
        {
          icount = icount+1;
        }
      }
    }
    counts[j] = icount;
  }
  count.setData(years, counts);
}
public void tab2()
{
  background(230);
  println(mouseX, mouseY);

  rectMode(CORNER);
  stroke(0);
  fill(255);

  textSize(25);
  rect(0, 0, 256, 35);
  rect(256, 0, 256, 35);
  fill(0);
  textSize(26);
  text("Geo-Spatial View", 20, 30);
  text("Timeline View", 276, 30);

  textSize(26);
  text("Timeline View", 276, 30);
  //text("2006", 123, 414);
  //text("2008", 192, 414);
  rectMode(CORNER);
  stroke(0);
  fill(0);
  textSize(18);
  text("Loss of Civilian Life", 500, 615);
  text("Alleged High-profile deaths", 25, 120);
  text("Suicide Attacks per Year", 40, 210);
  strokeWeight(1);
  line(200, 120, 250, 220);
  line(125, 210, 160, 360);
  //make graph and display values
  DateTime mindate =DateTime.parse(("01/01/2000"), DateTimeFormat.forPattern("dd/MM/yyyy"));
  DateTime maxdate = DateTime.parse(("31/12/2015"), DateTimeFormat.forPattern("dd/MM/yyyy"));
  Period diff = new Period(mindate, maxdate);
  //int diff = maxdate-mindate;
  Days days = Days.daysBetween(mindate, maxdate);
  stroke(0);
  dronebar.draw(100, 0, 824, 390);
  dronebar2.draw(100, 678, 824, -245);
    textSize(10);
  if (mouseX<879 && mouseX>107)
  {
    fill(0);
    try {
      textSize(14);
      int mouseyear = floor(map(mouseX, 106, 878, 1, 98));
      text(PApplet.parseInt(counts3[mouseyear-2])+" deaths", mouseX, 200); 
      text("Month : "+drone.getString(PApplet.parseInt(years3[mouseyear]), 0).substring(3, 10), mouseX, 225); 
      int mouseyear2 = floor(map(mouseX, 106, 878, 0, 98));
      text(PApplet.parseInt(counts4[mouseyear-2])+" deaths", mouseX, 650); 
      text("Month : "+drone.getString(PApplet.parseInt(years4[mouseyear]), 0).substring(3, 10), mouseX, 675); 
      strokeWeight(0.5f);
      stroke(0);
      line(mouseX, 0, mouseX, 768);
      text("2006",116,398);
      text("2015",878,388);
    }
    catch(Exception e)
    {
      mouseyear=mouseyear-2;
      mouseyear2=mouseyear-2;
    }
  }




  //empty.draw(60, 50, 800, 600);   //draw empty chart

  count.draw(-125, 35, 1049, 390);
}


public void fillyandc3()
{
  years3 = new float[]{};  //initalise array
  counts3 = new float[]{}; //initialise array
  String datenow = drone.getString(1, 0);
  datenow = datenow.substring(3, 5);
  for (int i =1; i<drone.getRowCount()-1; i++) 
  { 
    String datenow2= drone.getString(i, 0);
    datenow2 = datenow2.substring(3, 5);

    if (datenow.equals(datenow2))
    {
      icount3 = icount+drone.getFloat(i, 2)-(drone.getFloat(i, 3) + drone.getFloat(i, 4) ) ;
    } else
    {
      counts3 = append(counts3, icount3);
      years3 = append(years3, i);        
      icount3=0;
      datenow = datenow2;
    }
  } 
  dronebar.setData(years3);
  dronebar.setData(counts3);
}

public void fillyandc4()
{
  years4 = new float[]{};  //initalise array
  counts4 = new float[]{}; //initialise array
  String datenow = drone.getString(1, 0);
  datenow = datenow.substring(3, 5);
  for (int i =1; i<drone.getRowCount()-1; i++) 
  { 
    String datenow2= drone.getString(i, 0);
    datenow2 = datenow2.substring(3, 5);
    if (datenow.equals(datenow2))
    {
      icount4 = icount4+drone.getFloat(i, 3) + drone.getFloat(i, 4)  ;
    } else
    {
      counts4 = append(counts4, icount4);
      years4 = append(years4, i);        
      icount4=0;
      datenow = datenow2;
    }
  } 
  dronebar2.setData(years4);
  dronebar2.setData(counts4);
}



public void fillyandc5()
{
  years5 = new float[186];  //initalise array
  counts5 = new float[186]; //initialise array
  String datenow = table.getString(1, 0);
  datenow = datenow.substring(3, 5);
  int value=1;

  for (int i =1; i<table.getRowCount()-1; i++) 
  { 
    if (value<186) {
      String datenow2=table.getString(i, 0);
      datenow2 = datenow2.substring(3, 5);
      if (datenow.equals(datenow2))
      {
        if (table.getString(i, "suicide").equals("1"))
        {
          if (Float.isNaN(table.getFloat(i, "nkill"))==false)
          {
            icount5 = icount5+table.getFloat(i, "nkill") ;
          }
        }
      } else
      {
        counts5[value] = icount5;
        years5[value] =  value;        
        icount5=0;
        value=value+1;
        datenow = datenow2;
      }
    }
  }
  //printArray(counts5);
  //suicidemonth.setData(counts5, years5);
}
  public void settings() {  size(1024, 768); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Project_29_4_final" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
