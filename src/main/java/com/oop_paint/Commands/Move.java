package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Move implements Command{

    private Shape shape;
    private ShapeDTO data;
    private int oldX;
    private int oldY;

    public Move(ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
    }

    @Override
    public void undo() {
        shape.setX(this.oldX);
        shape.setY(this.oldY);
    }

    @Override
    public void redo() {
        shape.setX(data.x);
        shape.setY(data.y);
    }

    @Override
    public void execute() {
        oldX = shape.getX();
        oldY = shape.getY();
        shape.setX(data.x);
        shape.setY(data.y);
    }
}
