
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2021-03-18T17:03:18.537-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "RetrieveFriendsAndFamilyNumbersFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class RetrieveFriendsAndFamilyNumbersFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersFault retrieveFriendsAndFamilyNumbersFault;

    public RetrieveFriendsAndFamilyNumbersFault() {
        super();
    }
    
    public RetrieveFriendsAndFamilyNumbersFault(String message) {
        super(message);
    }
    
    public RetrieveFriendsAndFamilyNumbersFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetrieveFriendsAndFamilyNumbersFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersFault retrieveFriendsAndFamilyNumbersFault) {
        super(message);
        this.retrieveFriendsAndFamilyNumbersFault = retrieveFriendsAndFamilyNumbersFault;
    }

    public RetrieveFriendsAndFamilyNumbersFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersFault retrieveFriendsAndFamilyNumbersFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retrieveFriendsAndFamilyNumbersFault = retrieveFriendsAndFamilyNumbersFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersFault getFaultInfo() {
        return this.retrieveFriendsAndFamilyNumbersFault;
    }
}