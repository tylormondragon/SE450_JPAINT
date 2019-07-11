package model;

import view.gui.DrawEllipse;
import view.gui.DrawRectangle;
import view.gui.DrawTriangle;
import view.interfaces.IDrawShapes;

import java.awt.*;

public class ShapeFactory {
    public IDrawShapes createShape(ShapeConfig shapeConfig) {
        ShapeType shapeType = shapeConfig.getShapeType();
        IDrawShapes shape = null;

        if(shapeType.equals(ShapeType.RECTANGLE)) {
            shape = new DrawRectangle(shapeConfig);
        }
        if(shapeType.equals(ShapeType.ELLIPSE)) {
            shape = new DrawEllipse(shapeConfig);
        }
        if(shapeType.equals(ShapeType.TRIANGLE)) {
            shape = new DrawTriangle(shapeConfig);
        }
        return shape;
    }
}
