package design.pen.initial.entities;

public class Ink {

    String color;
    Type type;

    public Ink(String color, Type type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Type getInkType() {
        return type;
    }

    public void setInkType(Type type) {
        this.type = type;
    }

}
