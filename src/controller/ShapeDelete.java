package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoRedo;
import view.interfaces.IDrawShapes;

import java.util.ArrayList;

public class ShapeDelete implements ICommand, IUndoRedo {
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private ShapeConfig shapeConfig;

    public ShapeDelete(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void run() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shapeList.remove(shape);
            System.out.println(shapeList.getShapesList().size());
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList()) {
            shapeList.add(shape);
        }
    }

    @Override
    public void redo() {
        for(IDrawShapes shape: shapeList.getSelectedShapesList() ) {
            shapeList.remove(shape);
        }
    }
}
