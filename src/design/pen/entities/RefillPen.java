package design.pen.entities;

import design.pen.strategies.WriteBehaviourStrategy;

public class RefillPen extends Pen {

    private Refil refil;

    public RefillPen(String brandName, String companyName, Type penType, WriteBehaviourStrategy writeBehaviourStrategy, Boolean isReusable, Refil refil) {
        super(brandName, companyName, penType, writeBehaviourStrategy, isReusable);
        this.refil = refil;
    }

    public void changeRefill(Refil refil) {
        if (isReusable() && refil.getRefilType().equals(this.refil.getRefilType())) {
            this.refil = refil;
        }
    }

    @Override
    public String getColor() {
        return refil.getColor();
    }

    @Override
    public Nib getNib() {
        return refil.getNib();
    }

    @Override
    public Ink getInk() {
        return refil.getInk();
    }

    public static class Builder extends PenBuilder {
        protected Refil refil;

        public Builder addRefil(Type type, Ink ink, Nib nib) {
            this.refil = new Refil(type, ink, nib);
            return this;
        }

        public Builder addRefil(Refil refil) {
            this.refil = refil;
            return this;
        }

        public RefillPen build() {
            return new RefillPen(this.brandName, this.companyName, this.penType, this.writeBehaviourStrategy, this.isReusable, this.refil);
        }
    }

}
