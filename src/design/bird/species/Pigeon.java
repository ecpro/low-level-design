package design.bird.species;

import design.bird.flyingPatterns.FlyingPattern;
import design.bird.types.Bird;
import design.bird.types.FlyingBird;

public class Pigeon implements Bird, FlyingBird {

    private FlyingPattern flyingPattern;

    public Pigeon(FlyingPattern flyingPattern) {
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
        this.flyingPattern.makeFly();
    }
}
