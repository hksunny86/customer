package com.example.demo.dto;


import java.util.List;

public class BookResponse {

    private String name;
    private List<LocationQuantity>  locations;

    public BookResponse(String name, List<LocationQuantity> locations) {
        this.name = name;
        this.locations = locations;
    }

    public static class LocationQuantity{
        private String location;
        private int quantity;

        public LocationQuantity(String location, int quantity) {
            this.location = location;
            this.quantity = quantity;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
