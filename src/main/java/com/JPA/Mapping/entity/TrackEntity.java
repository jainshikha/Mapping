package com.JPA.Mapping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Builder
@Entity(name = "track")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope= TrackEntity.class)
public class TrackEntity implements Serializable {

    private static final long serialVersionUID = -4602210571656981182L;
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String trackType;
    @Column
    private String state;
    @Column
    private String duration;
    @Column
    private String description;
    @Column
    private LocalDateTime createdAt;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "comp_track", joinColumns = @JoinColumn(name = "track_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "comp_id"))
    private List<ComponentEntity> components;


    @OneToMany(targetEntity = VehicleEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    private List<VehicleEntity> vehicles;


    @Column
    @ElementCollection
    private List<Long> campaignIds;

    public TrackEntity(UUID id, String name, String trackType, String state, String duration, String description, LocalDateTime createdAt, List<ComponentEntity> components, List<VehicleEntity> vehicles, List<Long> campaignIds) {
        this.id = id;
        this.name = name;
        this.trackType = trackType;
        this.state = state;
        this.duration = duration;
        this.description = description;
        this.createdAt = createdAt;
        this.components = components;
        this.vehicles = vehicles;
        this.campaignIds = campaignIds;
    }

    public TrackEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ComponentEntity> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentEntity> components) {
        this.components = components;
    }

    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Long> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<Long> campaignIds) {
        this.campaignIds = campaignIds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackEntity that = (TrackEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(trackType, that.trackType) && Objects.equals(state, that.state) && Objects.equals(duration, that.duration) && Objects.equals(description, that.description) && Objects.equals(createdAt, that.createdAt) && Objects.equals(components, that.components) && Objects.equals(vehicles, that.vehicles) && Objects.equals(campaignIds, that.campaignIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trackType, state, duration, description, createdAt, components, vehicles, campaignIds);
    }

    @Override
    public String toString() {
        return "TrackEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trackType='" + trackType + '\'' +
                ", state='" + state + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", components=" + components +
                ", vehicles=" + vehicles +
                ", campaignIds=" + campaignIds +
                '}';
    }
}
