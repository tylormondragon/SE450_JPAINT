package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;

public class ShapeDelete implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeConfig shapeConfig;

    public ShapeDelete(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shapeList.remove(shape);
            System.out.println(shapeList.getShapesList().size());
        }
    }
}
