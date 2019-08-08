package model;

import controller.Point;
import model.dialogs.ColorSingleton;
import model.interfaces.IShapeStrategy;

import java.awt.*;

public class TriangleStrategy implements IShapeStrategy {
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

    public TriangleStrategy(ShapeConfig shapeConfig) {
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
        g.fillPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()},
                3);
    }

    public void drawOutline(ShapeConfig shapeConfig) {
        if(shadingType.equals(ShapeShadingType.OUTLINE))
        g.setColor(primaryColor);
        g2.setStroke(new BasicStroke(9));
        g.drawPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()},
                3);
    }

    public void drawFilledOutlined(ShapeConfig shapeConfig) {
        g.setColor(primaryColor);
        g2.setStroke(new BasicStroke(10));
        g.drawPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()}, 3);
        g.setColor(secondaryColor);
        g.fillPolygon(new int[]{adjustedStartPoint.getX(), adjustedEndPoint.getX(), adjustedStartPoint.getX()},
                new int[]{adjustedStartPoint.getY(), adjustedEndPoint.getY(), adjustedEndPoint.getY()}, 3);
    }
}
