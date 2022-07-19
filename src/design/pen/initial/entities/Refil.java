package design.pen.initial.entities;

public class Refil {

    private Ink ink;
    private Nib nib;

    private Type refilType;

    public Refil() {

    }

    public Refil(Type refilType, Ink ink, Nib nib) {
        this.refilType = refilType;
        this.ink = ink;
        this.nib = nib;
    }

    String getColor() {
        return ink.getColor();
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Nib getNib() {
        return nib;
    }

    public void setNib(Nib nib) {
        this.nib = nib;
    }

    public Type getRefilType() {
        return refilType;
    }

    public void setRefilType(Type refilType) {
        this.refilType = refilType;
    }
}
