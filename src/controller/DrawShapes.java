package controller;

import model.ShapeList;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShapes {
    private final PaintCanvasBase paintCanvas;
    private IApplicationState appState;

    public DrawShapes(PaintCanvasBase paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }
    public void draw(ShapeList shapeList) {
        Graphics2D g = paintCanvas.getGraphics2D();
        for(IDrawShapes shape: shapeList.getShapesList())
        shape.paint(g);
    }
}
