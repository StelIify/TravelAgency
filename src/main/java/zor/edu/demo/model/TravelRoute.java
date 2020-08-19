package zor.edu.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class TravelRoute
{
    @Id
    private String id;
    private Client client;
    private String country;
    private String climate;
    private String duration;
    private String hotel;
    private double price;
    private LocalDateTime createdAt, updatedAt;

    public TravelRoute(){

    }

    public TravelRoute(String id, Client client, String country, String climate, String duration,
                       String hotel, double price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.client = client;
        this.country = country;
        this.climate = climate;
        this.duration = duration;
        this.hotel = hotel;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TravelRoute(String id, Client client, String country, String climate, String duration, String hotel, double price) {
        this.id = id;
        this.client = client;
        this.country = country;
        this.climate = climate;
        this.duration = duration;
        this.hotel = hotel;
        this.price = price;
    }

    public TravelRoute(Client client, String country, String climate, String duration, String hotel, double price) {
        this.client = client;
        this.country = country;
        this.climate = climate;
        this.duration = duration;
        this.hotel = hotel;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        TravelRoute that = (TravelRoute) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TravelRoutes{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", country='" + country + '\'' +
                ", climate='" + climate + '\'' +
                ", duration='" + duration + '\'' +
                ", hotel='" + hotel + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

