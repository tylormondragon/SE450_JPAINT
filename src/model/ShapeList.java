package model;

import view.interfaces.IDrawShapes;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IDrawShapes> shapesList;
    //Selected shapes list later todo: review this during refactor when we know about other design patterns

    //Constructor for my basic shape list
    public ShapeList() {
        shapesList = new ArrayList<IDrawShapes>();
    }

    //Method to add a shape to the shape list
    public void add(IDrawShapes shape) {
        shapesList.add(shape);
    }

    //Method to remove a shape from the shape list
    public void remove(IDrawShapes shape) {
        shapesList.remove(shape);
    }

    //Method to retrieve the shape list
    public ArrayList<IDrawShapes> getShapesList() {
        return shapesList;
    }
}
