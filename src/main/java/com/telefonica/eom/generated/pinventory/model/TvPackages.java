package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import com.telefonica.eom.generated.pinventory.model.TvPackagesCharacteristicType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * TvPackages
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class TvPackages extends ProductCharacteristicType implements Serializable {
  @JsonProperty("value")
  private TvPackagesCharacteristicType value = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public TvPackages value(TvPackagesCharacteristicType value) {
    this.value = value;
    return this;
  }

   /**
   * Object including the characteristic information
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Object including the characteristic information")
  @NotNull
  public TvPackagesCharacteristicType getValue() {
    return value;
  }

  public void setValue(TvPackagesCharacteristicType value) {
    this.value = value;
  }

  public TvPackages schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

   /**
   * This field provides a link to the schema describing the resource model for the Object defining the characteristics for a TV product
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing the resource model for the Object defining the characteristics for a TV product")
  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TvPackages tvPackages = (TvPackages) o;
    return Objects.equals(this.value, tvPackages.value) &&
        Objects.equals(this.schemaLocation, tvPackages.schemaLocation) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, schemaLocation, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvPackages {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

