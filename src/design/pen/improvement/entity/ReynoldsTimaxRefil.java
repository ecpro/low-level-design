package design.pen.improvement.entity;

import design.pen.improvement.interfaces.ReInkable;

public class ReynoldsTimaxRefil extends Refill implements ReInkable {

    private String refillStatus = "FULL";

    @Override
    public void changeInk(Ink ink) {
            this.ink = ink;
    }

    public String getRefillStatus() {
        return refillStatus;
    }

    public void setRefillStatus(String refillStatus) {
        this.refillStatus = refillStatus;
    }
}
