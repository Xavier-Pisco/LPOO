package com.aor.refactoring.example5;

public class West implements Direction {
    @Override
    public char getDirection() {
        return 'W';
    }

    @Override
    public void leftRotate(Turtle turtle) {
        turtle.setDirection(new South());
    }

    @Override
    public void rightRotate(Turtle turtle) {
        turtle.setDirection(new North());
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setColumn(turtle.getColumn() - 1);
    }
}
