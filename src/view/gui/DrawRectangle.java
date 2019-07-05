package view.gui;

import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import controller.Point;
import model.dialogs.ColorSingleton;
import view.interfaces.IDrawShapes;

import java.awt.*;

public class DrawRectangle implements IDrawShapes {
    private ShapeConfig shapeConfig;
    private ShapeShadingType shadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private int width;
    private int height;
    private Point adjustedStartPoint;
    private Point adjustedEndPoint;
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;


    public DrawRectangle(ShapeConfig shapeConfig) {
        this.shapeConfig = shapeConfig;
        this.shadingType = shadingType;
        this.primaryColor = ColorSingleton.getColor(shapeConfig.getPrimaryShapeColor());
        this.secondaryColor = ColorSingleton.getColor(shapeConfig.getSecondaryShapeColor());
        this.width = shapeConfig.getWidth();
        this.height = shapeConfig.getHeight();
        this.adjustedStartPoint = shapeConfig.getAdjustedStartPoint();
        this.adjustedEndPoint = shapeConfig.getAdjustedEndPoint();
        this.startPoint = shapeConfig.getStartPoint();
        this.endPoint = shapeConfig.getEndPoint();
        this.shapeType = shapeType;
    }

    public void paint(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        if(shadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            graph.setStroke(new BasicStroke(8));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        }
        else if(shadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(primaryColor);
            graph.setStroke(new BasicStroke(8));
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        }
        else if(shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            graph.setStroke(new BasicStroke(8));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
            g.setColor(secondaryColor);
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setAdjustedStartPoint(Point adjustedStartPoint) {
        this.adjustedStartPoint = adjustedStartPoint;
    }

    public void setAdjustedEndPoint(Point adjustedEndPoint) {
        this.adjustedEndPoint = adjustedEndPoint;
    }

    public Point getAdjustedStartPoint() {
        return adjustedStartPoint;
    }

    public Point getAdjustedEndPoint() {
        return adjustedEndPoint;
    }

    public void addX(int dx) {
        adjustedStartPoint.setX(adjustedStartPoint.getX() + dx);
        adjustedEndPoint.setX(adjustedEndPoint.getX() + dx);
    }

    public void addY(int dy) {
        adjustedStartPoint.setY(adjustedStartPoint.getY() + dy);
        adjustedEndPoint.setY(adjustedEndPoint.getY() + dy);
    }

    public ShapeConfig getShapeConfiguration() {
        return shapeConfig;
    }


}
