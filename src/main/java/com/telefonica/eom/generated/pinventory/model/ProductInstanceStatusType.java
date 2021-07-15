package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.KeyValueType;
import com.telefonica.eom.generated.pinventory.model.ProductStatusChangeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductInstanceStatusType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class ProductInstanceStatusType  implements Serializable {
  /**
   * Tracks the lifecycle status of the product in the internal state machine of the processing system
   */
  public enum StatusEnum {
    NEW("new"),
    
    CREATED("created"),
    
    ACTIVE("active"),
    
    PENDING("pending"),
    
    ABORTED("aborted"),
    
    SUSPENDED("suspended"),
    
    CANCELLED("cancelled"),
    
    CANCELLING("cancelling"),
    
    TERMINATED("terminated"),
    
    TERMINATING("terminating"),
    
    INFORMATION("information"),
    
    TRIAL("trial"),
    
    KEEP("keep");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("subStatus")
  private String subStatus = null;

  @JsonProperty("statusChanges")
  private List<ProductStatusChangeType> statusChanges = new ArrayList<ProductStatusChangeType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public ProductInstanceStatusType status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Tracks the lifecycle status of the product in the internal state machine of the processing system
   * @return status
  **/
  @ApiModelProperty(required = true, value = "Tracks the lifecycle status of the product in the internal state machine of the processing system")
  @NotNull
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ProductInstanceStatusType subStatus(String subStatus) {
    this.subStatus = subStatus;
    return this;
  }

   /**
   * Substatus in order to define a second status level
   * @return subStatus
  **/
  @ApiModelProperty(value = "Substatus in order to define a second status level")
  public String getSubStatus() {
    return subStatus;
  }

  public void setSubStatus(String subStatus) {
    this.subStatus = subStatus;
  }

  public ProductInstanceStatusType statusChanges(List<ProductStatusChangeType> statusChanges) {
    this.statusChanges = statusChanges;
    return this;
  }

  public ProductInstanceStatusType addStatusChangesItem(ProductStatusChangeType statusChangesItem) {
    this.statusChanges.add(statusChangesItem);
    return this;
  }

   /**
   * List of status/substatus changes for the entity
   * @return statusChanges
  **/
  @ApiModelProperty(value = "List of status/substatus changes for the entity")
  public List<ProductStatusChangeType> getStatusChanges() {
    return statusChanges;
  }

  public void setStatusChanges(List<ProductStatusChangeType> statusChanges) {
    this.statusChanges = statusChanges;
  }

  public ProductInstanceStatusType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductInstanceStatusType addAdditionalDataItem(KeyValueType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any further information needed by the server to fill the entity status info. It could be used to provide specific identification of the entity whose status has changed (e.g.: type of entity and id of entity).It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any further information needed by the server to fill the entity status info. It could be used to provide specific identification of the entity whose status has changed (e.g.: type of entity and id of entity).It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs")
  public List<KeyValueType> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInstanceStatusType productInstanceStatusType = (ProductInstanceStatusType) o;
    return Objects.equals(this.status, productInstanceStatusType.status) &&
        Objects.equals(this.subStatus, productInstanceStatusType.subStatus) &&
        Objects.equals(this.statusChanges, productInstanceStatusType.statusChanges) &&
        Objects.equals(this.additionalData, productInstanceStatusType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, subStatus, statusChanges, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInstanceStatusType {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
    sb.append("    statusChanges: ").append(toIndentedString(statusChanges)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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

