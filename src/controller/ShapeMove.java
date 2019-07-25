package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;

public class ShapeMove implements ICommand {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeList selectedShapeList;
    private ShapeConfig shapeConfig;

    public ShapeMove(IApplicationState applicationState, ShapeList shapeList, ShapeList selectedShapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        int dx = applicationState.getEndPoint().getX() - applicationState.getStartPoint().getX();
        int dy = applicationState.getEndPoint().getY() - applicationState.getStartPoint().getY();

        for(IDrawShapes selected: shapeList.getSelectedShapesList()) {
            shapeList.remove(selected);
            selected.addX(dx);
            selected.addY(dy);
            shapeList.add(selected);
        }
    }
}
