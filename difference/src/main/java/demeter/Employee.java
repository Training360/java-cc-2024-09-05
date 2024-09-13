package demeter;

import java.util.List;

public class Employee {

    private String name;

    private List<Address> addresses;

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
