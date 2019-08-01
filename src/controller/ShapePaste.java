package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;

import java.awt.*;
import java.util.ArrayList;


public class ShapePaste implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private IDrawShapes copiedShape;
    private ShapeConfig shapeConfig;
    private final ArrayList<IDrawShapes> temp = new ArrayList<>();

    public ShapePaste(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        for(IDrawShapes shape: shapeList.getCopiedShapesList()) {
            copiedShape = shape;

            copiedShape.setAdjustedStartPoint(shape.getAdjustedStartPoint().getX() + 80, shape.getAdjustedStartPoint().getY());
            copiedShape.setAdjustedStartPoint(shape.getAdjustedStartPoint().getX(), shape.getAdjustedStartPoint().getY() + 80);
            ShapeCreate newShape = new ShapeCreate(applicationState, shapeList, copiedShape.getShapeConfiguration());
            shapeList.add(newShape.shapeFactory.createShape(copiedShape.getShapeConfiguration()));
        }
    }
}
