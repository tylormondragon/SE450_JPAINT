package controller;

import model.ShapeList;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShapes {
    private final PaintCanvasBase paintCanvas;
    private final IApplicationState appState;

    public DrawShapes(PaintCanvasBase paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }
    public void draw(ShapeList shapeList) {
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(IDrawShapes shape: shapeList.getShapesList()) {
            shape.paint(g);
        }
    }
}
