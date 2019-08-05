package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;


public class ShapePaste implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private IDrawShapes shapes;
    private ShapeConfig shapeConfig;

    public ShapePaste(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        for(IDrawShapes shape: shapeList.getCopiedShapesList()) {
            ShapeCreate newShape = new ShapeCreate(applicationState, shapeList, shape.getShapeConfiguration());
            shapes = newShape.shapeFactory.createShape(shape.getShapeConfiguration());
            shapes.setAdjustedStartPoint(shape.getAdjustedStartPoint().getX() + 80, shape.getAdjustedStartPoint().getY() + 80);
            shapes.setAdjustedEndPoint(shape.getAdjustedEndPoint().getX() + 80, shape.getAdjustedEndPoint().getY() + 80);
            shapeList.add(shapes);
        }

    }
}
