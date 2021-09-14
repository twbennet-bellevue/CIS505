/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_3.CustomerAccountApp;

public class CustomerDB {
    
    public static Customer getCustomer(int id) {

        Customer newCustomerObj = new Customer();

        if (id == 1007) {
            newCustomerObj = new Customer("Tim","322 South Haven St.","St. Charles","86502");
        } else if (id == 1008) {
            newCustomerObj = new Customer("Burt", "1990 West Burlington Ave.", "Hastings", "12020");
        } else if (id == 1009) {
            newCustomerObj = new Customer("Ruth", "454 Fox Creek Ct.","Bloomington", "61820");
        }

        return newCustomerObj;
    }

}
