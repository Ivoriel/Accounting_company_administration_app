package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.Common.BaseDao;

public class CompanyDao extends BaseDao {

    private final long id;
    private String name;
    private long clientId;
    private long addressId;

    public CompanyDao(long id, String name, long clientId, long addressId) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
    }

    public CompanyDao edit(String name, long clientId, long addressId) {
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getClientId() {
        return clientId;
    }

    public long getAddressId() {
        return addressId;
    }
}
