package design.bird.species;

import design.bird.types.Bird;
import design.bird.types.FlyingBird;
import design.bird.flyingPatterns.FlyingPattern;

public class Sparrow implements Bird, FlyingBird {

    private FlyingPattern flyingPattern;

    public Sparrow(FlyingPattern flyingPattern) {
        this.flyingPattern = flyingPattern;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void fly() {
        flyingPattern.makeFly();
    }
}
