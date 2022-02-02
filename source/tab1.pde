void addButtonsToScreen()
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

void SetMainButtons(boolean visibility)
{
  if (visibility)
    _cp5_main_buttons.show();
  else
    _cp5_main_buttons.hide();
}

void updateStats()
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

void tab1()
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
  text(int(totaldrone), 225, 235);
  text(int(totalsuicide), 225, 325);
  text(int(totalgtd), 160, 415);

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
  text(int(deathcount), 107, 209);
  text(int(wounded), 114, 234);
  text(int(suicidedeath), 107, 299);
  text(int(suicidewound), 114, 324);
  text(int(deathcount2), 107, baseSize + 25+4);
  text(int(wounded2), 107, baseSize + 50+4);

  text(int(exp), 150+10, baseSize + 75+4);
  text(int(assault), 175+10, baseSize + 100+4);
  text(int(hostage), 180+10, baseSize + 125+4);
  text(int(assassination), 173+10, baseSize + 150+4);
  text(int(infra), 253+10, baseSize + 175+4);

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