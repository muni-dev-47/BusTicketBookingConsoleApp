package models;

public class Route {

    private int routeId;
    private String routeName;
    private String originCity;
    private String destinationCity;
    private long ownerId;
    private double basePrice;

    public Route(String routeName, String originCity, String destinationCity, int ownerId) {
        this.routeName = routeName;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.ownerId = ownerId;
    }

    public Route(String routeName, String originCity, String destinationCity, long ownerId, double basePrice) {
        this.routeName = routeName;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.ownerId = ownerId;
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
}