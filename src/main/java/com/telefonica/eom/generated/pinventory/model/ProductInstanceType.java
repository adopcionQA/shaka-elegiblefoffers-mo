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
import com.telefonica.eom.generated.pinventory.model.PlaceRefType;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import com.telefonica.eom.generated.pinventory.model.RealizingResourceRefType;
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
 * ProductInstanceType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class ProductInstanceType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("publicId")
  private String publicId = null;

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

  @JsonProperty("tags")
  private List<String> tags = new ArrayList<String>();

  @JsonProperty("category")
  private List<CategoryTreeType> category = new ArrayList<CategoryTreeType>();

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("isCustomerVisible")
  private Boolean isCustomerVisible = null;

  @JsonProperty("productSerialNumber")
  private String productSerialNumber = null;

  @JsonProperty("orderDate")
  private DateTime orderDate = null;

  @JsonProperty("creatingOrder")
  private EntityRefType creatingOrder = null;

  @JsonProperty("modifyingOrders")
  private List<EntityRefType> modifyingOrders = new ArrayList<EntityRefType>();

  @JsonProperty("startDate")
  private DateTime startDate = null;

  @JsonProperty("terminationDate")
  private DateTime terminationDate = null;

  /**
   * The status to which the product is set
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

  @JsonProperty("realizingResource")
  private List<RealizingResourceRefType> realizingResource = new ArrayList<RealizingResourceRefType>();

  @JsonProperty("productRelationship")
  private List<RelatedProductType> productRelationship = new ArrayList<RelatedProductType>();

  @JsonProperty("productPrice")
  private List<ComponentProdPriceType> productPrice = new ArrayList<ComponentProdPriceType>();

  @JsonProperty("paymentMean")
  private EntityRefType paymentMean = null;

  @JsonProperty("place")
  private List<PlaceRefType> place = new ArrayList<PlaceRefType>();

  @JsonProperty("relatedParty")
  private List<RelatedPartyRefType> relatedParty = new ArrayList<RelatedPartyRefType>();

  @JsonProperty("relatedObject")
  private List<RelatedObjectType> relatedObject = new ArrayList<RelatedObjectType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public ProductInstanceType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier within the server for the product instance reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique Identifier within the server for the product instance reported")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductInstanceType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: productInventory/v1/products/{productId})
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: productInventory/v1/products/{productId})")
  @NotNull
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductInstanceType publicId(String publicId) {
    this.publicId = publicId;
    return this;
  }

   /**
   * Public number associated to the product (e.g.: use of an msisdn to refer to a subscription to a mobileline product)
   * @return publicId
  **/
  @ApiModelProperty(value = "Public number associated to the product (e.g.: use of an msisdn to refer to a subscription to a mobileline product)")
  public String getPublicId() {
    return publicId;
  }

  public void setPublicId(String publicId) {
    this.publicId = publicId;
  }

  public ProductInstanceType description(String description) {
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

  public ProductInstanceType name(String name) {
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

  public ProductInstanceType productType(ProductTypeEnum productType) {
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

  public ProductInstanceType tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ProductInstanceType addTagsItem(String tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * ist of freely defined strings that tag the product based on some criteria. This can be used by consumer application to define presentation logic
   * @return tags
  **/
  @ApiModelProperty(value = "ist of freely defined strings that tag the product based on some criteria. This can be used by consumer application to define presentation logic")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public ProductInstanceType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public ProductInstanceType addCategoryItem(CategoryTreeType categoryItem) {
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

  public ProductInstanceType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)
   * @return isBundle
  **/
  @ApiModelProperty(value = "Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)")
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductInstanceType isCustomerVisible(Boolean isCustomerVisible) {
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

  public ProductInstanceType productSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
    return this;
  }

   /**
   * Any commercial code string that can be used for internal accounting to uniquely identify the product. It is the serial number for the product. This is typically applicable to tangible products
   * @return productSerialNumber
  **/
  @ApiModelProperty(value = "Any commercial code string that can be used for internal accounting to uniquely identify the product. It is the serial number for the product. This is typically applicable to tangible products")
  public String getProductSerialNumber() {
    return productSerialNumber;
  }

  public void setProductSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
  }

  public ProductInstanceType orderDate(DateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

   /**
   * The date when the product was created, when the order that triggered the product creation was registered
   * @return orderDate
  **/
  @ApiModelProperty(value = "The date when the product was created, when the order that triggered the product creation was registered")
  public DateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(DateTime orderDate) {
    this.orderDate = orderDate;
  }

  public ProductInstanceType creatingOrder(EntityRefType creatingOrder) {
    this.creatingOrder = creatingOrder;
    return this;
  }

   /**
   * Reference to the order which created the product instance in the server
   * @return creatingOrder
  **/
  @ApiModelProperty(value = "Reference to the order which created the product instance in the server")
  public EntityRefType getCreatingOrder() {
    return creatingOrder;
  }

  public void setCreatingOrder(EntityRefType creatingOrder) {
    this.creatingOrder = creatingOrder;
  }

  public ProductInstanceType modifyingOrders(List<EntityRefType> modifyingOrders) {
    this.modifyingOrders = modifyingOrders;
    return this;
  }

  public ProductInstanceType addModifyingOrdersItem(EntityRefType modifyingOrdersItem) {
    this.modifyingOrders.add(modifyingOrdersItem);
    return this;
  }

   /**
   * Reference to the orders that modified the product instance in the server
   * @return modifyingOrders
  **/
  @ApiModelProperty(value = "Reference to the orders that modified the product instance in the server")
  public List<EntityRefType> getModifyingOrders() {
    return modifyingOrders;
  }

  public void setModifyingOrders(List<EntityRefType> modifyingOrders) {
    this.modifyingOrders = modifyingOrders;
  }

  public ProductInstanceType startDate(DateTime startDate) {
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

  public ProductInstanceType terminationDate(DateTime terminationDate) {
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

  public ProductInstanceType status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status to which the product is set
   * @return status
  **/
  @ApiModelProperty(value = "The status to which the product is set")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ProductInstanceType subStatus(String subStatus) {
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

  public ProductInstanceType billingAccount(List<AccountRefType> billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  public ProductInstanceType addBillingAccountItem(AccountRefType billingAccountItem) {
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

  public ProductInstanceType productOffering(EntityRefType productOffering) {
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

  public ProductInstanceType productSpec(EntityRefType productSpec) {
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

  public ProductInstanceType agreement(List<EntityRefType> agreement) {
    this.agreement = agreement;
    return this;
  }

  public ProductInstanceType addAgreementItem(EntityRefType agreementItem) {
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

  public ProductInstanceType characteristic(List<ProductCharacteristicType> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public ProductInstanceType addCharacteristicItem(ProductCharacteristicType characteristicItem) {
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

  public ProductInstanceType realizingResource(List<RealizingResourceRefType> realizingResource) {
    this.realizingResource = realizingResource;
    return this;
  }

  public ProductInstanceType addRealizingResourceItem(RealizingResourceRefType realizingResourceItem) {
    this.realizingResource.add(realizingResourceItem);
    return this;
  }

   /**
   * Reference to the resources that are created/associated as part of the instantiation of the product
   * @return realizingResource
  **/
  @ApiModelProperty(value = "Reference to the resources that are created/associated as part of the instantiation of the product")
  public List<RealizingResourceRefType> getRealizingResource() {
    return realizingResource;
  }

  public void setRealizingResource(List<RealizingResourceRefType> realizingResource) {
    this.realizingResource = realizingResource;
  }

  public ProductInstanceType productRelationship(List<RelatedProductType> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public ProductInstanceType addProductRelationshipItem(RelatedProductType productRelationshipItem) {
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

  public ProductInstanceType productPrice(List<ComponentProdPriceType> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductInstanceType addProductPriceItem(ComponentProdPriceType productPriceItem) {
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

  public ProductInstanceType paymentMean(EntityRefType paymentMean) {
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

  public ProductInstanceType place(List<PlaceRefType> place) {
    this.place = place;
    return this;
  }

  public ProductInstanceType addPlaceItem(PlaceRefType placeItem) {
    this.place.add(placeItem);
    return this;
  }

   /**
   * Used to define a place useful for the product (for example an installation site)
   * @return place
  **/
  @ApiModelProperty(value = "Used to define a place useful for the product (for example an installation site)")
  public List<PlaceRefType> getPlace() {
    return place;
  }

  public void setPlace(List<PlaceRefType> place) {
    this.place = place;
  }

  public ProductInstanceType relatedParty(List<RelatedPartyRefType> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductInstanceType addRelatedPartyItem(RelatedPartyRefType relatedPartyItem) {
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

  public ProductInstanceType relatedObject(List<RelatedObjectType> relatedObject) {
    this.relatedObject = relatedObject;
    return this;
  }

  public ProductInstanceType addRelatedObjectItem(RelatedObjectType relatedObjectItem) {
    this.relatedObject.add(relatedObjectItem);
    return this;
  }

   /**
   * List of Objects or resources associated to an order (e.g.: framework agreement, opportunity, ?)
   * @return relatedObject
  **/
  @ApiModelProperty(value = "List of Objects or resources associated to an order (e.g.: framework agreement, opportunity, ?)")
  public List<RelatedObjectType> getRelatedObject() {
    return relatedObject;
  }

  public void setRelatedObject(List<RelatedObjectType> relatedObject) {
    this.relatedObject = relatedObject;
  }

  public ProductInstanceType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductInstanceType addAdditionalDataItem(KeyValueType additionalDataItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInstanceType productInstanceType = (ProductInstanceType) o;
    return Objects.equals(this.id, productInstanceType.id) &&
        Objects.equals(this.href, productInstanceType.href) &&
        Objects.equals(this.publicId, productInstanceType.publicId) &&
        Objects.equals(this.description, productInstanceType.description) &&
        Objects.equals(this.name, productInstanceType.name) &&
        Objects.equals(this.productType, productInstanceType.productType) &&
        Objects.equals(this.tags, productInstanceType.tags) &&
        Objects.equals(this.category, productInstanceType.category) &&
        Objects.equals(this.isBundle, productInstanceType.isBundle) &&
        Objects.equals(this.isCustomerVisible, productInstanceType.isCustomerVisible) &&
        Objects.equals(this.productSerialNumber, productInstanceType.productSerialNumber) &&
        Objects.equals(this.orderDate, productInstanceType.orderDate) &&
        Objects.equals(this.creatingOrder, productInstanceType.creatingOrder) &&
        Objects.equals(this.modifyingOrders, productInstanceType.modifyingOrders) &&
        Objects.equals(this.startDate, productInstanceType.startDate) &&
        Objects.equals(this.terminationDate, productInstanceType.terminationDate) &&
        Objects.equals(this.status, productInstanceType.status) &&
        Objects.equals(this.subStatus, productInstanceType.subStatus) &&
        Objects.equals(this.billingAccount, productInstanceType.billingAccount) &&
        Objects.equals(this.productOffering, productInstanceType.productOffering) &&
        Objects.equals(this.productSpec, productInstanceType.productSpec) &&
        Objects.equals(this.agreement, productInstanceType.agreement) &&
        Objects.equals(this.characteristic, productInstanceType.characteristic) &&
        Objects.equals(this.realizingResource, productInstanceType.realizingResource) &&
        Objects.equals(this.productRelationship, productInstanceType.productRelationship) &&
        Objects.equals(this.productPrice, productInstanceType.productPrice) &&
        Objects.equals(this.paymentMean, productInstanceType.paymentMean) &&
        Objects.equals(this.place, productInstanceType.place) &&
        Objects.equals(this.relatedParty, productInstanceType.relatedParty) &&
        Objects.equals(this.relatedObject, productInstanceType.relatedObject) &&
        Objects.equals(this.additionalData, productInstanceType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, publicId, description, name, productType, tags, category, isBundle, isCustomerVisible, productSerialNumber, orderDate, creatingOrder, modifyingOrders, startDate, terminationDate, status, subStatus, billingAccount, productOffering, productSpec, agreement, characteristic, realizingResource, productRelationship, productPrice, paymentMean, place, relatedParty, relatedObject, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInstanceType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    publicId: ").append(toIndentedString(publicId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isCustomerVisible: ").append(toIndentedString(isCustomerVisible)).append("\n");
    sb.append("    productSerialNumber: ").append(toIndentedString(productSerialNumber)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    creatingOrder: ").append(toIndentedString(creatingOrder)).append("\n");
    sb.append("    modifyingOrders: ").append(toIndentedString(modifyingOrders)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    terminationDate: ").append(toIndentedString(terminationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    productSpec: ").append(toIndentedString(productSpec)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    realizingResource: ").append(toIndentedString(realizingResource)).append("\n");
    sb.append("    productRelationship: ").append(toIndentedString(productRelationship)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    paymentMean: ").append(toIndentedString(paymentMean)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedObject: ").append(toIndentedString(relatedObject)).append("\n");
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

