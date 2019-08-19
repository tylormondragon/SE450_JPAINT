package view.interfaces;

import model.ShapeConfig;
import controller.Point;

import java.awt.*;

public interface IDrawShapes {
    void paint(Graphics g);

    void drawOutline(Graphics g);

    Point getStartPoint();

    Point getEndPoint();

    void setAdjustedStartPoint(int x, int y);

    void setAdjustedEndPoint(int x, int y);

    void addX(int dx);

    void addY(int dy);

    void lessX(int dx);
    void lessY(int dy);

    Point getAdjustedStartPoint();

    Point getAdjustedEndPoint();

    ShapeConfig getShapeConfiguration();

    int getWidth();

    int getHeight();
}
