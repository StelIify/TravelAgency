package zor.edu.demo.form;

import zor.edu.demo.model.TravelRoute;

import java.util.Objects;

public class TripTicketForm
{
    private String id;
    private TravelRoute travelRouteId;
    private String dateOfDeparture;
    private int amount;
    private double discount;

    public TripTicketForm()
    {

    }

    public TripTicketForm(String id, TravelRoute travelRouteId, String dateOfDeparture, int amount, double discount) {
        this.id = id;
        this.travelRouteId = travelRouteId;
        this.dateOfDeparture = dateOfDeparture;
        this.amount = amount;
        this.discount = discount;
    }

    public TripTicketForm(TravelRoute travelRouteId, String dateOfDeparture, int amount, double discount) {
        this.travelRouteId = travelRouteId;
        this.dateOfDeparture = dateOfDeparture;
        this.amount = amount;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TravelRoute getTravelRouteId() {
        return travelRouteId;
    }

    public void setTravelRouteId(TravelRoute travelRouteId) {
        this.travelRouteId = travelRouteId;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripTicketForm that = (TripTicketForm) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TripTicketForm{" +
                "id='" + id + '\'' +
                ", travelRouteId='" + travelRouteId + '\'' +
                ", dateOfDeparture='" + dateOfDeparture + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
