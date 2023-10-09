package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        Rasterization.drawOval(canvas.getGraphicsContext2D(), 800, 600, 300, Color.WHITE, Color.NAVAJOWHITE);

        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 200, 0, 62, Color.GREEN, Color.GREENYELLOW);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 200, 72, 134, Color.GREENYELLOW, Color.AQUA);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 200, 144, 206, Color.AQUA, Color.AQUAMARINE);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 200, 216, 278, Color.AQUAMARINE, Color.CORAL);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 200, 288, 350, Color.CORAL, Color.GREEN);

        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 250, 26, 37, Color.NAVY, Color.SIENNA);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 250, 98, 108, Color.SIENNA, Color.SALMON);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 250, 170, 180, Color.SALMON, Color.SKYBLUE);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 250, 242, 252, Color.SKYBLUE, Color.PURPLE);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 250, 314, 324, Color.PURPLE, Color.NAVY);

        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 100, 41, 93, Color.CHOCOLATE, Color.CADETBLUE);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 100, 113, 165, Color.CADETBLUE, Color.MOCCASIN);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 100, 185, 237, Color.MOCCASIN, Color.MAGENTA);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 100, 257, 309, Color.MAGENTA, Color.NAVAJOWHITE);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 800, 600, 100, 329, 381, Color.NAVAJOWHITE, Color.CHOCOLATE);

        Rasterization.drawOval(canvas.getGraphicsContext2D(), 800, 600, 20, Color.ORANGE, Color.YELLOW);
    }

}