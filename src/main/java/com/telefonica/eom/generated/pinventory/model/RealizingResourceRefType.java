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
 * RealizingResourceRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class RealizingResourceRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("code")
  private String code = null;

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

  public RealizingResourceRefType id(String id) {
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

  public RealizingResourceRefType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Codigo de catalogo del componente relacionado
   * @return code
  **/
  @ApiModelProperty(value = "Codigo de catalogo del componente relacionado")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public RealizingResourceRefType href(String href) {
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

  public RealizingResourceRefType name(String name) {
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

  public RealizingResourceRefType role(String role) {
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

  public RealizingResourceRefType validFor(TimePeriodType validFor) {
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

  public RealizingResourceRefType entityType(String entityType) {
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

  public RealizingResourceRefType referredType(String referredType) {
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

  public RealizingResourceRefType description(String description) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RealizingResourceRefType realizingResourceRefType = (RealizingResourceRefType) o;
    return Objects.equals(this.id, realizingResourceRefType.id) &&
        Objects.equals(this.code, realizingResourceRefType.code) &&
        Objects.equals(this.href, realizingResourceRefType.href) &&
        Objects.equals(this.name, realizingResourceRefType.name) &&
        Objects.equals(this.role, realizingResourceRefType.role) &&
        Objects.equals(this.validFor, realizingResourceRefType.validFor) &&
        Objects.equals(this.entityType, realizingResourceRefType.entityType) &&
        Objects.equals(this.referredType, realizingResourceRefType.referredType) &&
        Objects.equals(this.description, realizingResourceRefType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, href, name, role, validFor, entityType, referredType, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RealizingResourceRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
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

