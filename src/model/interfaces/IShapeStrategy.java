package model.interfaces;

import model.ShapeConfig;

public interface IShapeStrategy {
    void drawFilled(ShapeConfig shapeConfig);
    void drawOutline(ShapeConfig shapeConfig);
    void drawFilledOutlined(ShapeConfig shapeConfig);
}
