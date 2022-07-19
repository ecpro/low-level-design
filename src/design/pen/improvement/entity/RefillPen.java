package design.pen.improvement.entity;

import design.pen.improvement.entity.Refill;

public class RefillPen extends Pen {

    private Refill refill;

    public RefillPen(Type type) {
        super(type);
    }

    @Override
    public void write() {
        writeBehaviourStrategy.write();
    }

    @Override
    String getColor() {
        return null;
    }

    public Refill getRefill() {
        return refill;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
    }
}
