package design.pen.improvement;

import design.pen.improvement.entity.*;
import design.pen.improvement.strategies.TrimaxWriteBehaviour;
import design.pen.improvement.strategies.WriteBehaviourStrategy;

public class Client {
    public static void main(String[] args) {

        ApplePen applePen = new ApplePen.Builder()
                .addBrandName("Apple Pen Second Generation")
                .addCompanyName("Apple")
                .addTip(new Tip())
                .addWriteBehaviour(new WriteBehaviourStrategy() {
                    @Override
                    public void write() {
                        System.out.println("Writing with Apple Pen");
                    }
                })
                .build();


        RefillPen trimax = new RefillPen(Type.GEL);
        ReynoldsTimaxRefil refill = new ReynoldsTimaxRefil();
        trimax.setRefill(refill);
        trimax.setBrandName("Trimax");
        trimax.setCompanyName("Reynolds");
        trimax.setWriteBehaviourStrategy(new TrimaxWriteBehaviour(refill));

        applePen.write();
        System.out.println(refill.getRefillStatus());
        trimax.write();
        System.out.println(refill.getRefillStatus());

    }
}
