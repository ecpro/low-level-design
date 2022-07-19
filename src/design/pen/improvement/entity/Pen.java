package design.pen.improvement.entity;

import design.pen.improvement.strategies.WriteBehaviourStrategy;

public abstract class Pen {

    protected String brandName;
    protected String companyName;
    protected Type type;

    protected WriteBehaviourStrategy writeBehaviourStrategy;

    protected Pen(Type type){
        this.type = type;
    }

    public abstract void write();
    abstract String getColor();

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public WriteBehaviourStrategy getWriteBehaviourStrategy() {
        return writeBehaviourStrategy;
    }

    public void setWriteBehaviourStrategy(WriteBehaviourStrategy writeBehaviourStrategy) {
        this.writeBehaviourStrategy = writeBehaviourStrategy;
    }
}
