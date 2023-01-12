package com.JPA.Mapping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * ComponentEntity
 */

@Builder
@Entity(name = "component")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = ComponentEntity.class)
public class ComponentEntity implements Serializable {

    private static final long serialVersionUID = 4832586960313967819L;
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String version;
    @Column
    private String type;
    @Column
    private String status;
    @Column
    private Integer revision;
    @Column
    private String updatedBy;
    @Column
    private String updatedOn;
    @Column
    private UUID refComponentId;
    @Column
    private String fileName;

    @ManyToMany(mappedBy = "components", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TrackEntity> tracks = new HashSet<>();

    public ComponentEntity() {
    }

    public ComponentEntity(UUID id, String name, String version, String type, String status, Integer revision, String updatedBy, String updatedOn, UUID refComponentId, String fileName, Set<TrackEntity> tracks) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.type = type;
        this.status = status;
        this.revision = revision;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.refComponentId = refComponentId;
        this.fileName = fileName;
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "ComponentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", revision=" + revision +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", refComponentId=" + refComponentId +
                ", fileName='" + fileName + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentEntity that = (ComponentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(version, that.version) && Objects.equals(type, that.type) && Objects.equals(status, that.status) && Objects.equals(revision, that.revision) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(updatedOn, that.updatedOn) && Objects.equals(refComponentId, that.refComponentId) && Objects.equals(fileName, that.fileName) && Objects.equals(tracks, that.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, type, status, revision, updatedBy, updatedOn, refComponentId, fileName, tracks);
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public UUID getRefComponentId() {
        return refComponentId;
    }

    public void setRefComponentId(UUID refComponentId) {
        this.refComponentId = refComponentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<TrackEntity> getTracks() {
        return tracks;
    }

    public void setTracks(Set<TrackEntity> tracks) {
        this.tracks = tracks;
    }
}
