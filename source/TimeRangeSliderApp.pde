//taken from http://tillnagel.com/2012/06/animated-time-range-slider/


TimeRangeSlider timeRangeSlider;


// Gets called each time the time ranger slider has changed, both by user interaction as well as by animation
void timeUpdated(DateTime startDateTime, DateTime endDateTime) {
  _slider_changed = true;

}


// Forwarding of key and mouse events

void keyPressed() {
  timeRangeSlider.onKeyPressed(key, keyCode);
}

void mouseMoved() {
  timeRangeSlider.onMoved(mouseX, mouseY);
}

void mouseDragged() {
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