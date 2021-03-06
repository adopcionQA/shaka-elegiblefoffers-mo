package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * StringType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class StringType extends ProductCharacteristicType implements Serializable {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  public StringType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the product string characteristic
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the product string characteristic")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StringType value(String value) {
    this.value = value;
    return this;
  }

   /**
   * the value that the characteristic can take on as string
   * @return value
  **/
  @ApiModelProperty(required = true, value = "the value that the characteristic can take on as string")
  @NotNull
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringType stringType = (StringType) o;
    return Objects.equals(this.name, stringType.name) &&
        Objects.equals(this.value, stringType.value) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StringType {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

