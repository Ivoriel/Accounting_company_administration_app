package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.Common.BaseDao;

public class ClientDao extends BaseDao {

    private final long id;
    private String name;
    private long addressId;

    public ClientDao(long id, String name, long addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public ClientDao edit(String name, long addressId) {
        this.name = name;
        this.addressId = addressId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAddressId() {
        return addressId;
    }
}
