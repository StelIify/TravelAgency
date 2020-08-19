package zor.edu.demo.form;

import zor.edu.demo.model.Client;

import java.util.Objects;

public class TravelRouteForm
{
    private String id;
    private Client client;
    private String country;
    private String climate;
    private String duration;
    private String hotel;
    private double price;

    public TravelRouteForm(){

    }

    public TravelRouteForm(String id, Client client, String country, String climate, String duration, String hotel, double price) {
        this.id = id;
        this.client = client;
        this.country = country;
        this.climate = climate;
        this.duration = duration;
        this.hotel = hotel;
        this.price = price;
    }

    public TravelRouteForm(Client client, String country, String climate, String duration, String hotel, double price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelRouteForm that = (TravelRouteForm) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TravelRouteForm{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", country='" + country + '\'' +
                ", climate='" + climate + '\'' +
                ", duration='" + duration + '\'' +
                ", hotel='" + hotel + '\'' +
                ", price=" + price +
                '}';
    }
}
