package pl.tkosinski.accountingadmin.domain.client;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Builder
@Getter
public class ClientDao extends BaseDao {

    private final long id;
    private String givenName;
    private String lastName;
    private long addressId;

    public ClientDao(long id, String givenName, String lastName, long addressId) {
        this.id = id;
        this.givenName = givenName;
        this.lastName = lastName;
        this.addressId = addressId;
    }

    public ClientDao edit(String givenName, String lastName, long addressId) {
        this.givenName = givenName;
        this.lastName = lastName;
        this.addressId = addressId;
        return this;
    }
}
