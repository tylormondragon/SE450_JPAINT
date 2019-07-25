package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShapes;

public class ShapeSelect implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeList selectedShapeList;
    private ShapeConfig shapeConfig;


    public ShapeSelect(IApplicationState applicationState, ShapeList shapeList, ShapeList selectedShapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        shapeList.clearSelectedList();
        shapeConfig = applicationState.getCurrentShapeConfig();
        for (IDrawShapes shape : shapeList.getShapesList()) {
            if (shape.getAdjustedStartPoint().getX() < shapeConfig.getAdjustedStartPoint().getX() + shapeConfig.getWidth() &&
                    shape.getAdjustedStartPoint().getX() + shape.getWidth() > shapeConfig.getAdjustedStartPoint().getX() &&
                    shape.getAdjustedStartPoint().getY() < shapeConfig.getAdjustedStartPoint().getY() + shapeConfig.getHeight() &&
                    shape.getAdjustedStartPoint().getY() + shape.getHeight() > shapeConfig.getAdjustedStartPoint().getY()) {
                //if(shapeList.getSelectedShapesList().contains(shape)) continue;
                shapeList.addSelectedList(shape);
                System.out.println("Selected Shape " + shape.toString());
            }
        }
    }
}
