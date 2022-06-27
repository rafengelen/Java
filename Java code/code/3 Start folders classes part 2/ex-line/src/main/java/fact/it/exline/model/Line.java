package fact.it.exline.model;

public class Line {
    int thickness;
    int beginningX;
    int beginningY;
    int endX;
    int endY;

    public Line() {
        this.thickness = 1;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getBeginningX() {
        return beginningX;
    }

    public void setBeginningX(int beginningX) {
        this.beginningX = beginningX;
    }

    public int getBeginningY() {
        return beginningY;
    }

    public void setBeginningY(int beginningY) {
        this.beginningY = beginningY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void makeThinner(){
        thickness -= 1;
    }

    public void makeThicker(){
        thickness += 1;
    }

    public String showCharacteristics(){
        return "Line starts at (" + beginningX + "," + beginningY + "), line ends at (" + endX + ","+ endY + ") and the thickness is: " + thickness;
    }
}
