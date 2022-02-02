void circleForDates(int localRow)
{
  circlex = table.getFloat(localRow, "longitude");
  circley = table.getFloat(localRow, "latitude"); 
  float nKill = table.getInt(localRow, "nkill");
  if(Float.isNaN(circlex) || Float.isNaN(circley)  || Float.isNaN(nKill) )
    return;
    
  circlex = map(circlex, 60.8746, 77.8931, 341, 1024);
  circley = map(circley, 23.6948, 37.0837, 641, 35);

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

void dronecircle(int localRow) {
  if (localRow<drone.getRowCount())
  {
    circlex2 = drone.getFloat(localRow, 6);   
    circley2 = drone.getFloat(localRow, 7);
    float nKill = drone.getInt(localRow, 2);
    
    if(Float.isNaN(circlex2) || Float.isNaN(circley2) || Float.isNaN(circlesize2))
      return;
    
    circlesize2 = map(nKill, 0, 157, 5, 50);
    circlex2 = map(circlex2, 60.8746, 77.8931, 341, 1024);
    circley2 = map(circley2, 23.6948, 37.0837, 641, 35);
    if (Drone == true)
    {
      _list_circles[localRow] = new CirclePoint(circlex,circley,circlesize,circlesize,0, 0, 0,0, 0, 0);

    }
  }
}