package view.gui;

import controller.Point;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorSingleton;
import view.interfaces.IDrawShapes;

import java.awt.*;
import java.util.ArrayList;

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
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(shadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(9));
            g.drawPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                    new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()},
                    3);
        }
        else if(shadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(primaryColor);
            g.fillPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                    new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()},
                    3);
        }
        else if(shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(10));
            g.drawPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                    new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()}, 3);
            g.setColor(secondaryColor);
            g.fillPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                    new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()}, 3);
        }
    }

    public void drawOutline(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(shadingType.equals(ShapeShadingType.OUTLINE) || shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            g2.setStroke(stroke);
            g.setColor(Color.BLACK);
            g.drawPolygon(new int[]{adjustedStartPoint.getX() - 10, adjustedEndPoint.getX() + 30, adjustedStartPoint.getX() - 10},
                    new int[]{adjustedStartPoint.getY() - 20, adjustedEndPoint.getY() + 10, adjustedEndPoint.getY() + 10}, 3);
        }
        else {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            g2.setStroke(stroke);
            g.setColor(Color.BLACK);
            g.drawPolygon(new int[]{adjustedStartPoint.getX() - 5, adjustedEndPoint.getX() + 20, adjustedStartPoint.getX() - 5},
                    new int[]{adjustedStartPoint.getY() - 15, adjustedEndPoint.getY() + 5, adjustedEndPoint.getY() + 5}, 3);
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

    @Override
    public void addX(int dx) {
        adjustedStartPoint.setX(adjustedStartPoint.getX() + dx);
        adjustedEndPoint.setX(adjustedEndPoint.getX() + dx);
        startPoint.setX(startPoint.getX() + dx);
        endPoint.setY(endPoint.getX() + dx);
    }

    @Override
    public void addY(int dy) {
        adjustedStartPoint.setY(adjustedStartPoint.getY() + dy);
        adjustedEndPoint.setY(adjustedEndPoint.getY() + dy);
        startPoint.setY(startPoint.getY() + dy);
        endPoint.setY(endPoint.getY() + dy);
    }

    @Override
    public void lessX(int dx) {
        adjustedStartPoint.setX(adjustedStartPoint.getX() - dx);
        adjustedEndPoint.setX(adjustedEndPoint.getX() - dx);
        startPoint.setX(startPoint.getX() - dx);
        endPoint.setY(endPoint.getX() - dx);
    }

    @Override
    public void lessY(int dy) {
        adjustedStartPoint.setY(adjustedStartPoint.getY() - dy);
        adjustedEndPoint.setY(adjustedEndPoint.getY() - dy);
        startPoint.setY(startPoint.getY() - dy);
        endPoint.setY(endPoint.getY() - dy);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
