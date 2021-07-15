package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * TimePeriodType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class TimePeriodType  implements Serializable {
  @JsonProperty("startDateTime")
  private DateTime startDateTime = null;

  @JsonProperty("endDateTime")
  private DateTime endDateTime = null;

  public TimePeriodType startDateTime(DateTime startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

   /**
   * An instant of time, starting of the TimePeriod
   * @return startDateTime
  **/
  @ApiModelProperty(required = true, value = "An instant of time, starting of the TimePeriod")
  @NotNull
  public DateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(DateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public TimePeriodType endDateTime(DateTime endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

   /**
   * An instant of time, ending of the TimePeriod. If not included, then the period has no ending date
   * @return endDateTime
  **/
  @ApiModelProperty(value = "An instant of time, ending of the TimePeriod. If not included, then the period has no ending date")
  public DateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(DateTime endDateTime) {
    this.endDateTime = endDateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimePeriodType timePeriodType = (TimePeriodType) o;
    return Objects.equals(this.startDateTime, timePeriodType.startDateTime) &&
        Objects.equals(this.endDateTime, timePeriodType.endDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDateTime, endDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimePeriodType {\n");
    
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
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

