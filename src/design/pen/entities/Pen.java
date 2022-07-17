package design.pen.entities;

import design.pen.strategies.WriteBehaviourStrategy;

import java.io.PrintWriter;
import java.io.Writer;

public abstract class Pen {

    private final String brandName;
    private final String companyName;
    private final Type penType;

    /*
     1. Fountains pens don't have a refill but we can change the nib and ink - reusable
     2. Use and throw GEL pens don't have a refill - ink and nib is part of pen - non-reusable
     */
    private final boolean isReusable;

    private final WriteBehaviourStrategy writeBehaviourStrategy;

    public Pen(String brandName, String companyName, Type penType, WriteBehaviourStrategy writeBehaviourStrategy, Boolean isReusable) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.penType = penType;
        this.writeBehaviourStrategy = writeBehaviourStrategy;
        this.isReusable = isReusable;
    }

    public void write(PrintWriter writer) {
        this.writeBehaviourStrategy.write(writer, getInk(), getNib());
    }

    public abstract String getColor();

    public abstract Nib getNib();

    public abstract Ink getInk();

    public boolean isReusable() {
        return isReusable;
    }

    public String getBrandName() {
        return brandName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public Type getPenType() {
        return penType;
    }

    public static abstract class PenBuilder {

        protected String brandName;
        protected String companyName;
        protected Type penType;
        protected WriteBehaviourStrategy writeBehaviourStrategy;

        protected boolean isReusable;

        public <T extends PenBuilder> T getConcrete() {
            return (T) this;
        }

        public PenBuilder addBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public PenBuilder addCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public PenBuilder addPenType(Type penType) {
            this.penType = penType;
            return this;
        }

        public PenBuilder addIsReusable(Boolean isReusable) {
            this.isReusable = isReusable;
            return this;
        }

        public PenBuilder addWriteStrategy(WriteBehaviourStrategy writeBehaviourStrategy) {
            this.writeBehaviourStrategy = writeBehaviourStrategy;
            return this;
        }

    }
}
