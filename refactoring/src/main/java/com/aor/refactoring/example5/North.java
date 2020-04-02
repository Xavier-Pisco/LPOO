package com.aor.refactoring.example5;

public class North implements Direction {

    @Override
    public char getDirection() {
        return 'N';
    }

    @Override
    public void leftRotate(Turtle turtle) {
        turtle.setDirection(new West());
    }

    @Override
    public void rightRotate(Turtle turtle) {
        turtle.setDirection(new East());
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setRow(turtle.getRow() - 1);
    }
}
