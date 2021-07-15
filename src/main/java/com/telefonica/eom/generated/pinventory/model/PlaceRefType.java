package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.eom.generated.pinventory.model.CoordinatesType;
import com.telefonica.eom.generated.pinventory.model.LocaleRefType;
import com.telefonica.eom.generated.pinventory.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * PlaceRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class PlaceRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("entityType")
  private String entityType = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("district")
  private LocaleRefType district = null;

  @JsonProperty("province")
  private LocaleRefType province = null;

  @JsonProperty("department")
  private LocaleRefType department = null;

  @JsonProperty("coordinates")
  private CoordinatesType coordinates = null;

  public PlaceRefType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * String providing identification of the related entity reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "String providing identification of the related entity reported")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PlaceRefType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the related entity detailed information
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the related entity detailed information")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PlaceRefType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * String providing the name of the related entity reported
   * @return name
  **/
  @ApiModelProperty(value = "String providing the name of the related entity reported")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PlaceRefType role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Indication of the relationship defined between the entity and the order (e.g.: originator, customer, user, ?). Supported values are implementation and application specific
   * @return role
  **/
  @ApiModelProperty(value = "Indication of the relationship defined between the entity and the order (e.g.: originator, customer, user, ?). Supported values are implementation and application specific")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public PlaceRefType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the relation with the related entity. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the relation with the related entity. If not included, the current date is used as starting date and no ending date is defined")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public PlaceRefType entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Identifier of the type of entity that is referenced (party, address, location, site, channel, product spec, product offering, account, customer, payment, payment method ...)
   * @return entityType
  **/
  @ApiModelProperty(value = "Identifier of the type of entity that is referenced (party, address, location, site, channel, product spec, product offering, account, customer, payment, payment method ...)")
  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public PlaceRefType referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

   /**
   * Indicates the type of the resource referenced for extensibility/polimorphic purposes of the specific entity (individual/organization for customer, urban/rural for address, ...)
   * @return referredType
  **/
  @ApiModelProperty(value = "Indicates the type of the resource referenced for extensibility/polimorphic purposes of the specific entity (individual/organization for customer, urban/rural for address, ...)")
  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public PlaceRefType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Text describing the referred entity
   * @return description
  **/
  @ApiModelProperty(value = "Text describing the referred entity")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PlaceRefType district(LocaleRefType district) {
    this.district = district;
    return this;
  }

   /**
   * Local administrative name such as a city, town, municipality or council,  partido, concello, etc. that might comprise smaller entities
   * @return district
  **/
  @ApiModelProperty(value = "Local administrative name such as a city, town, municipality or council,  partido, concello, etc. that might comprise smaller entities")
  public LocaleRefType getDistrict() {
    return district;
  }

  public void setDistrict(LocaleRefType district) {
    this.district = district;
  }

  public PlaceRefType province(LocaleRefType province) {
    this.province = province;
    return this;
  }

   /**
   * Region, state, or province
   * @return province
  **/
  @ApiModelProperty(value = "Region, state, or province")
  public LocaleRefType getProvince() {
    return province;
  }

  public void setProvince(LocaleRefType province) {
    this.province = province;
  }

  public PlaceRefType department(LocaleRefType department) {
    this.department = department;
    return this;
  }

   /**
   * Region, state, or province
   * @return department
  **/
  @ApiModelProperty(value = "Region, state, or province")
  public LocaleRefType getDepartment() {
    return department;
  }

  public void setDepartment(LocaleRefType department) {
    this.department = department;
  }

  public PlaceRefType coordinates(CoordinatesType coordinates) {
    this.coordinates = coordinates;
    return this;
  }

   /**
   * The validity for the relation with the related object. If not included, the current date is used as starting date and no ending date is defined
   * @return coordinates
  **/
  @ApiModelProperty(value = "The validity for the relation with the related object. If not included, the current date is used as starting date and no ending date is defined")
  public CoordinatesType getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(CoordinatesType coordinates) {
    this.coordinates = coordinates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceRefType placeRefType = (PlaceRefType) o;
    return Objects.equals(this.id, placeRefType.id) &&
        Objects.equals(this.href, placeRefType.href) &&
        Objects.equals(this.name, placeRefType.name) &&
        Objects.equals(this.role, placeRefType.role) &&
        Objects.equals(this.validFor, placeRefType.validFor) &&
        Objects.equals(this.entityType, placeRefType.entityType) &&
        Objects.equals(this.referredType, placeRefType.referredType) &&
        Objects.equals(this.description, placeRefType.description) &&
        Objects.equals(this.district, placeRefType.district) &&
        Objects.equals(this.province, placeRefType.province) &&
        Objects.equals(this.department, placeRefType.department) &&
        Objects.equals(this.coordinates, placeRefType.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, validFor, entityType, referredType, description, district, province, department, coordinates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

