void drawmap()
{
  strokeWeight(0.5);
  background(backgroundImage);
  _cp5_main_buttons.draw();
  stroke(0);               
  fill(100, 220, 100);   
  map.draw();
}
void province()
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