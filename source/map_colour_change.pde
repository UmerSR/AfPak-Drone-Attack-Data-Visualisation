void colourchange()
{  
  fill(lerpColor(mincol, maxcol, norm(fatat, 0, totalcount/10 )));
  map.draw(3); 
}