package design.pen.strategies;

import design.pen.entities.Ink;
import design.pen.entities.Nib;

import java.io.PrintWriter;
import java.io.Writer;

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
