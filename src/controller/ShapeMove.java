package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoRedo;
import view.interfaces.IDrawShapes;

public class ShapeMove implements ICommand, IUndoRedo {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeList selectedShapeList;
    private ShapeConfig shapeConfig;
    private IDrawShapes oldShape;
    private int dx;
    private int dy;

    public ShapeMove(IApplicationState applicationState, ShapeList shapeList, ShapeList selectedShapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.shapeConfig = shapeConfig;
    }

    public void run() {
        dx = applicationState.getEndPoint().getX() - applicationState.getStartPoint().getX();
        dy = applicationState.getEndPoint().getY() - applicationState.getStartPoint().getY();

        for(IDrawShapes selected: shapeList.getSelectedShapesList()) {
            shapeList.remove(selected);
            selected.addX(dx);
            selected.addY(dy);
            shapeList.add(selected);
        }
    }

    public void redo() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shape.lessX(dx);
            shape.lessY(dy);
            shapeList.add(shape);
        }
    }

    public void undo() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shapeList.add(shape);
        }
    }
}
