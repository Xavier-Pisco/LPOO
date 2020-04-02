package com.aor.refactoring.example5;

public class South implements Direction {
    @Override
    public char getDirection() {
        return 'S';
    }

    @Override
    public void leftRotate(Turtle turtle) {
        turtle.setDirection(new East());
    }

    @Override
    public void rightRotate(Turtle turtle) {
        turtle.setDirection(new West());
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setRow(turtle.getRow() + 1);
    }
}
