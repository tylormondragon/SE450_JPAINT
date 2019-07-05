package model;

import view.gui.DrawRectangle;
import view.interfaces.IDrawShapes;

public class ShapeFactory {
    public IDrawShapes createShape(ShapeConfig shapeConfig) {
        ShapeType shapeType = shapeConfig.getShapeType();
        IDrawShapes shape = null;

        if(shapeType.equals(ShapeType.RECTANGLE)) {
            shape = new DrawRectangle(shapeConfig);
        }
        return shape;
    }
}
