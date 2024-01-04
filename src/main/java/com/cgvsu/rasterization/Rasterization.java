//package com.cgvsu.rasterization;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.PixelWriter;
//import javafx.scene.paint.Color;
//
//public class Rasterization {
//    public static void drawCircleSector(final GraphicsContext gc, final int width, final int height, final int radius, final int startAngle, final int endAngle, Color startColor, Color endColor) {
//        int centerX = width / 2;
//        int centerY = height / 2;
//
//        // Преобразуем углы в радианы
//        double startAngleRad = Math.toRadians(startAngle);
//        double endAngleRad = Math.toRadians(endAngle);
//
//        // Увеличиваем количество отрисовываемых точек
//        int numPoints = (int) (radius * (endAngleRad - startAngleRad)) + width + height;
//        // Вычисляем шаг изменения угла
//        double angleStep = (endAngleRad - startAngleRad) / numPoints;
//
//        // Рисуем сектор
//        for (double angle = startAngleRad; angle <= endAngleRad; angle += angleStep) {
//            int x = (int) (centerX + radius * Math.cos(angle));
//            int y = (int) (centerY + radius * Math.sin(angle));
//
//            // Интерполируем цвет
//            double t = (angle - startAngleRad) / (endAngleRad - startAngleRad);
//            Color interpolatedColor = interpolateColor(startColor, endColor, t);
//
//            // Устанавливаем цвет пикселя
//            gc.setStroke(interpolatedColor);
//            gc.strokeLine(centerX, centerY, x, y);
//
//        }
//    }
//
//    public static Color interpolateColor(Color startColor, Color endColor, double t) {
//        double red = startColor.getRed() + t * (endColor.getRed() - startColor.getRed());
//        double green = startColor.getGreen() + t * (endColor.getGreen() - startColor.getGreen());
//        double blue = startColor.getBlue() + t * (endColor.getBlue() - startColor.getBlue());
//        return new Color(red, green, blue, 1.0);
//    }
//
//    public static void drawOval(final GraphicsContext gc, final int width, final int height, final int radius, final Color startColor, final Color endColor) {
//        int centerX = width / 2;
//        int centerY = height / 2;
//
//        // Преобразуем углы в радианы
//        double startAngleRad = Math.toRadians(0);
//        double endAngleRad = Math.toRadians(360);
//
//        // Рисуем окружность
//        for (double indent = 0; indent <= radius; indent += 0.1) {
//            final PixelWriter pixelWriter = gc.getPixelWriter();
//            for (double angle = startAngleRad; angle <= endAngleRad; angle += 0.001) {
//                int x = (int) (centerX + (radius-indent) * Math.cos(angle));
//                int y = (int) (centerY + (radius-indent) * Math.sin(angle));
//
//                // Интерполируем цвет
//                double t = indent / radius;
//                Color interpolatedColor = interpolateColor(startColor, endColor, t);
//
//                // Рисуем пиксель
//                pixelWriter.setColor(x, y, interpolatedColor);
//            }
//        }
//    }
//}
package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {
    public static void drawCircleSector(final GraphicsContext gc, final int width, final int height, final int radius, final int startAngle, final int endAngle, Color startColor, Color endColor) {
        int centerX = width / 2;
        int centerY = height / 2;

        // Преобразуем углы в радианы
        double startAngleRad = Math.toRadians(startAngle);
        double endAngleRad = Math.toRadians(endAngle);

        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (double indent = 0; indent <= radius; indent += 0.5) {
            for (double angle = startAngleRad; angle <= endAngleRad; angle += 0.002) {
                double cosAngle = Math.cos(angle);
                double sinAngle = Math.sin(angle);
                double radiusIndent = radius - indent;

                int x = (int) (centerX + radiusIndent * cosAngle);
                int y = (int) (centerY + radiusIndent * sinAngle);

                // Интерполируем цвет
                double t = indent / radius;
                Color interpolatedColor = interpolateColor(startColor, endColor, t);

                // Рисуем пиксель
                pixelWriter.setColor(x, y, interpolatedColor);
            }
        }
    }

    public static Color interpolateColor(Color startColor, Color endColor, double t) {
        double red = startColor.getRed() + t * (endColor.getRed() - startColor.getRed());
        double green = startColor.getGreen() + t * (endColor.getGreen() - startColor.getGreen());
        double blue = startColor.getBlue() + t * (endColor.getBlue() - startColor.getBlue());
        return new Color(red, green, blue, 1.0);
    }

    public static void drawOval(final GraphicsContext gc, final int width, final int height, final int radius, final Color startColor, final Color endColor) {
        int centerX = width / 2;
        int centerY = height / 2;

        // Преобразуем углы в радианы
        double startAngleRad = Math.toRadians(0);
        double endAngleRad = Math.toRadians(360);

        final PixelWriter pixelWriter = gc.getPixelWriter();

        for (double indent = 0; indent <= radius; indent += 0.5) {
            for (double angle = startAngleRad; angle <= endAngleRad; angle += 0.002) {
                double cosAngle = Math.cos(angle);
                double sinAngle = Math.sin(angle);
                double radiusIndent = radius - indent;

                int x = (int) (centerX + radiusIndent * cosAngle);
                int y = (int) (centerY + radiusIndent * sinAngle);

                // Интерполируем цвет
                double t = indent / radius;
                Color interpolatedColor = interpolateColor(startColor, endColor, t);

                // Рисуем пиксель
                pixelWriter.setColor(x, y, interpolatedColor);
            }
        }
    }
}