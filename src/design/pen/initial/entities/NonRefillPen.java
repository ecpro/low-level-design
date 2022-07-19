package design.pen.initial.entities;

import design.pen.initial.strategies.WriteBehaviourStrategy;

public class NonRefillPen extends Pen {

    private Ink ink;
    private Nib nib;

    public NonRefillPen(String brandName, String companyName, Type penType, WriteBehaviourStrategy writeBehaviourStrategy, Boolean isReusable, Ink ink, Nib nib) {
        super(brandName, companyName, penType, writeBehaviourStrategy, isReusable);
        this.ink = ink;
        this.nib = nib;
    }

    public void changeNib(Nib nib) {
        if(!isReusable() || !nib.nibType.equals(this.getPenType())) throw new IllegalArgumentException("Pen and Nib type must of same type");
        this.nib = nib;
    }

    public void changeInk(Ink ink) {
        if(!isReusable() || !ink.type.equals(this.getPenType())) throw new IllegalArgumentException("Pen and Ink type must of same type");
        this.ink = ink;
    }

    @Override
    public String getColor() {
        return ink.getColor();
    }

    @Override
    public Nib getNib() {
        return nib;
    }

    @Override
    public Ink getInk() {
        return ink;
    }

    public static class Builder extends PenBuilder {
        protected Ink ink;
        protected Nib nib;

        public Builder addInk(Ink ink) {
            this.ink = ink;
            return this;
        }

        public Builder addNib(Nib nib) {
            this.nib = nib;
            return this;
        }

        public NonRefillPen build() {
            // add validations here
            return new NonRefillPen(this.brandName, this.companyName, this.penType, this.writeBehaviourStrategy, this.isReusable, this.ink, this.nib);
        }
    }
}
