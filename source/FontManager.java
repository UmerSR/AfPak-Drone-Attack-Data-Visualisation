import processing.core.PApplet;
import processing.core.PFont;

public class FontManager {

  private static FontManager _instance = null;

  private static PFont labelFont;
  private static PFont miniLabelFont;

  private static PFont headlineFont;

  private static PFont smallLabelFont;
  private static PFont largeNumberLabelFont;
  
  protected FontManager(PApplet p) {
    smallLabelFont = p.createFont("sans-serif", 12);
    labelFont = p.createFont("sans-serif", 20);
    miniLabelFont = p.createFont("sans-serif", 25);
    headlineFont = p.createFont("sans-serif", 40);
    largeNumberLabelFont = p.createFont("sans-serif", 60);
  }

  // Neat trick: FontManager needs PApplet instance in order to load fonts.
  // Thus, optional parameter has to be provided on first initialization.
  public static FontManager getInstance(PApplet... papplets) {
    if (_instance == null) {
      if (papplets.length > 0) {
        _instance = new FontManager(papplets[0]);
      } else {
        throw new IllegalArgumentException("First getInstance call needs PApplet");
      }
    }
    return _instance;
  }

  public PFont getLargeNumberFont() {
    return largeNumberLabelFont;
  }
  
  public PFont getSmallLabelFont() {
    return smallLabelFont;
  }
  
  public PFont getLabelFont() {
    return labelFont;
  }
  public PFont getMiniLabelFont() {
    return miniLabelFont;
  }

  public PFont getHeadlineFont() {
    return headlineFont;
  }
}