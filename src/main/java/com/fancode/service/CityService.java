package com.fancode.service;

import com.fancode.model.CityEnum;
import com.fancode.model.Geo;
import com.fancode.model.GeoRange;
import com.fancode.model.User;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

import static com.fancode.model.CityEnum.FanCode;

public class CityService {

    private static final Map<CityEnum, Pair<GeoRange, GeoRange>> CITY_RANGE = new HashMap<>();

    static {
        CITY_RANGE.put(FanCode, Pair.of(new GeoRange(-40, 5), new GeoRange(5, 100)));
    }

    public static boolean isFanCodeCity(User user) {
        return isWithinRange(user.getAddress().getGeo(), CITY_RANGE.get(FanCode));
    }

    private static boolean isWithinRange(Geo geo, Pair<GeoRange, GeoRange> latLngRange) {
        return geo.getLat()>= latLngRange.getLeft().getX() && geo.getLat() <= latLngRange.getLeft().getY()
                && geo.getLng()>= latLngRange.getRight().getX() && geo.getLng() <= latLngRange.getRight().getY();
    }
}
