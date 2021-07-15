package com.telefonica.eom.generated.api;

import com.telefonica.eom.generated.pinventory.model.ProductCharacteristicType;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceType;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-22T08:08:46.428-05:00")

@Controller
public class ProductTypeApiController implements ProductTypeApi {



    public ResponseEntity<ProductInstanceType> updateProductInstanceCharacteristic(@ApiParam(value = "Type of the product instance",required=true, allowableValues="{values=[mobile, landline, ipTv, cableTv, broadband, bundle, sva, sim, device, bolton, dth, streamingTv], enumVars=[{name=MOBILE, value='mobile'}, {name=LANDLINE, value='landline'}, {name=IPTV, value='ipTv'}, {name=CABLETV, value='cableTv'}, {name=BROADBAND, value='broadband'}, {name=BUNDLE, value='bundle'}, {name=SVA, value='sva'} {name=SIM, value='sim'}, {name=DEVICE, value='device'}, {name=BOLTON, value='bolton'}, {name=DTH, value='dth'}, {name=STREAMINGTV, value='streamingTv'}]}" ) @PathVariable("productType") String productType,
        @ApiParam(value = "Public ID of the product instance. Typically a MSISDN, uniqueId, etc.",required=true ) @PathVariable("publicId") String publicId,
        @ApiParam(value = "Name of the characteristic to be modified",required=true ) @PathVariable("characteristic") String characteristic,
        @ApiParam(value = "The information required to modify a product instance characteristic. Data type depends on the characteristic and is implementation specific. Overriding this swagger with a polymorphic pattern for each characteristic is recommended. So far, only Mobile quota, tv packages and internet connection characteristics are represented, but this could be extended if required" ,required=true ) @RequestBody ProductCharacteristicType productInstanceCharacteristic,
        @ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment"  ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,
        @ApiParam(value = "Identifier for the system originating the request"  ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,
        @ApiParam(value = "Unique identifier for the process or execution flow"  ) @RequestHeader(value="UNICA-PID", required=false) String UNICA_PID,
        @ApiParam(value = "Identifies the user when the request is received from a trusted application and no end user authorization token is used but just an application token"  ) @RequestHeader(value="UNICA-User", required=false) String unICAUser,
        @ApiParam(value = "Including the proof of access (using OAuth2.0 security model) to guarantee that the consumer has privileges to access the entity database"  ) @RequestHeader(value="Authorization", required=false) String authorization) {
        // do some magic!
        return new ResponseEntity<ProductInstanceType>(HttpStatus.OK);
    }

}
