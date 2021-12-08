package org.bluemount.adminservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "partners")
public class Partner implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "partner_id", nullable = false)
    public String partner_id;


    @Column(name = "name", nullable = false)
    public String name;


    @Column(name = "partner_desc", nullable = false)
    public String partner_desc;


    @Column(name = "url", nullable = false)
    public String url;


    @Column(name = "referral_code")
    public String referralCode;


    @Column(name = "investment_types", nullable = false)
    public String investmentTypes;


    @Column(name = "minimum_investment")
    public double minimum_investment;


    @Column(name = "createdontimestamp", nullable = false)
    @CreationTimestamp
    private Date createdOnTimestamp;


    @Column(name = "lastupdatedtimestamp", nullable = false)
    @UpdateTimestamp
    private Date lastUpdatedTimeStamp;

    public Partner(String partner_id, String name, String partner_desc, String url, String referralCode,
                   String investmentTypes, double minimum_investment, Date createdOnTimestamp,
                   Date lastUpdatedTimeStamp) {
        this.partner_id = partner_id;
        this.name = name;
        this.partner_desc = partner_desc;
        this.url = url;
        this.referralCode = referralCode;
        this.investmentTypes = investmentTypes;
        this.minimum_investment = minimum_investment;
        this.createdOnTimestamp = createdOnTimestamp;
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartner_desc() {
        return partner_desc;
    }

    public void setPartner_desc(String partner_desc) {
        this.partner_desc = partner_desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getInvestmentTypes() {
        return investmentTypes;
    }

    public void setInvestmentTypes(String investmentTypes) {
        this.investmentTypes = investmentTypes;
    }

    public double getMinimum_investment() {
        return minimum_investment;
    }

    public void setMinimum_investment(double minimum_investment) {
        this.minimum_investment = minimum_investment;
    }

    public Date getCreatedOnTimestamp() {
        return createdOnTimestamp;
    }

    public void setCreatedOnTimestamp(Date createdOnTimestamp) {
        this.createdOnTimestamp = createdOnTimestamp;
    }

    public Date getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public void setLastUpdatedTimeStamp(Date lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Partner partner = (Partner) o;
        return Double.compare(partner.minimum_investment, minimum_investment) == 0 &&
                Objects.equals(partner_id, partner.partner_id) &&
                Objects.equals(name, partner.name) &&
                Objects.equals(partner_desc, partner.partner_desc) &&
                Objects.equals(url, partner.url) &&
                Objects.equals(referralCode, partner.referralCode) &&
                Objects.equals(investmentTypes, partner.investmentTypes) &&
                Objects.equals(createdOnTimestamp, partner.createdOnTimestamp) &&
                Objects.equals(lastUpdatedTimeStamp, partner.lastUpdatedTimeStamp);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(partner_id, name, partner_desc, url, referralCode, investmentTypes, minimum_investment,
                        createdOnTimestamp,
                        lastUpdatedTimeStamp);
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partner_id='" + partner_id + '\'' +
                ", name='" + name + '\'' +
                ", partner_desc='" + partner_desc + '\'' +
                ", url='" + url + '\'' +
                ", referralCode='" + referralCode + '\'' +
                ", investmentTypes='" + investmentTypes + '\'' +
                ", minimum_investment=" + minimum_investment +
                ", createdOnTimestamp=" + createdOnTimestamp +
                ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp +
                '}';
    }

    public Partner patch(Partner patcher) {
        Arrays.stream(Partner.class.getDeclaredFields()).forEach(field -> {
            try {
                if (field.get(patcher) != null) {
                    if (field.getType() == Double.TYPE) {
                        if ((double) field.get(patcher) != 0.0) {
                            field.set(this, field.get(patcher));
                        }
                    } else if (field.getType() == Integer.TYPE) {
                        if ((int) field.get(patcher) != 0) {
                            field.set(this, field.get(patcher));
                        }
                    } else {
                        field.set(this, field.get(patcher));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return this;
    }

    public Partner() {
    }
}
