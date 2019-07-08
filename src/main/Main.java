package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseClickHandler;
import model.ShapeConfig;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.DrawRectangle;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        ShapeConfig shapeConfig = new ShapeConfig();
        ShapeList shapeList = new ShapeList();
        PaintCanvasBase paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        MouseClickHandler mouseHandler = new MouseClickHandler(appState,shapeList, shapeConfig);
        paintCanvas.addMouseListener(mouseHandler);
    }

}
