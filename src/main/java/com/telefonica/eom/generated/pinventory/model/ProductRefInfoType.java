package com.telefonica.eom.generated.pinventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eom.generated.pinventory.model.CategoryTreeType;
import com.telefonica.eom.generated.pinventory.model.ComponentProdPriceType;
import com.telefonica.eom.generated.pinventory.model.EntityRefType;
import com.telefonica.eom.generated.pinventory.model.KeyValueType;
import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
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
 * ProductRefInfoType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-23T10:05:01.944-05:00")

public class ProductRefInfoType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("publicId")
  private String publicId = null;

  @JsonProperty("description")
  private String description = null;

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

  @JsonProperty("startDate")
  private DateTime startDate = null;

  @JsonProperty("terminationDate")
  private DateTime terminationDate = null;

  @JsonProperty("place")
  private List<EntityRefType> place = new ArrayList<EntityRefType>();

  @JsonProperty("productSpec")
  private EntityRefType productSpec = null;

  @JsonProperty("characteristic")
  private List<ProductCharacteristicType> characteristic = new ArrayList<ProductCharacteristicType>();

  @JsonProperty("productPrice")
  private List<ComponentProdPriceType> productPrice = new ArrayList<ComponentProdPriceType>();

  @JsonProperty("relatedParty")
  private List<RelatedPartyRefType> relatedParty = new ArrayList<RelatedPartyRefType>();

  @JsonProperty("productRelationship")
  private List<RelatedProductType> productRelationship = new ArrayList<RelatedProductType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public ProductRefInfoType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier within the server (product inventory) for the product instance that is associated to an account
   * @return id
  **/
  @ApiModelProperty(value = "Unique Identifier within the server (product inventory) for the product instance that is associated to an account")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductRefInfoType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: /productinventory/v1/products/{productId})
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: /productinventory/v1/products/{productId})")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductRefInfoType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable product name
   * @return name
  **/
  @ApiModelProperty(value = "A human readable product name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductRefInfoType publicId(String publicId) {
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

  public ProductRefInfoType description(String description) {
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

  public ProductRefInfoType productType(ProductTypeEnum productType) {
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

  public ProductRefInfoType tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ProductRefInfoType addTagsItem(String tagsItem) {
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

  public ProductRefInfoType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public ProductRefInfoType addCategoryItem(CategoryTreeType categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * A class defining the type of product instantiated (the category allocated to the product specification that defines the instantiated product). A product may belong to more than one class
   * @return category
  **/
  @ApiModelProperty(value = "A class defining the type of product instantiated (the category allocated to the product specification that defines the instantiated product). A product may belong to more than one class")
  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public ProductRefInfoType startDate(DateTime startDate) {
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

  public ProductRefInfoType terminationDate(DateTime terminationDate) {
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

  public ProductRefInfoType place(List<EntityRefType> place) {
    this.place = place;
    return this;
  }

  public ProductRefInfoType addPlaceItem(EntityRefType placeItem) {
    this.place.add(placeItem);
    return this;
  }

   /**
   * Used to define a place useful for the product (for example a delivery geographical place). It is an array because a given product could be delivered in different places, for instance if the quantity is more than 1, and/or it can be associated to different places, on for delivery and another one for installation
   * @return place
  **/
  @ApiModelProperty(value = "Used to define a place useful for the product (for example a delivery geographical place). It is an array because a given product could be delivered in different places, for instance if the quantity is more than 1, and/or it can be associated to different places, on for delivery and another one for installation")
  public List<EntityRefType> getPlace() {
    return place;
  }

  public void setPlace(List<EntityRefType> place) {
    this.place = place;
  }

  public ProductRefInfoType productSpec(EntityRefType productSpec) {
    this.productSpec = productSpec;
    return this;
  }

   /**
   * Reference to the Product specification in the product catalogue that provides the description of the characteristics that define the configuration of a product associated to an account
   * @return productSpec
  **/
  @ApiModelProperty(value = "Reference to the Product specification in the product catalogue that provides the description of the characteristics that define the configuration of a product associated to an account")
  public EntityRefType getProductSpec() {
    return productSpec;
  }

  public void setProductSpec(EntityRefType productSpec) {
    this.productSpec = productSpec;
  }

  public ProductRefInfoType characteristic(List<ProductCharacteristicType> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public ProductRefInfoType addCharacteristicItem(ProductCharacteristicType characteristicItem) {
    this.characteristic.add(characteristicItem);
    return this;
  }

   /**
   * List of specific product parameters configured for the product instance associated to an account
   * @return characteristic
  **/
  @ApiModelProperty(value = "List of specific product parameters configured for the product instance associated to an account")
  public List<ProductCharacteristicType> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<ProductCharacteristicType> characteristic) {
    this.characteristic = characteristic;
  }

  public ProductRefInfoType productPrice(List<ComponentProdPriceType> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductRefInfoType addProductPriceItem(ComponentProdPriceType productPriceItem) {
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

  public ProductRefInfoType relatedParty(List<RelatedPartyRefType> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductRefInfoType addRelatedPartyItem(RelatedPartyRefType relatedPartyItem) {
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

   /**
   * List of individuals (e.g.: user, ?) associated to a product instance
   * @return relatedParty
  **/
  @ApiModelProperty(value = "List of individuals (e.g.: user, ?) associated to a product instance")
  public List<RelatedPartyRefType> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRefType> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductRefInfoType productRelationship(List<RelatedProductType> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public ProductRefInfoType addProductRelationshipItem(RelatedProductType productRelationshipItem) {
    this.productRelationship.add(productRelationshipItem);
    return this;
  }

   /**
   * Used to define subproducts composing a bundled product or products already owned by the customer but with a relationship with the one included in the order
   * @return productRelationship
  **/
  @ApiModelProperty(value = "Used to define subproducts composing a bundled product or products already owned by the customer but with a relationship with the one included in the order")
  public List<RelatedProductType> getProductRelationship() {
    return productRelationship;
  }

  public void setProductRelationship(List<RelatedProductType> productRelationship) {
    this.productRelationship = productRelationship;
  }

  public ProductRefInfoType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductRefInfoType addAdditionalDataItem(KeyValueType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any further information needed by the server to fill the product ref definition (implementation and application specific) in the form of name-value pairs. It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any further information needed by the server to fill the product ref definition (implementation and application specific) in the form of name-value pairs. It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs")
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
    ProductRefInfoType productRefInfoType = (ProductRefInfoType) o;
    return Objects.equals(this.id, productRefInfoType.id) &&
        Objects.equals(this.href, productRefInfoType.href) &&
        Objects.equals(this.name, productRefInfoType.name) &&
        Objects.equals(this.publicId, productRefInfoType.publicId) &&
        Objects.equals(this.description, productRefInfoType.description) &&
        Objects.equals(this.productType, productRefInfoType.productType) &&
        Objects.equals(this.tags, productRefInfoType.tags) &&
        Objects.equals(this.category, productRefInfoType.category) &&
        Objects.equals(this.startDate, productRefInfoType.startDate) &&
        Objects.equals(this.terminationDate, productRefInfoType.terminationDate) &&
        Objects.equals(this.place, productRefInfoType.place) &&
        Objects.equals(this.productSpec, productRefInfoType.productSpec) &&
        Objects.equals(this.characteristic, productRefInfoType.characteristic) &&
        Objects.equals(this.productPrice, productRefInfoType.productPrice) &&
        Objects.equals(this.relatedParty, productRefInfoType.relatedParty) &&
        Objects.equals(this.productRelationship, productRefInfoType.productRelationship) &&
        Objects.equals(this.additionalData, productRefInfoType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, publicId, description, productType, tags, category, startDate, terminationDate, place, productSpec, characteristic, productPrice, relatedParty, productRelationship, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRefInfoType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    publicId: ").append(toIndentedString(publicId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    terminationDate: ").append(toIndentedString(terminationDate)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    productSpec: ").append(toIndentedString(productSpec)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    productRelationship: ").append(toIndentedString(productRelationship)).append("\n");
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

