package io.natron.noscope360.analyze.service;

import com.esri.core.geometry.*;
import org.springframework.stereotype.Service;

@Service
public class GeometryService {

    private static final int SPATIAL_REFERENCE_LV03 = 21781;
    private static final int SPATIAL_REFERENCE_LV95 = 2056;
    private static final int SPATIAL_REFERENCE_WGS84 = 4326;
    private static final SpatialReference SPATIAL_REFERENCE_DEFAULT = SpatialReference.create(SPATIAL_REFERENCE_LV03);

    public double intersection(GeometryCursor area1, GeometryCursor area2) {

        // http://esri.github.io/geometry-api-java/doc/Intersection.html
        GeometryCursor output = OperatorIntersection.local().execute(area1, area2, SPATIAL_REFERENCE_DEFAULT, null);

        double intersectionResult = 0;

        Geometry current;
        while ((current = output.next()) != null) {
            intersectionResult += current.calculateArea2D();
        }

        return intersectionResult;
    }

    public boolean isPointInArea(Geometry area, Geometry point) {

        // http://esri.github.io/geometry-api-java/doc/Contains.html
        return OperatorContains.local().execute(area, point, SPATIAL_REFERENCE_DEFAULT, null);
    }

    public Geometry jsonToGeometry(String json) {

        MapGeometry map =  OperatorImportFromJson.local().execute(Geometry.Type.Unknown, json);
        return map.getGeometry();
    }

    public GeometryCursor jsonToGeometryCursor(String json) {

        return new SimpleGeometryCursor(jsonToGeometry(json));
    }
}
