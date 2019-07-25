package model;

import controller.DrawShapes;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IDrawShapes> shapesList;
    private final ArrayList<IDrawShapes> selectedShapesList;
    private DrawShapes drawShapes;
    private PaintCanvasBase paintCanvas;

    public ShapeList(DrawShapes drawShapes) {
        this.drawShapes = drawShapes;
        shapesList = new ArrayList<>();
        selectedShapesList = new ArrayList<>();
    }

    //Method to add a shape to the shape list
    public void add(IDrawShapes shape) {
        shapesList.add(shape);
        drawShapes.draw(this);

    }

    //Method to remove a shape from the shape list
    public void remove(IDrawShapes shape) {
        shapesList.remove(shape);
        drawShapes.draw(this);
    }

    public void clearSelectedList() {
        selectedShapesList.clear();
    }

    public void addSelectedList(IDrawShapes shape) {
        selectedShapesList.add(shape);
    }

    //Method to retrieve the shape list
    public ArrayList<IDrawShapes> getShapesList() {
        return shapesList;
    }

    public ArrayList<IDrawShapes> getSelectedShapesList() {
        return selectedShapesList;
    }


}
