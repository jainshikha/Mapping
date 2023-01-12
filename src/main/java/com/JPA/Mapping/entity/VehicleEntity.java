package com.JPA.Mapping.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * VehicleEntity
 */
@Builder(toBuilder = true)
@Entity(name = "vehicle")
public class VehicleEntity implements Serializable {

    private static final long serialVersionUID = 100476035305772432L;
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String vin;
    @Column
    private String country;

    public VehicleEntity(UUID id, String vin, String country) {
        this.id = id;
        this.vin = vin;
        this.country = country;
    }

    public VehicleEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(vin, that.vin) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, country);
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
