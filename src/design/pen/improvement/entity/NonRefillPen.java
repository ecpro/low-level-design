package design.pen.improvement.entity;

public class NonRefillPen extends Pen {

    protected Ink ink;
    protected Tip tip;

    public NonRefillPen(Type type) {
        super(type);
    }

    @Override
    public void write() {

    }

    @Override
    String getColor() {
        return ink.getColor();
    }
}
