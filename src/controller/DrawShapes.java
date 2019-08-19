package controller;

import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoRedo;
import view.interfaces.IDrawShapes;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShapes implements IUndoRedo {
    private final PaintCanvasBase paintCanvas;
    private final IApplicationState appState;

    public DrawShapes(PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }
    public void draw(ShapeList shapeList) {
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(IDrawShapes shape: shapeList.getShapesList()) {
            shape.paint(g);
            if(shapeList.getSelectedShapesList().contains(shape)) {
                shape.drawOutline(g);
            }
        }
        CommandHistory.add(this);
    }

    @Override
    public void redo() {

    }

    @Override
    public void undo() {

    }
}
