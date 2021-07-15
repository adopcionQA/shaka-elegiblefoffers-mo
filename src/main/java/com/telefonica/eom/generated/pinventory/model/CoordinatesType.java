package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CoordinatesType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class CoordinatesType  implements Serializable {
  @JsonProperty("latitude")
  private String latitude = null;

  @JsonProperty("longitude")
  private String longitude = null;

  public CoordinatesType latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * Geographical longitude of the location.  If value is not available by server then the string  can indicate ‘UNAVAILABLE’ or something similar.
   * @return latitude
  **/
  @ApiModelProperty(required = true, value = "Geographical longitude of the location.  If value is not available by server then the string  can indicate ‘UNAVAILABLE’ or something similar.")
  @NotNull
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public CoordinatesType longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * Geographical latitude of the location.  If value is not available by server then the    string can indicate ‘UNAVAILABLE’ or something similar.
   * @return longitude
  **/
  @ApiModelProperty(required = true, value = "Geographical latitude of the location.  If value is not available by server then the    string can indicate ‘UNAVAILABLE’ or something similar.")
  @NotNull
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoordinatesType coordinatesType = (CoordinatesType) o;
    return Objects.equals(this.latitude, coordinatesType.latitude) &&
        Objects.equals(this.longitude, coordinatesType.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoordinatesType {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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

