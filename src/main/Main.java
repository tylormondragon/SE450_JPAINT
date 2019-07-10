package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseClickHandler;
import model.ShapeConfig;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
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
        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        ShapeList shapeList = new ShapeList(paintCanvas);
        ShapeConfig shapeConfig = new ShapeConfig();
        MouseClickHandler mouseHandler = new MouseClickHandler(appState,shapeList, shapeConfig);
        paintCanvas.addMouseListener(mouseHandler);
    }

}
