package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;

    public Turtle(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction.getDirection();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void execute(char command) {
        if (command == 'L') {
            direction.leftRotate(this);
        } else if (command == 'R') {
            direction.rightRotate(this);
        } else if (command == 'F'){
            direction.moveForward(this);
        }
    }
}
