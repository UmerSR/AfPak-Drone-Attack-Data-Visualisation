public class CirclePoint {public float PosX;
  public float PosY;
  public float SizX;
  public float SizY;
  public int FillColorR;
  public int FillColorG;
  public int FillColorB;
  public int StrokeColorR;
  public int StrokeColorG;
  public int StrokeColorB;
  
  public CirclePoint(float x,float y,float w,float h,int fr,int fg,int fb,int sr,int sg,int sb)
  {
    PosX = x;
    PosY = y;
    SizX = w;
    SizY = h;
    FillColorR = fr;
    FillColorG = fg;
    FillColorB = fb;
    StrokeColorR = sr;
    StrokeColorG = sg;
    StrokeColorB = sb;
  }
}