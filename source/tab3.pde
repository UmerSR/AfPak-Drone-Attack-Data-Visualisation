void tab2()
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
      text(int(counts3[mouseyear-2])+" deaths", mouseX, 200); 
      text("Month : "+drone.getString(int(years3[mouseyear]), 0).substring(3, 10), mouseX, 225); 
      int mouseyear2 = floor(map(mouseX, 106, 878, 0, 98));
      text(int(counts4[mouseyear-2])+" deaths", mouseX, 650); 
      text("Month : "+drone.getString(int(years4[mouseyear]), 0).substring(3, 10), mouseX, 675); 
      strokeWeight(0.5);
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


void fillyandc3()
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

void fillyandc4()
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



void fillyandc5()
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