package zor.edu.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Document
public class TripTicket
{
    @Id
    private String id;
    private TravelRoute travelRoute;
    private String dateOfDeparture;
    private int amount;
    private double discount;
    private LocalDateTime createdAt, updatedAt;

    public TripTicket(){

    }

    public TripTicket(String id, TravelRoute travelRoute, String dateOfDeparture, int amount,
                      double discount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.travelRoute = travelRoute;
        this.dateOfDeparture = dateOfDeparture;
        this.amount = amount;
        this.discount = discount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TripTicket(String id, TravelRoute travelRoute, String dateOfDeparture, int amount, double discount) {
        this.id = id;
        this.travelRoute = travelRoute;
        this.dateOfDeparture = dateOfDeparture;
        this.amount = amount;
        this.discount = discount;
    }

    public TripTicket(TravelRoute travelRoute, String dateOfDeparture, int amount, double discount) {
        this.travelRoute = travelRoute;
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

    public TravelRoute getTravelRoute() {
        return travelRoute;
    }

    public void setTravelRoute(TravelRoute travelRoute) {
        this.travelRoute = travelRoute;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripTicket that = (TripTicket) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TripTicket{" +
                "id='" + id + '\'' +
                ", travelRoute=" + travelRoute +
                ", dateOfDeparture='" + dateOfDeparture + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
