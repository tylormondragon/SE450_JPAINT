package model;

import controller.Point;
import view.interfaces.IDrawShapes;

public class ShapeConfig {
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private Point startPoint;
    private Point endPoint;
    private ShapeShadingType shadingType;
    private ShapeType shapeType;
    private IDrawShapes selectedShape;
    private Point adjustedStartPoint;
    private Point adjustedEndPoint;
    private int width;
    private int height;

    //Setter Methods for shape configuration
    public void setPrimaryShapeColor(ShapeColor primaryShapeColor) {
        this.primaryShapeColor = primaryShapeColor;
    }

    public void setSecondaryShapeColor(ShapeColor secondaryShapeColor) {
        this.secondaryShapeColor = secondaryShapeColor;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void setSelectedShape(IDrawShapes selectedShape) {
        this.selectedShape = selectedShape;
    }

    public void setAdjustedStartPoint(Point adjustedStartPoint) {
        this.adjustedStartPoint = adjustedStartPoint;
    }

    public void setAdjustedEndPoint(Point adjustedEndPoint) {
        this.adjustedEndPoint = adjustedEndPoint;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /****************************************************/
    /****************************************************/

    //Getter Methods for shape configuration variables
    public ShapeColor getPrimaryShapeColor() {
        return primaryShapeColor;
    }

    public ShapeColor getSecondaryShapeColor() {
        return secondaryShapeColor;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public IDrawShapes getSelectedShape() {
        return selectedShape;
    }

    public Point getAdjustedStartPoint() {
        int xStart = Math.min(startPoint.getX(), endPoint.getX());
        int yStart = Math.min(startPoint.getY(), endPoint.getY());
        return new Point(xStart, yStart);
    }

    public Point getAdjustedEndPoint() {
        int xEnd = Math.max(startPoint.getX(), endPoint.getX());
        int yEnd = Math.max(startPoint.getY(), endPoint.getY());
        return new Point(xEnd, yEnd);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
