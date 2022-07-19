package design.pen.initial.strategies;

import design.pen.initial.entities.Ink;
import design.pen.initial.entities.Nib;

import java.io.PrintWriter;

public class GelWriteBehaviourStrategy implements WriteBehaviourStrategy {

    @Override
    public void write(PrintWriter writer, Ink ink, Nib nib) {
        try {
            writer.println("Writing smooth with a GEL Pen");
            writer.flush();
            writer.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
