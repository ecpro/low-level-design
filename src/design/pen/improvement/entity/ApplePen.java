package design.pen.improvement.entity;

import design.pen.improvement.interfaces.ReTipable;
import design.pen.improvement.strategies.WriteBehaviourStrategy;

public class ApplePen extends Pen implements ReTipable {

    private Tip tip;

    public ApplePen(Type type) {
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

    @Override
    public void changeTip(Tip tip) {

    }



    public static class Builder {
        private String brandName;
        private String companyName;
        private Type type;
        private Tip tip;

        private WriteBehaviourStrategy writeBehaviourStrategy;

        public Builder addBrandName(String name) {
            this.brandName = name;
            return this;
        }

        public Builder addCompanyName(String name) {
            this.companyName = name;
            return this;
        }

        public Builder addTip(Tip tip) {
            this.tip = tip;
            return this;
        }

        public Builder addWriteBehaviour(WriteBehaviourStrategy writeBehaviourStrategy) {
            this.writeBehaviourStrategy = writeBehaviourStrategy;
            return this;
        }

        public ApplePen build() {
            ApplePen applePen = new ApplePen(this.type);
            applePen.setBrandName(this.brandName);
            applePen.setCompanyName(this.companyName);
            applePen.setWriteBehaviourStrategy(this.writeBehaviourStrategy);
            return applePen;
        }
    }
}
