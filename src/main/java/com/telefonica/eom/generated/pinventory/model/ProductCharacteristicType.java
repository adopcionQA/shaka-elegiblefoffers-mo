package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductCharacteristicType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = MobileQuota.class, name = "MobileQuota"),
  @JsonSubTypes.Type(value = InternetConnection.class, name = "InternetConnection"),
  @JsonSubTypes.Type(value = StringType.class, name = "StringType"),
  @JsonSubTypes.Type(value = Text.class, name = "Text"),
  @JsonSubTypes.Type(value = TvPackages.class, name = "TvPackages"),
})

public class ProductCharacteristicType  implements Serializable {
  /**
   * type of characteristic information element, defines the format structure of the value information element (string or object type)
   */
  public enum ValueTypeEnum {
    STRING("String"),
    
    OBJECT("Object");

    private String value;

    ValueTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValueTypeEnum fromValue(String text) {
      for (ValueTypeEnum b : ValueTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  /**
   * type of characteristic information element, defines the format structure of the value information element (string or specific object type)
   */
  public enum TypeEnum {
    STRINGTYPE("StringType"),
    
    TEXT("Text"),
    
    MOBILEQUOTA("MobileQuota"),
    
    INTERNETCONNECTION("InternetConnection"),
    
    TVPACKAGES("TvPackages");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("@type")
  private TypeEnum type = null;

  @JsonProperty("code")
  private String code = null;

  public ProductCharacteristicType valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

   /**
   * type of characteristic information element, defines the format structure of the value information element (string or object type)
   * @return valueType
  **/
  @ApiModelProperty(value = "type of characteristic information element, defines the format structure of the value information element (string or object type)")
  public ValueTypeEnum getValueType() {
    return valueType;
  }

  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }

  public ProductCharacteristicType type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * type of characteristic information element, defines the format structure of the value information element (string or specific object type)
   * @return type
  **/
  @ApiModelProperty(required = true, value = "type of characteristic information element, defines the format structure of the value information element (string or specific object type)")
  @NotNull
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ProductCharacteristicType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Is the code of characteristic
   * @return code
  **/
  @ApiModelProperty(value = "Is the code of characteristic")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCharacteristicType productCharacteristicType = (ProductCharacteristicType) o;
    return Objects.equals(this.valueType, productCharacteristicType.valueType) &&
        Objects.equals(this.type, productCharacteristicType.type) &&
        Objects.equals(this.code, productCharacteristicType.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueType, type, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCharacteristicType {\n");
    
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

