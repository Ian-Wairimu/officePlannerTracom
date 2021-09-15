package ke.co.tracom.officeplanner.organization;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organization {
    @Id
    private Long orgId;
    private String orgName;

    public Organization() {
    }

    public Organization(Long orgId, String orgName) {
        this.orgId = orgId;
        this.orgName = orgName;
    }

    public Organization(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
