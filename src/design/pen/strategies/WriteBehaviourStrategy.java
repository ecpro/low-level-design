package design.pen.strategies;

import design.pen.entities.Ink;
import design.pen.entities.Nib;

import java.io.PrintWriter;
import java.io.Writer;

public interface WriteBehaviourStrategy {
    void write(PrintWriter writer, Ink ink, Nib nib); // Writing behaviour will depend upon the ink and the nib.
}
