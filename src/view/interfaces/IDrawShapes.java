package view.interfaces;

import model.ShapeConfig;
import controller.Point;

public interface IDrawShapes {
    void paint();

    Point getStartPoint();

    Point getEndPoint();

    void setAdjustedStartPoint(Point startPoint);

    void setAdjustedEndPoint(Point adjustedEnd);

    Point getAdjustedStartPoint();

    Point getAdjustedEndPoint();

    ShapeConfig getShapeConfiguration();

    int getWidth();

    int getHeight();

}
