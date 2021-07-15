package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.MobileQuotaCharacteristicType;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * MobileQuota
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class MobileQuota extends ProductCharacteristicType implements Serializable {
  @JsonProperty("value")
  private MobileQuotaCharacteristicType value = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public MobileQuota value(MobileQuotaCharacteristicType value) {
    this.value = value;
    return this;
  }

   /**
   * Object including the characteristic information
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Object including the characteristic information")
  @NotNull
  public MobileQuotaCharacteristicType getValue() {
    return value;
  }

  public void setValue(MobileQuotaCharacteristicType value) {
    this.value = value;
  }

  public MobileQuota schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

   /**
   * This field provides a link to the schema describing the resource model for the Object defining the characteristics for an internet product
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing the resource model for the Object defining the characteristics for an internet product")
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
    MobileQuota mobileQuota = (MobileQuota) o;
    return Objects.equals(this.value, mobileQuota.value) &&
        Objects.equals(this.schemaLocation, mobileQuota.schemaLocation) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, schemaLocation, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileQuota {\n");
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

