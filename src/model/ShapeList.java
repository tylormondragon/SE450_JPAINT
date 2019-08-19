package model;

import controller.DrawShapes;
import view.interfaces.IDrawShapes;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IDrawShapes> shapesList;
    private final ArrayList<IDrawShapes> selectedShapesList;
    private final ArrayList<IDrawShapes> copiedShapesList;
    private final ArrayList<IDrawShapes> tempShapeList;
    private DrawShapes drawShapes;

    public ShapeList(DrawShapes drawShapes) {
        this.drawShapes = drawShapes;
        shapesList = new ArrayList<>();
        selectedShapesList = new ArrayList<>();
        copiedShapesList = new ArrayList<>();
        tempShapeList = new ArrayList<>();
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
        drawShapes.draw(this);
    }

    public void addSelectedList(IDrawShapes shape) {
        selectedShapesList.add(shape);
        drawShapes.draw(this);
    }

    public void addTempShapeList(IDrawShapes shape) {
        tempShapeList.add(shape);
        drawShapes.draw(this);
    }

    //Method to retrieve the shape list
    public ArrayList<IDrawShapes> getShapesList() {
        return shapesList;
    }

    public ArrayList<IDrawShapes> getSelectedShapesList() {
        return selectedShapesList;
    }

    public ArrayList<IDrawShapes> getTempShapeList() {return selectedShapesList;}

    public void addCopiedList(IDrawShapes shape) {copiedShapesList.add(shape); }

    public ArrayList<IDrawShapes> getCopiedShapesList() { return copiedShapesList;}

}
