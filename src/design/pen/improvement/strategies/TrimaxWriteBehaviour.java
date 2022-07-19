package design.pen.improvement.strategies;

import design.pen.improvement.entity.ReynoldsTimaxRefil;

public class TrimaxWriteBehaviour implements WriteBehaviourStrategy {

    private ReynoldsTimaxRefil refil;

    public TrimaxWriteBehaviour(ReynoldsTimaxRefil refil) {
        this.refil = refil;
    }

    @Override
    public void write() {
        System.out.println("Writing with Reynolds Trimax");
        refil.setRefillStatus("HALF");
    }
}
