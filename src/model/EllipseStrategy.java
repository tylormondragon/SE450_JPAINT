package model;

import controller.Point;
import model.dialogs.ColorSingleton;
import model.interfaces.IShapeStrategy;

import java.awt.*;

public class EllipseStrategy implements IShapeStrategy {
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
    private Graphics g;
    private Graphics2D g2;

    public EllipseStrategy(ShapeConfig shapeConfig) {
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
        this.g = shapeConfig.getGraphics();
        this.g2 = shapeConfig.getGraphics2D();
    }

    public void drawFilled(ShapeConfig shapeConfig) {
        g.setColor(primaryColor);
        g.fillOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
    }

    public void drawOutline(ShapeConfig shapeConfig) {
        g.setColor(primaryColor);
        g2.setStroke(new BasicStroke(9));
        g.drawOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
    }

    public void drawFilledOutlined(ShapeConfig shapeConfig) {
        g.setColor(primaryColor);
        g2.setStroke(new BasicStroke(10));
        g.drawOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        g.setColor(secondaryColor);
        g.fillOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
    }
}
