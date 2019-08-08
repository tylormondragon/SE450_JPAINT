package model;

import controller.Point;
import model.dialogs.ColorSingleton;
import model.interfaces.IShapeStrategy;

import java.awt.*;

public class Shape {
    private ShapeConfig shapeConfig;
    private ShapeShadingType shadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private int width;
    private int height;
    private controller.Point adjustedStartPoint;
    private controller.Point adjustedEndPoint;
    private controller.Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private IShapeStrategy strategy;


    public Shape(ShapeConfig shapeConfig, IShapeStrategy shapeStrategy) {
        this.shapeConfig = shapeConfig;
        this.shadingType = shapeConfig.getShadingType();
        this.primaryColor = ColorSingleton.getColor(shapeConfig.getPrimaryShapeColor());
        this.secondaryColor = ColorSingleton.getColor(shapeConfig.getSecondaryShapeColor());
        this.width = shapeConfig.getWidth();
        this.height = shapeConfig.getHeight();
        this.adjustedStartPoint = shapeConfig.getAdjustedStartPoint();
        this.adjustedEndPoint = shapeConfig.getAdjustedEndPoint();
        this.startPoint = shapeConfig.getStartPoint();
        this.endPoint = shapeConfig.getEndPoint();
        this.shapeType = shapeConfig.getShapeType();
        this.strategy = shapeStrategy;
    }

    public void draw(IShapeStrategy shapeStrategy) {
        if (shapeStrategy.equals(ShapeShadingType.OUTLINE)){
            shapeStrategy.drawOutline(shapeConfig);
        } else if (shapeStrategy.equals(ShapeShadingType.FILLED_IN)) {
            shapeStrategy.drawFilled(shapeConfig);
        } else if (shapeStrategy.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            shapeStrategy.drawFilledOutlined(shapeConfig);
        }
    }

    public void addX(int dx) {
        adjustedStartPoint.setX(adjustedStartPoint.getX() + dx);
        adjustedEndPoint.setX(adjustedEndPoint.getX() + dx);
    }

    public void addY(int dy) {
        adjustedStartPoint.setY(adjustedStartPoint.getY() + dy);
        adjustedEndPoint.setY(adjustedEndPoint.getY() + dy);
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

    public void setAdjustedStartPoint(int x, int y) {
        this.adjustedStartPoint = new Point(x, y);
    }

    public void setAdjustedEndPoint(int x, int y) {
        this.adjustedEndPoint = new Point(x, y);
    }

    public Point getAdjustedStartPoint() {
        return adjustedStartPoint;
    }

    public Point getAdjustedEndPoint() {
        return adjustedEndPoint;
    }

    public ShapeConfig getShapeConfiguration() {
        return shapeConfig;
    }

}
