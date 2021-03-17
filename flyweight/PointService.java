package com.learning.flyweight;

import java.util.ArrayList;
import java.util.List;

public class PointService {
    private PointIconFactory icon_factory;

    public PointService(PointIconFactory icon_factory) {
        this.icon_factory = icon_factory;
    }

    public List<Point> get_points(){
        List<Point> points = new ArrayList<>();
        var point = new Point(1,2,icon_factory.getPointIcon(PointType.CAFE));
        points.add(point);
        return points;
    }
}
