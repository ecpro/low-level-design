package design.pen.initial.strategies;

import design.pen.initial.entities.Ink;
import design.pen.initial.entities.Nib;

import java.io.PrintWriter;

public interface WriteBehaviourStrategy {
    void write(PrintWriter writer, Ink ink, Nib nib); // Writing behaviour will depend upon the ink and the nib.
}
