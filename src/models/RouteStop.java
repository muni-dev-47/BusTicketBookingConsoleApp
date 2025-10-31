package models;


public class RouteStop {

    private int routeStopId;
    private long routeId;
    private String stopCity;
    private String stopLocation;
    private int stopOrder;
    private double distanceFromOriginKm;

    public RouteStop(long routeId, String stopCity, String stopLocation, int stopOrder) {
        this.routeId = routeId;
        this.stopCity = stopCity;
        this.stopLocation = stopLocation;
        this.stopOrder = stopOrder;
    }

    public RouteStop(long routeId, String stopCity, String stopLocation, int stopOrder, double distanceFromOriginKm) {
        this.routeId = routeId;
        this.stopCity = stopCity;
        this.stopLocation = stopLocation;
        this.stopOrder = stopOrder;
        this.distanceFromOriginKm = distanceFromOriginKm;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public double getDistanceFromOriginKm() {
        return distanceFromOriginKm;
    }

    public void setDistanceFromOriginKm(double distanceFromOriginKm) {
        this.distanceFromOriginKm = distanceFromOriginKm;
    }

    public int getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(int routeStopId) {
        this.routeStopId = routeStopId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getStopCity() {
        return stopCity;
    }

    public void setStopCity(String stopCity) {
        this.stopCity = stopCity;
    }

    public String getStopLocation() {
        return stopLocation;
    }

    public void setStopLocation(String stopLocation) {
        this.stopLocation = stopLocation;
    }

    public int getStopOrder() {
        return stopOrder;
    }

    public void setStopOrder(int stopOrder) {
        this.stopOrder = stopOrder;
    }
}