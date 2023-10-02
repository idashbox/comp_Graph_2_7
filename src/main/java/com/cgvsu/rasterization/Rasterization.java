package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }
    public static void drawFilledCircleSector(final GraphicsContext gc, final int width, final int height) {
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = 200;
        int startAngle = 40;
        int endAngle = 150;

        // Цвета для интерполяции
        Color startColor = Color.GREEN;
        Color endColor = Color.GREENYELLOW;

        // Преобразуем углы в радианы
        double startAngleRad = Math.toRadians(startAngle);
        double endAngleRad = Math.toRadians(endAngle);

        // Увеличиваем количество отрисовываемых точек
        int numPoints = (int) (radius * (endAngleRad - startAngleRad) / 1.0) + 2000;

        // Вычисляем шаг изменения угла
        double angleStep = (endAngleRad - startAngleRad) / numPoints;

        // Рисуем сектор
        for (double angle = startAngleRad; angle <= endAngleRad; angle += angleStep) {
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));

            // Интерполируем цвет
            double t = (angle - startAngleRad) / (endAngleRad - startAngleRad);
            Color interpolatedColor = interpolateColor(startColor, endColor, t);

            // Устанавливаем цвет пикселя
            gc.setStroke(interpolatedColor);
            gc.strokeLine(centerX, centerY, x, y);

            }
        }

    public static Color interpolateColor(Color startColor, Color endColor, double t) {
        double red = startColor.getRed() + t * (endColor.getRed() - startColor.getRed());
        double green = startColor.getGreen() + t * (endColor.getGreen() - startColor.getGreen());
        double blue = startColor.getBlue() + t * (endColor.getBlue() - startColor.getBlue());
        return new Color(red, green, blue, 1.0);
    }
}
