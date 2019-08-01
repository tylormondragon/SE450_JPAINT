package main;

import controller.DrawShapes;
import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseClickHandler;
import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IDrawShapes;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        DrawShapes drawShapes = new DrawShapes(paintCanvas, appState);
        paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
        ShapeList shapeList = new ShapeList(drawShapes);
        ShapeConfig shapeConfig = new ShapeConfig();
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, shapeConfig);
        controller.setup();
        MouseClickHandler mouseHandler = new MouseClickHandler(appState,shapeList, shapeConfig);
        paintCanvas.addMouseListener(mouseHandler);
    }

}
