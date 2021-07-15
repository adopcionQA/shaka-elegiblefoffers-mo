package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.AccountRefType;
import com.telefonica.eom.generated.pinventory.model.CategoryTreeType;
import com.telefonica.eom.generated.pinventory.model.ComponentProdPriceType;
import com.telefonica.eom.generated.pinventory.model.EntityRefType;
import com.telefonica.eom.generated.pinventory.model.KeyValueType;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import com.telefonica.eom.generated.pinventory.model.RelatedObjectType;
import com.telefonica.eom.generated.pinventory.model.RelatedPartyRefType;
import com.telefonica.eom.generated.pinventory.model.RelatedProductType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductInstanceRequestType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class ProductInstanceRequestType  implements Serializable {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Indication of the type of product instance registered. Supported values are implementation and application specific
   */
  public enum ProductTypeEnum {
    MOBILE("mobile"),
    
    LANDLINE("landline"),
    
    IPTV("ipTv"),
    
    CABLETV("cableTv"),
    
    BROADBAND("broadband"),
    
    BUNDLE("bundle"),
    
    SVA("sva"),
    
    SIM("sim"),
    
    DEVICE("device"),
    
    BOLTON("bolton"),
    
    DTH("dth"),
    
    STREAMINGTV("streamingTv");

    private String value;

    ProductTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductTypeEnum fromValue(String text) {
      for (ProductTypeEnum b : ProductTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("productType")
  private ProductTypeEnum productType = null;

  @JsonProperty("category")
  private List<CategoryTreeType> category = new ArrayList<CategoryTreeType>();

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("isCustomerVisible")
  private Boolean isCustomerVisible = null;

  @JsonProperty("productSerialNumber")
  private String productSerialNumber = null;

  @JsonProperty("startDate")
  private DateTime startDate = null;

  @JsonProperty("terminationDate")
  private DateTime terminationDate = null;

  /**
   * The status to which the product has to be set
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

  @JsonProperty("billingAccount")
  private List<AccountRefType> billingAccount = new ArrayList<AccountRefType>();

  @JsonProperty("productOffering")
  private EntityRefType productOffering = null;

  @JsonProperty("productSpec")
  private EntityRefType productSpec = null;

  @JsonProperty("agreement")
  private List<EntityRefType> agreement = new ArrayList<EntityRefType>();

  @JsonProperty("characteristic")
  private List<ProductCharacteristicType> characteristic = new ArrayList<ProductCharacteristicType>();

  @JsonProperty("productRelationship")
  private List<RelatedProductType> productRelationship = new ArrayList<RelatedProductType>();

  @JsonProperty("productPrice")
  private List<ComponentProdPriceType> productPrice = new ArrayList<ComponentProdPriceType>();

  @JsonProperty("paymentMean")
  private EntityRefType paymentMean = null;

  @JsonProperty("place")
  private List<EntityRefType> place = new ArrayList<EntityRefType>();

  @JsonProperty("relatedParty")
  private List<RelatedPartyRefType> relatedParty = new ArrayList<RelatedPartyRefType>();

  @JsonProperty("relatedObject")
  private List<RelatedObjectType> relatedObject = new ArrayList<RelatedObjectType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  @JsonProperty("callbackUrl")
  private String callbackUrl = null;

  public ProductInstanceRequestType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Some text providing a user-friendly detailed description of the product instance
   * @return description
  **/
  @ApiModelProperty(value = "Some text providing a user-friendly detailed description of the product instance")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductInstanceRequestType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable product name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable product name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductInstanceRequestType productType(ProductTypeEnum productType) {
    this.productType = productType;
    return this;
  }

   /**
   * Indication of the type of product instance registered. Supported values are implementation and application specific
   * @return productType
  **/
  @ApiModelProperty(value = "Indication of the type of product instance registered. Supported values are implementation and application specific")
  public ProductTypeEnum getProductType() {
    return productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = productType;
  }

  public ProductInstanceRequestType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public ProductInstanceRequestType addCategoryItem(CategoryTreeType categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * List of categories/subcategories allocated to the ticket, intended to allow segmentation. A product may belong to more than one category
   * @return category
  **/
  @ApiModelProperty(value = "List of categories/subcategories allocated to the ticket, intended to allow segmentation. A product may belong to more than one category")
  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public ProductInstanceRequestType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true).
   * @return isBundle
  **/
  @ApiModelProperty(value = "Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true).")
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductInstanceRequestType isCustomerVisible(Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
    return this;
  }

   /**
   * Indicates if the product is the product is visible by the customer (true) or not (false). If it's not included, true is assumed.
   * @return isCustomerVisible
  **/
  @ApiModelProperty(value = "Indicates if the product is the product is visible by the customer (true) or not (false). If it's not included, true is assumed.")
  public Boolean getIsCustomerVisible() {
    return isCustomerVisible;
  }

  public void setIsCustomerVisible(Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
  }

  public ProductInstanceRequestType productSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
    return this;
  }

   /**
   * Any commercial code string that can be used for internal accounting to uniquely identify the product. It is the serial number for the product. This is typically applicable to tangible products.
   * @return productSerialNumber
  **/
  @ApiModelProperty(value = "Any commercial code string that can be used for internal accounting to uniquely identify the product. It is the serial number for the product. This is typically applicable to tangible products.")
  public String getProductSerialNumber() {
    return productSerialNumber;
  }

  public void setProductSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
  }

  public ProductInstanceRequestType startDate(DateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The date from which the product must start providing service
   * @return startDate
  **/
  @ApiModelProperty(value = "The date from which the product must start providing service")
  public DateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(DateTime startDate) {
    this.startDate = startDate;
  }

  public ProductInstanceRequestType terminationDate(DateTime terminationDate) {
    this.terminationDate = terminationDate;
    return this;
  }

   /**
   * The date when the product will stop providing service
   * @return terminationDate
  **/
  @ApiModelProperty(value = "The date when the product will stop providing service")
  public DateTime getTerminationDate() {
    return terminationDate;
  }

  public void setTerminationDate(DateTime terminationDate) {
    this.terminationDate = terminationDate;
  }

  public ProductInstanceRequestType status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status to which the product has to be set
   * @return status
  **/
  @ApiModelProperty(value = "The status to which the product has to be set")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ProductInstanceRequestType subStatus(String subStatus) {
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

  public ProductInstanceRequestType billingAccount(List<AccountRefType> billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  public ProductInstanceRequestType addBillingAccountItem(AccountRefType billingAccountItem) {
    this.billingAccount.add(billingAccountItem);
    return this;
  }

   /**
   * Reference to the billing accounts that are associated to the product instance. This attribute is an array to allow scenarios where a product or service is shared for payment between different accounts
   * @return billingAccount
  **/
  @ApiModelProperty(value = "Reference to the billing accounts that are associated to the product instance. This attribute is an array to allow scenarios where a product or service is shared for payment between different accounts")
  public List<AccountRefType> getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(List<AccountRefType> billingAccount) {
    this.billingAccount = billingAccount;
  }

  public ProductInstanceRequestType productOffering(EntityRefType productOffering) {
    this.productOffering = productOffering;
    return this;
  }

   /**
   * Reference to the Offering Identifier within the product catalogue that includes the description of the product that has been created for the customer
   * @return productOffering
  **/
  @ApiModelProperty(value = "Reference to the Offering Identifier within the product catalogue that includes the description of the product that has been created for the customer")
  public EntityRefType getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(EntityRefType productOffering) {
    this.productOffering = productOffering;
  }

  public ProductInstanceRequestType productSpec(EntityRefType productSpec) {
    this.productSpec = productSpec;
    return this;
  }

   /**
   * Reference to the Product specification in the product catalogue that provides the description of the characteristics that define the configuration of the product instance
   * @return productSpec
  **/
  @ApiModelProperty(value = "Reference to the Product specification in the product catalogue that provides the description of the characteristics that define the configuration of the product instance")
  public EntityRefType getProductSpec() {
    return productSpec;
  }

  public void setProductSpec(EntityRefType productSpec) {
    this.productSpec = productSpec;
  }

  public ProductInstanceRequestType agreement(List<EntityRefType> agreement) {
    this.agreement = agreement;
    return this;
  }

  public ProductInstanceRequestType addAgreementItem(EntityRefType agreementItem) {
    this.agreement.add(agreementItem);
    return this;
  }

   /**
   * A list of agreement references. An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable by law, such as a service level agreement or a customer price agreement
   * @return agreement
  **/
  @ApiModelProperty(value = "A list of agreement references. An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable by law, such as a service level agreement or a customer price agreement")
  public List<EntityRefType> getAgreement() {
    return agreement;
  }

  public void setAgreement(List<EntityRefType> agreement) {
    this.agreement = agreement;
  }

  public ProductInstanceRequestType characteristic(List<ProductCharacteristicType> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public ProductInstanceRequestType addCharacteristicItem(ProductCharacteristicType characteristicItem) {
    this.characteristic.add(characteristicItem);
    return this;
  }

   /**
   * List of configurable characteristics of the product to instantiate or to modify
   * @return characteristic
  **/
  @ApiModelProperty(value = "List of configurable characteristics of the product to instantiate or to modify")
  public List<ProductCharacteristicType> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<ProductCharacteristicType> characteristic) {
    this.characteristic = characteristic;
  }

  public ProductInstanceRequestType productRelationship(List<RelatedProductType> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public ProductInstanceRequestType addProductRelationshipItem(RelatedProductType productRelationshipItem) {
    this.productRelationship.add(productRelationshipItem);
    return this;
  }

   /**
   * Used to define subproducts composing a bundled product or products already owned by the customer but with a relationship with the one instantiated in the inventory
   * @return productRelationship
  **/
  @ApiModelProperty(value = "Used to define subproducts composing a bundled product or products already owned by the customer but with a relationship with the one instantiated in the inventory")
  public List<RelatedProductType> getProductRelationship() {
    return productRelationship;
  }

  public void setProductRelationship(List<RelatedProductType> productRelationship) {
    this.productRelationship = productRelationship;
  }

  public ProductInstanceRequestType productPrice(List<ComponentProdPriceType> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductInstanceRequestType addProductPriceItem(ComponentProdPriceType productPriceItem) {
    this.productPrice.add(productPriceItem);
    return this;
  }

   /**
   * List of price models applied to the instantiated product
   * @return productPrice
  **/
  @ApiModelProperty(value = "List of price models applied to the instantiated product")
  public List<ComponentProdPriceType> getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(List<ComponentProdPriceType> productPrice) {
    this.productPrice = productPrice;
  }

  public ProductInstanceRequestType paymentMean(EntityRefType paymentMean) {
    this.paymentMean = paymentMean;
    return this;
  }

   /**
   * Reference to the type of payment mode to be used for the product or service
   * @return paymentMean
  **/
  @ApiModelProperty(value = "Reference to the type of payment mode to be used for the product or service")
  public EntityRefType getPaymentMean() {
    return paymentMean;
  }

  public void setPaymentMean(EntityRefType paymentMean) {
    this.paymentMean = paymentMean;
  }

  public ProductInstanceRequestType place(List<EntityRefType> place) {
    this.place = place;
    return this;
  }

  public ProductInstanceRequestType addPlaceItem(EntityRefType placeItem) {
    this.place.add(placeItem);
    return this;
  }

   /**
   * Used to define a place useful for the product (for example an installation site)
   * @return place
  **/
  @ApiModelProperty(value = "Used to define a place useful for the product (for example an installation site)")
  public List<EntityRefType> getPlace() {
    return place;
  }

  public void setPlace(List<EntityRefType> place) {
    this.place = place;
  }

  public ProductInstanceRequestType relatedParty(List<RelatedPartyRefType> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductInstanceRequestType addRelatedPartyItem(RelatedPartyRefType relatedPartyItem) {
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

   /**
   * List of individuals (e.g.: support agent, system impacted, reviewer, ?) associated to the order
   * @return relatedParty
  **/
  @ApiModelProperty(required = true, value = "List of individuals (e.g.: support agent, system impacted, reviewer, ?) associated to the order")
  @NotNull
  @Size(min=0)
  public List<RelatedPartyRefType> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRefType> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductInstanceRequestType relatedObject(List<RelatedObjectType> relatedObject) {
    this.relatedObject = relatedObject;
    return this;
  }

  public ProductInstanceRequestType addRelatedObjectItem(RelatedObjectType relatedObjectItem) {
    this.relatedObject.add(relatedObjectItem);
    return this;
  }

   /**
   * List of Objects or resources associated to an order (e.g.: framework agreement, opportunity, ?
   * @return relatedObject
  **/
  @ApiModelProperty(value = "List of Objects or resources associated to an order (e.g.: framework agreement, opportunity, ?")
  public List<RelatedObjectType> getRelatedObject() {
    return relatedObject;
  }

  public void setRelatedObject(List<RelatedObjectType> relatedObject) {
    this.relatedObject = relatedObject;
  }

  public ProductInstanceRequestType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductInstanceRequestType addAdditionalDataItem(KeyValueType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any further information needed by the server to fill the product definition (implementation and application specific) in the form of name-value pairs. It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any further information needed by the server to fill the product definition (implementation and application specific) in the form of name-value pairs. It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs")
  public List<KeyValueType> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
  }

  public ProductInstanceRequestType callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

   /**
   * An URL that will allow the server to report asynchronously any further modification defined by the server on any of the parameters defining a product previously created. It should be ignored if a provisioned callbackUrl exists (how this callbackUrl has been provisioned is beyond the scope of this specification).
   * @return callbackUrl
  **/
  @ApiModelProperty(value = "An URL that will allow the server to report asynchronously any further modification defined by the server on any of the parameters defining a product previously created. It should be ignored if a provisioned callbackUrl exists (how this callbackUrl has been provisioned is beyond the scope of this specification).")
  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInstanceRequestType productInstanceRequestType = (ProductInstanceRequestType) o;
    return Objects.equals(this.description, productInstanceRequestType.description) &&
        Objects.equals(this.name, productInstanceRequestType.name) &&
        Objects.equals(this.productType, productInstanceRequestType.productType) &&
        Objects.equals(this.category, productInstanceRequestType.category) &&
        Objects.equals(this.isBundle, productInstanceRequestType.isBundle) &&
        Objects.equals(this.isCustomerVisible, productInstanceRequestType.isCustomerVisible) &&
        Objects.equals(this.productSerialNumber, productInstanceRequestType.productSerialNumber) &&
        Objects.equals(this.startDate, productInstanceRequestType.startDate) &&
        Objects.equals(this.terminationDate, productInstanceRequestType.terminationDate) &&
        Objects.equals(this.status, productInstanceRequestType.status) &&
        Objects.equals(this.subStatus, productInstanceRequestType.subStatus) &&
        Objects.equals(this.billingAccount, productInstanceRequestType.billingAccount) &&
        Objects.equals(this.productOffering, productInstanceRequestType.productOffering) &&
        Objects.equals(this.productSpec, productInstanceRequestType.productSpec) &&
        Objects.equals(this.agreement, productInstanceRequestType.agreement) &&
        Objects.equals(this.characteristic, productInstanceRequestType.characteristic) &&
        Objects.equals(this.productRelationship, productInstanceRequestType.productRelationship) &&
        Objects.equals(this.productPrice, productInstanceRequestType.productPrice) &&
        Objects.equals(this.paymentMean, productInstanceRequestType.paymentMean) &&
        Objects.equals(this.place, productInstanceRequestType.place) &&
        Objects.equals(this.relatedParty, productInstanceRequestType.relatedParty) &&
        Objects.equals(this.relatedObject, productInstanceRequestType.relatedObject) &&
        Objects.equals(this.additionalData, productInstanceRequestType.additionalData) &&
        Objects.equals(this.callbackUrl, productInstanceRequestType.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, productType, category, isBundle, isCustomerVisible, productSerialNumber, startDate, terminationDate, status, subStatus, billingAccount, productOffering, productSpec, agreement, characteristic, productRelationship, productPrice, paymentMean, place, relatedParty, relatedObject, additionalData, callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInstanceRequestType {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isCustomerVisible: ").append(toIndentedString(isCustomerVisible)).append("\n");
    sb.append("    productSerialNumber: ").append(toIndentedString(productSerialNumber)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    terminationDate: ").append(toIndentedString(terminationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    productSpec: ").append(toIndentedString(productSpec)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    productRelationship: ").append(toIndentedString(productRelationship)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    paymentMean: ").append(toIndentedString(paymentMean)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedObject: ").append(toIndentedString(relatedObject)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
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

