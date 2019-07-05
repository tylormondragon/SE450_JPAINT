package view.interfaces;

import model.ShapeConfig;

import java.awt.*;

public interface IDrawShapes {
    void paint(Graphics g);

    Point getStartPoint();

    Point getEndPoint();

    void addX(int x);

    void addY(int y);

    void setAdjustedStart(Point adjustedStart);

    void setAdjustedEnd(Point adjustedEnd);

    Point getAdjustedStart();

    Point getAdjustedEnd();

    ShapeConfig getShapeConfiguration();

    int getWidth();

    int getHeight();

}
