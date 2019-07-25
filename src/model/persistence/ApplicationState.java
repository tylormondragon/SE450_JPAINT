package model.persistence;

import controller.Point;
import model.*;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

import java.io.Serializable;

public class ApplicationState implements IApplicationState{
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;
    private ShapeList shapeList;
    private Point startPoint;
    private Point endPoint;
    private Point adjustedStartPoint;
    private Point adjustedEndPoint;
    private int height;
    private int width;
    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getAdjustedStartPoint() {
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        adjustedStartPoint = new Point(startX, startY);
        return adjustedStartPoint;
    }

    public Point getAdjustedEndPoint() {
        int endX = Math.max(startPoint.getX(), endPoint.getX());
        int endY = Math.max(startPoint.getY(), endPoint.getY());
        adjustedEndPoint = new Point(endX, endY);
        return adjustedEndPoint;
    }

    public void setAdjustedStartPoint(Point adjustedStart) {
        this.adjustedStartPoint = adjustedStart;
    }

    public void setAdjustedEndPoint(Point adjustedEnd) {
        this.adjustedEndPoint = adjustedEnd;
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeConfig getCurrentShapeConfig() {
        ShapeConfig shapeConfig = new ShapeConfig();
        shapeConfig.setPrimaryShapeColor(activePrimaryColor);
        shapeConfig.setSecondaryShapeColor(activeSecondaryColor);
        shapeConfig.setShadingType(activeShapeShadingType);
        shapeConfig.setShapeType(activeShapeType);
        shapeConfig.setEndPoint(endPoint);
        shapeConfig.setStartPoint(startPoint);
        shapeConfig.setAdjustedEndPoint(adjustedEndPoint);
        shapeConfig.setAdjustedStartPoint(adjustedStartPoint);
        shapeConfig.setWidth(width);
        shapeConfig.setHeight(height);

        return shapeConfig;
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }
}
