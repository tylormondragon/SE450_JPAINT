package view.gui;

import controller.Point;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorSingleton;
import view.interfaces.IDrawShapes;

import java.awt.*;

public class DrawTriangle implements IDrawShapes {
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
    private int[] x = new int[3];
    private int[] y = new int[3];

    public DrawTriangle(ShapeConfig shapeConfig) {
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
        this.x[0] = shapeConfig.getAdjustedStartPoint().getX();
        this.x[1] = shapeConfig.getAdjustedEndPoint().getX();
        this.x[2] = shapeConfig.getAdjustedStartPoint().getX();

        this.y[0] = shapeConfig.getAdjustedStartPoint().getY();
        this.y[1] = shapeConfig.getAdjustedEndPoint().getY();
        this.y[2] = shapeConfig.getAdjustedEndPoint().getY();
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(shadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(9));
            g.drawPolygon(x, y, 3);
        }
        else if(shadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(primaryColor);
            g.fillPolygon(x, y, 3);
        }
        else if(shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(10));
            g.drawPolygon(x, y, 3);
            g.setColor(secondaryColor);
            g.fillPolygon(x, y, 3);
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

    public ShapeConfig getShapeConfiguration() {
        return shapeConfig;
    }

    @Override
    public void addX(int dx) {
        this.x[0] = adjustedStartPoint.getX() + dx;
        this.x[1] = adjustedEndPoint.getX() + dx;
        this.x[2] = adjustedStartPoint.getX() + dx;
        adjustedStartPoint.setX(adjustedStartPoint.getX() + dx);
        adjustedEndPoint.setX(adjustedEndPoint.getX() + dx);
    }

    @Override
    public void addY(int dy) {
        this.y[0] = adjustedStartPoint.getY() + dy;
        this.y[1] = adjustedEndPoint.getY() + dy;
        this.y[2] = adjustedEndPoint.getY() + dy;
        adjustedStartPoint.setY(adjustedStartPoint.getY() + dy);
        adjustedEndPoint.setY(adjustedEndPoint.getY() + dy);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
