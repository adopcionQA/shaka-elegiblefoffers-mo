package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.eom.generated.pinventory.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * RelatedPartyRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class RelatedPartyRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nationalId")
  private String nationalId = null;

  @JsonProperty("nationalIdType")
  private String nationalIdType = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("description")
  private String description = null;

  public RelatedPartyRefType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * String providing identification of the related party reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "String providing identification of the related party reported")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RelatedPartyRefType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the related party detailed information
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the related party detailed information")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public RelatedPartyRefType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * String providing the name of the related party reported
   * @return name
  **/
  @ApiModelProperty(value = "String providing the name of the related party reported")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RelatedPartyRefType nationalId(String nationalId) {
    this.nationalId = nationalId;
    return this;
  }

   /**
   * To obtain the list of products matching to a given legal identification value. Typically used combined with nationalIdType
   * @return nationalId
  **/
  @ApiModelProperty(value = "To obtain the list of products matching to a given legal identification value. Typically used combined with nationalIdType")
  public String getNationalId() {
    return nationalId;
  }

  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public RelatedPartyRefType nationalIdType(String nationalIdType) {
    this.nationalIdType = nationalIdType;
    return this;
  }

   /**
   * To obtain the list of products matching to a given legal identification type (e.g.: DNI, passport, social security number, RUC, CPF, driver's license, etc.). This is typically combined with nationalID to query for specific identity
   * @return nationalIdType
  **/
  @ApiModelProperty(value = "To obtain the list of products matching to a given legal identification type (e.g.: DNI, passport, social security number, RUC, CPF, driver's license, etc.). This is typically combined with nationalID to query for specific identity")
  public String getNationalIdType() {
    return nationalIdType;
  }

  public void setNationalIdType(String nationalIdType) {
    this.nationalIdType = nationalIdType;
  }

  public RelatedPartyRefType role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Indication of the relationship defined between the related party and the order (e.g.: originator, customer, user, ?). Supported values are implementation and application specific
   * @return role
  **/
  @ApiModelProperty(value = "Indication of the relationship defined between the related party and the order (e.g.: originator, customer, user, ?). Supported values are implementation and application specific")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public RelatedPartyRefType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the relation with the related party. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the relation with the related party. If not included, the current date is used as starting date and no ending date is defined")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public RelatedPartyRefType referredType(String referredType) {
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

  public RelatedPartyRefType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Text describing the referred related party
   * @return description
  **/
  @ApiModelProperty(value = "Text describing the referred related party")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedPartyRefType relatedPartyRefType = (RelatedPartyRefType) o;
    return Objects.equals(this.id, relatedPartyRefType.id) &&
        Objects.equals(this.href, relatedPartyRefType.href) &&
        Objects.equals(this.name, relatedPartyRefType.name) &&
        Objects.equals(this.nationalId, relatedPartyRefType.nationalId) &&
        Objects.equals(this.nationalIdType, relatedPartyRefType.nationalIdType) &&
        Objects.equals(this.role, relatedPartyRefType.role) &&
        Objects.equals(this.validFor, relatedPartyRefType.validFor) &&
        Objects.equals(this.referredType, relatedPartyRefType.referredType) &&
        Objects.equals(this.description, relatedPartyRefType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, nationalId, nationalIdType, role, validFor, referredType, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedPartyRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nationalId: ").append(toIndentedString(nationalId)).append("\n");
    sb.append("    nationalIdType: ").append(toIndentedString(nationalIdType)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

