package model;

import controller.DrawShapes;
import view.gui.PaintCanvas;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IDrawShapes> shapesList;
    private DrawShapes drawShapes;

    //Constructor for my basic shape list
    public ShapeList(DrawShapes drawShapes) {
        this.drawShapes = drawShapes;
        shapesList = new ArrayList<IDrawShapes>();
    }

    //Method to add a shape to the shape list
    public void add(IDrawShapes shape) {
        shapesList.add(shape);
        drawShapes.draw(this);

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
