package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.eom.generated.pinventory.model.ApiTransactionStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ApiTransactionType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class ApiTransactionType  implements Serializable {
  @JsonProperty("transactionId")
  private String transactionId = null;

  @JsonProperty("transactionStatus")
  private ApiTransactionStatusType transactionStatus = null;

  @JsonProperty("resourceUri")
  private String resourceUri = null;

  public ApiTransactionType transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * The transactionId that was returned by the server (in the asynchronous scenario). Client will correlate the notification with the original request with the transactionId
   * @return transactionId
  **/
  @ApiModelProperty(required = true, value = "The transactionId that was returned by the server (in the asynchronous scenario). Client will correlate the notification with the original request with the transactionId")
  @NotNull
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public ApiTransactionType transactionStatus(ApiTransactionStatusType transactionStatus) {
    this.transactionStatus = transactionStatus;
    return this;
  }

   /**
   * The result of the transaction
   * @return transactionStatus
  **/
  @ApiModelProperty(required = true, value = "The result of the transaction")
  @NotNull
  public ApiTransactionStatusType getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(ApiTransactionStatusType transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  public ApiTransactionType resourceUri(String resourceUri) {
    this.resourceUri = resourceUri;
    return this;
  }

   /**
   * A resource URI pointing to the resource that is created, updated or deleted by the original request
   * @return resourceUri
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource that is created, updated or deleted by the original request")
  public String getResourceUri() {
    return resourceUri;
  }

  public void setResourceUri(String resourceUri) {
    this.resourceUri = resourceUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTransactionType apiTransactionType = (ApiTransactionType) o;
    return Objects.equals(this.transactionId, apiTransactionType.transactionId) &&
        Objects.equals(this.transactionStatus, apiTransactionType.transactionStatus) &&
        Objects.equals(this.resourceUri, apiTransactionType.resourceUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, transactionStatus, resourceUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTransactionType {\n");
    
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
    sb.append("    resourceUri: ").append(toIndentedString(resourceUri)).append("\n");
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

