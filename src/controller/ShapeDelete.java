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
    private ArrayList<IDrawShapes> selectedShapes;

    public ShapeDelete(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void run() {
        selectedShapes = shapeList.getSelectedShapesList();
        System.out.println("Selected Shapes Deleted");
        for(IDrawShapes shape: selectedShapes) {
            shapeList.remove(shape);
            System.out.println(shapeList.getShapesList().size());
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        System.out.println("Undo Delete Executed");
        for(IDrawShapes shape: selectedShapes) {
            shapeList.add(shape);
        }
    }

    @Override
    public void redo() {
        System.out.println("Redo Delete Executed");
        for(IDrawShapes shape: selectedShapes) {
            shapeList.remove(shape);
        }
    }
}
