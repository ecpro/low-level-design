package design.pen.initial;

import design.pen.initial.entities.Ink;
import design.pen.initial.entities.Nib;
import design.pen.initial.entities.RefillPen;
import design.pen.initial.entities.Type;
import design.pen.initial.strategies.GelWriteBehaviourStrategy;

import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) {

        RefillPen.Builder builder  = new RefillPen.Builder()
                .addBrandName("WriteMeter")
                .addCompanyName("Reynolds")
                .addPenType(Type.GEL)
                .addIsReusable(Boolean.TRUE)
                .addWriteStrategy(new GelWriteBehaviourStrategy())
                .getConcrete();

        Ink ink = new Ink("RED", Type.GEL);
        Nib nib = new Nib(Type.GEL);

        RefillPen gelPen = builder
                .addRefil(Type.GEL, ink, nib)
                .build();



        System.out.println(String.format("%s %s is isReusable ? %s %s Pen (color) %s",
                gelPen.getCompanyName(),
                gelPen.getBrandName(),
                gelPen.isReusable(),
                gelPen.getPenType(),
                gelPen.getColor()));

        gelPen.write(new PrintWriter(System.out));


    }
}
