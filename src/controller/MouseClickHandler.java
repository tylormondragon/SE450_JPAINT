package controller;

import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseClickHandler extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private ShapeList shapeList; //todo: does this need to be made an interface?
    private ShapeConfig shapeConfig;
    ArrayList<ShapeColor> shapeColor = new ArrayList<>();

    public MouseClickHandler(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed!");
        startPoint = new Point(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        StartAndEndPointMode mouseMode = applicationState.getActiveStartAndEndPointMode();

        if(mouseMode == StartAndEndPointMode.DRAW) {
            ShapeCreate newShape = new ShapeCreate(applicationState, shapeList, shapeConfig);
            newShape.run();
        }

        System.out.println("Mouse Released");
    }

}
