void fillyandc()
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