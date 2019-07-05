package controller;

import model.ShapeConfig;
import model.ShapeFactory;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.IDrawShapes;

public class ShapeCreate implements ICommand {
    ShapeFactory shapeFactory = new ShapeFactory();
    private final IApplicationState applicationState;
    private ShapeConfig shapeConfig;
    private ShapeList shapeList;
    private IDrawShapes shape;

    public ShapeCreate(IApplicationState applicationState, ShapeList shapeList, ShapeConfig shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void run() {
        shapeConfig = applicationState.getCurrentShapeConfig();
        shape = shapeFactory.createShape(shapeConfig);
        this.shapeList.add(shape);
    }

    public IDrawShapes getShape() {
        return shape;
    }

}
