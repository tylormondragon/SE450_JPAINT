package model.interfaces;

import controller.Point;
import model.*;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    Point getStartPoint();

    Point getEndPoint();

    Point getAdjustedStart();

    Point getAdjustedEnd();

    void setStartPoint(Point startPoint);

    void setEndPoint(Point endPoint);

    ShapeConfig getCurrentShapeConfig(); //todo: implement this in ApplicationState
}
