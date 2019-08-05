package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;

import java.awt.*;


public class ShapeSelect implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeList selectedShapeList;
    private ShapeConfig shapeConfig;
    private Graphics2D g;


    public ShapeSelect(IApplicationState applicationState, ShapeList shapeList, ShapeList selectedShapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        //todo: why is my
        shapeList.clearSelectedList();
        shapeConfig = applicationState.getCurrentShapeConfig();
        for (IDrawShapes shape : shapeList.getShapesList()) {
            if (shape.getAdjustedStartPoint().getX() < shapeConfig.getAdjustedStartPoint().getX() + shapeConfig.getWidth() &&
                    shape.getAdjustedStartPoint().getX() + shape.getWidth() > shapeConfig.getAdjustedStartPoint().getX() &&
                    shape.getAdjustedStartPoint().getY() < shapeConfig.getAdjustedStartPoint().getY() + shapeConfig.getHeight() &&
                    shape.getAdjustedStartPoint().getY() + shape.getHeight() > shapeConfig.getAdjustedStartPoint().getY()) {
                shapeList.addSelectedList(shape);
                System.out.println("Selected Shape " + shape.toString());
            }
        }

    }
}
