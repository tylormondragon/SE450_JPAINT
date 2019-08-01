package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;

public class ShapeCopy implements ICommand {
    private ShapeList shapeList;
    private IApplicationState applicationState;
    private ShapeConfig shapeConfig;

    public ShapeCopy(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeConfig = shapeConfig;
        this.shapeList = shapeList;
    }

    public void run() {
        shapeList.getCopiedShapesList().clear();
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shapeList.addCopiedList(shape);
        }
        System.out.printf("Added %d shapes to clipboard", shapeList.getSelectedShapesList().size());
    }
}
