package controller;

import model.ShapeConfig;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickHandler extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private ShapeList shapeList; //todo: does this need to be made an interface?
    private ShapeList selectedShapeList;
    private ShapeConfig shapeConfig;
    private PaintCanvasBase paintCanvas;

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
        System.out.printf("startpoint(%d, %d)\n", startPoint.getX(), startPoint.getY());
    }
    //todo: How to keep selected shapes selected to move multiple times?
    //todo: Advice on refactoring shapes to strategy pattern?
    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        StartAndEndPointMode mouseMode = applicationState.getActiveStartAndEndPointMode();

        if(mouseMode == StartAndEndPointMode.DRAW) {
            ShapeCreate newShape = new ShapeCreate(applicationState, shapeList, shapeConfig);
            newShape.run();
        }
        else if(mouseMode == StartAndEndPointMode.SELECT) {
            ShapeSelect selectShape = new ShapeSelect(applicationState, shapeList, selectedShapeList, shapeConfig);
            selectShape.run();
        }
        else {
            ShapeMove shapeMove = new ShapeMove(applicationState, shapeList, selectedShapeList, shapeConfig);
            shapeMove.run();
        }

        System.out.println("Mouse Released");
        System.out.printf("endpoint(%d, %d)\n", endPoint.getX(), endPoint.getY());
    }

}
