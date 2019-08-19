package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoRedo;
import view.interfaces.IDrawShapes;

import java.util.ArrayList;


public class ShapePaste implements ICommand, IUndoRedo {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private IDrawShapes shapes;
    private IDrawShapes oldShape;
    private ShapeConfig shapeConfig;
    private ArrayList<IDrawShapes> tempList;

    public ShapePaste(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        tempList = new ArrayList<>();
        for(IDrawShapes shape: shapeList.getCopiedShapesList()) {
            oldShape = shape;
            ShapeCreate newShape = new ShapeCreate(applicationState, shapeList, shape.getShapeConfiguration());
            shapes = newShape.shapeFactory.createShape(shape.getShapeConfiguration());
            shapes.setAdjustedStartPoint(shape.getAdjustedStartPoint().getX() + 80, shape.getAdjustedStartPoint().getY() + 80);
            shapes.setAdjustedEndPoint(shape.getAdjustedEndPoint().getX() + 80, shape.getAdjustedEndPoint().getY() + 80);
            shapeList.add(shapes);
            tempList.add(shapes);
        }
        CommandHistory.add(this);
    }

    public void redo() {
        for(IDrawShapes shape: tempList) {
            shapeList.add(shape);
        }
    }

    public void undo() {
        shapeList.remove(shapes);
    }
}
