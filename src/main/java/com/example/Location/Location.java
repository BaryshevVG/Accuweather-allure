package com.example.Location;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version", "Key", "Type", "Rank", "LocalizedName", "EnglishName", "PrimaryPostalCode",
        "Region", "Country", "AdministrativeArea", "TimeZone", "GeoPosition", "IsAlias",
        "SupplementalAdminAreas", "DataSets", "ParentCity"
})
public class Location {

    @JsonProperty("Version")
    private Integer version;
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Rank")
    private Integer rank;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("PrimaryPostalCode")
    private String primaryPostalCode;
    @JsonProperty("Region")
    private Region region;
    @JsonProperty("Country")
    private Country country;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;
    @JsonProperty("TimeZone")
    private TimeZone timeZone;
    @JsonProperty("GeoPosition")
    private GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    private Boolean isAlias;
    @JsonProperty("SupplementalAdminAreas")
    private List<SupplementalAdminArea> supplementalAdminAreas;
    @JsonProperty("DataSets")
    private List<String> dataSets;
    @JsonProperty("ParentCity")
    private ParentCity parentCity;

    // Геттеры и сеттеры
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }
    public String getLocalizedName() { return localizedName; }
    public void setLocalizedName(String localizedName) { this.localizedName = localizedName; }
    public String getEnglishName() { return englishName; }
    public void setEnglishName(String englishName) { this.englishName = englishName; }
    public String getPrimaryPostalCode() { return primaryPostalCode; }
    public void setPrimaryPostalCode(String primaryPostalCode) { this.primaryPostalCode = primaryPostalCode; }
    public Region getRegion() { return region; }
    public void setRegion(Region region) { this.region = region; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
    public AdministrativeArea getAdministrativeArea() { return administrativeArea; }
    public void setAdministrativeArea(AdministrativeArea administrativeArea) { this.administrativeArea = administrativeArea; }
    public TimeZone getTimeZone() { return timeZone; }
    public void setTimeZone(TimeZone timeZone) { this.timeZone = timeZone; }
    public GeoPosition getGeoPosition() { return geoPosition; }
    public void setGeoPosition(GeoPosition geoPosition) { this.geoPosition = geoPosition; }
    public Boolean getIsAlias() { return isAlias; }
    public void setIsAlias(Boolean isAlias) { this.isAlias = isAlias; }
    public List<SupplementalAdminArea> getSupplementalAdminAreas() { return supplementalAdminAreas; }
    public void setSupplementalAdminAreas(List<SupplementalAdminArea> supplementalAdminAreas) { this.supplementalAdminAreas = supplementalAdminAreas; }
    public List<String> getDataSets() { return dataSets; }
    public void setDataSets(List<String> dataSets) { this.dataSets = dataSets; }
    public ParentCity getParentCity() { return parentCity; }
    public void setParentCity(ParentCity parentCity) { this.parentCity = parentCity; }
}
