package com.telefonica.eom.generated.api;

import org.joda.time.DateTime;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceRequestType;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceStatusRequestType;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceStatusType;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceType;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-22T08:08:46.428-05:00")

@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "Create new product instance", notes = "", response = ProductInstanceType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Product Instance created in server", response = ProductInstanceType.class),
        @ApiResponse(code = 202, message = "Product instance creation in progress", response = ProductInstanceType.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ProductInstanceType> createProductInstance(@ApiParam(value = "The information required to create a product instance" ,required=true ) @RequestBody ProductInstanceRequestType productInstanceCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization);


    @ApiOperation(value = "Modifies the status of a single product instance stored in server inventory", notes = "", response = ProductInstanceStatusType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status of a product order", response = ProductInstanceStatusType.class) })
    @RequestMapping(value = "/products/{productId}/status",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<ProductInstanceStatusType> modifyStatusOfSingleProductInstance(@ApiParam(value = "ID of the product instance",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "The information required to modify the status of a product instance" ,required=true ) @RequestBody ProductInstanceStatusRequestType productInstanceStatus,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization);


    @ApiOperation(value = "Retrieve list of products in inventory", notes = "", response = ProductInstanceType.class, responseContainer = "List", tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of product instances provided", response = ProductInstanceType.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ProductInstanceType>> retrieveProductInstances(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization,
         @ApiParam(value = "To obtain the list of products stored in the server that are of a given type") @RequestParam(value = "type", required = false) String type,
         @ApiParam(value = "To obtain the list of products stored in the server that are of a given type. This is the same as filter query param type but it has been introduced to keep the name used within the datamodel") @RequestParam(value = "productType", required = false) String productType,
         @ApiParam(value = "to obtain the list of products associated with a given name") @RequestParam(value = "name", required = false) String name,
         @ApiParam(value = "to obtain the list of products associated with a given public identifier (e.g.: an msisdn subscription id)") @RequestParam(value = "publicId", required = false) String publicId,
         @ApiParam(value = "to obtain the list of products that are either single product (?false?) or bundle of a set of single products (?true?)") @RequestParam(value = "isBundle", required = false) Boolean isBundle,
         @ApiParam(value = "to obtain the list of products that are visible by the customer (?true?) or not visible (?false?)") @RequestParam(value = "isCustomerVisible", required = false) Boolean isCustomerVisible,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given account") @RequestParam(value = "billingAccountId", required = false) String billingAccountId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given product offering identified by an id") @RequestParam(value = "productOfferingId", required = false) String productOfferingId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given product offering identified by a name") @RequestParam(value = "productOfferingName", required = false) String productOfferingName,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given product spec identified by an id") @RequestParam(value = "productSpecId", required = false) String productSpecId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given product spec identified by a name") @RequestParam(value = "productSpecName", required = false) String productSpecName,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given site identified by an id") @RequestParam(value = "placeId", required = false) String placeId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given site identified by a name") @RequestParam(value = "placeName", required = false) String placeName,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given party entity of a specific type (e.g.: customer, agent)") @RequestParam(value = "relatedPartyRole", required = false) String relatedPartyRole,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given party identified by an id. This is typically combined with relatedParty.role to query for an specific related entity") @RequestParam(value = "relatedPartyId", required = false) String relatedPartyId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given party identified by a name. This is typically combined with relatedParty.role to query for an specific related entity") @RequestParam(value = "relatedPartyName", required = false) String relatedPartyName,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given resource identified by an id. This is typically combined with realizingResource.type to query for an specific related resource entity") @RequestParam(value = "realizingResourceId", required = false) String realizingResourceId,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given resource type. This is typically combined with realizingResource.id to query for an specific related resource entity") @RequestParam(value = "realizingResourceType", required = false) String realizingResourceType,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given entity of an specific type (e.g.: opportunity, framework agreement)") @RequestParam(value = "relatedObjectInvolvement", required = false) String relatedObjectInvolvement,
         @ApiParam(value = "To obtain the list of products stored in the server that are associated to a given entity. This is typically combined with relatedObject.involvement to query for an specific related entity") @RequestParam(value = "relatedObjectReference", required = false) String relatedObjectReference,
         @ApiParam(value = "To obtain the list of products stored in the server with an specific status", allowableValues = "NEW, CREATED, ACTIVE, PENDING, ABORTED, SUSPENDED, CANCELLED, CANCELLING, TERMINATED, TERMINATING, INFORMATION, TRIAL, KEEP") @RequestParam(value = "status", required = false) String status,
         @ApiParam(value = "To obtain list of products stored in the server with an specific sub-status") @RequestParam(value = "subStatus", required = false) String subStatus,
         @ApiParam(value = "To retrieve products that were created after this date") @RequestParam(value = "startCreationDate", required = false) DateTime startCreationDate,
         @ApiParam(value = "To retrieve products that were created before this date") @RequestParam(value = "endCreationDate", required = false) DateTime endCreationDate,
         @ApiParam(value = "To retrieve products that were terminated or will be terminated after this date") @RequestParam(value = "startTerminationDate", required = false) DateTime startTerminationDate,
         @ApiParam(value = "To retrieve products that were terminated or will be terminated before this date") @RequestParam(value = "endTerminationDate", required = false) DateTime endTerminationDate,
         @ApiParam(value = "To obtain the list of products bound to a certain order Id") @RequestParam(value = "orderId", required = false) String orderId,
         @ApiParam(value = "To obtain the list of products bound to a certain orderAction Id") @RequestParam(value = "orderActionId", required = false) String orderActionId,
         @ApiParam(value = "To obtain the list of products matching to a given legal identification value. Typically used combined with nationalIdType") @RequestParam(value = "nationalId", required = false) String nationalId,
         @ApiParam(value = "To obtain the list of products matching to a given legal identification type (e.g.: DNI, passport, social security number, RUT, CPF, driver's license, etc.). This is typically combined with nationalID to query for specific identity") @RequestParam(value = "nationalIdType", required = false) String nationalIdType,
         @ApiParam(value = "To retrieve only subproducts until a certain level. Must be 1 or greater. Depth=1 means the root product does not contain productRelationship, depth=2 means the level 1 products (root's children) do not contain productRelationship... If not sent, maximum depth is assumed") @RequestParam(value = "depth", required = false) Integer depth,
         @ApiParam(value = "To apply a filter on every resource received in the response so they only contain the specified fields") @RequestParam(value = "fields", required = false) String fields,
         @ApiParam(value = "To limit the amount of results") @RequestParam(value = "limit", required = false) String limit,
         @ApiParam(value = "To get the results starting from an offset value. Use for pagination") @RequestParam(value = "offset", required = false) String offset);


    @ApiOperation(value = "Retrieve amount of products in inventory that belong to a customer", notes = "", response = Void.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Amount of products within the search", response = Void.class) })
    @RequestMapping(value = "/products",
        method = RequestMethod.HEAD)
    ResponseEntity<Void> retrieveProductsAmount(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization,
         @ApiParam(value = "to obtain the list of products associated with a certain customer") @RequestParam(value = "customerId", required = false) String customerId,
         @ApiParam(value = "to obtain the list of products associated with a certain customer using its external id") @RequestParam(value = "customerCorrelationId", required = false) String customerCorrelationId);


    @ApiOperation(value = "Retrieve details of a single product instance in the server", notes = "", response = ProductInstanceType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Details of a product instance", response = ProductInstanceType.class) })
    @RequestMapping(value = "/products/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ProductInstanceType> retrieveSingleProductInstance(@ApiParam(value = "ID of the product instance",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization,
         @ApiParam(value = "To apply specific filter in the response ") @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "Retrieve status info of a single product instance stored in server inventory", notes = "", response = ProductInstanceStatusType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status of a product order", response = ProductInstanceStatusType.class) })
    @RequestMapping(value = "/products/{productId}/status",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ProductInstanceStatusType> retrieveStatusOfSingleProductInstance(@ApiParam(value = "ID of the product instance",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization);


    @ApiOperation(value = "Update existing product instance", notes = "", response = ProductInstanceType.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Product instance updated in server", response = ProductInstanceType.class),
        @ApiResponse(code = 202, message = "Product instance modification in progress", response = ProductInstanceType.class) })
    @RequestMapping(value = "/products/{productId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ProductInstanceType> updateProductInstance(@ApiParam(value = "ID of the product instance",required=true ) @PathVariable("productId") String productId,
        @ApiParam(value = "The information required to modify a product instance" ,required=true ) @RequestBody ProductInstanceRequestType productInstanceCreate,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization);

}
