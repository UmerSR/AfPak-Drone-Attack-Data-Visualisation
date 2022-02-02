//import required libraries

import org.gicentre.geomap.*; 
import org.gicentre.utils.stat.*; 
import java.text.SimpleDateFormat; 
import java.util.*; 
import controlP5.*; 
import org.joda.time.DateTime; 
import org.joda.time.Seconds; 
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

  size(1024, 768);
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