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
@Table(name = "opportunities")
public class Opportunity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "opportunity_id", nullable = false)
    public String opportunity_id;

    @Column(name = "code", nullable = false)
    public String code;

    @Column(name = "partner_id", nullable = false)
    public String partner_id;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "short_desc", nullable = false)
    public String short_desc;

    @Column(name = "tags", nullable = false)
    public String tags;

    @Column(name = "investment_type", nullable = false)
    public String investment_type;

    @Column(name = "payout_schedule", nullable = false)
    public String payout_schedule;

    @Column(name = "irr_pretax", nullable = false)
    public double irr_pretax;

    @Column(name = "irr_postax", nullable = false)
    public double irr_postax;

    @Column(name = "minimum_investment", nullable = false)
    public double minimum_investment;

    @Column(name = "tenure_in_days", nullable = false)
    public int tenure_in_days;

    @Column(name = "total_capital", nullable = false)
    public double total_capital;

    @Column(name = "current_progress", nullable = false)
    public double current_progress;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "currency", nullable = false)
    public String currency;

    @Column(name = "createdontimestamp", nullable = false)
    @CreationTimestamp
    private Date createdOnTimestamp;

    @Column(name = "lastupdatedtimestamp", nullable = false)
    @UpdateTimestamp
    private Date lastUpdatedTimeStamp;


    public Opportunity(String opportunity_id, String partner_id, String title, String short_desc, String tags,
                       String investment_type, String payout_schedule, double irr_pretax, double irr_postax,
                       double minimum_investment, int tenure_in_days, double total_capital, double current_progress,
                       String state, String currency, String code) {
        this.opportunity_id = opportunity_id;
        this.code = code;
        this.partner_id = partner_id;
        this.title = title;
        this.short_desc = short_desc;
        this.tags = tags;
        this.investment_type = investment_type;
        this.payout_schedule = payout_schedule;
        this.irr_pretax = irr_pretax;
        this.irr_postax = irr_postax;
        this.minimum_investment = minimum_investment;
        this.tenure_in_days = tenure_in_days;
        this.total_capital = total_capital;
        this.current_progress = current_progress;
        this.state = state;
        this.currency = currency;
    }

    public Opportunity() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpportunity_id() {
        return opportunity_id;
    }

    public void setOpportunity_id(String opportunity_id) {
        this.opportunity_id = opportunity_id;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getInvestment_type() {
        return investment_type;
    }

    public void setInvestment_type(String investment_type) {
        this.investment_type = investment_type;
    }

    public String getPayout_schedule() {
        return payout_schedule;
    }

    public void setPayout_schedule(String payout_schedule) {
        this.payout_schedule = payout_schedule;
    }

    public double getIrr_pretax() {
        return irr_pretax;
    }

    public void setIrr_pretax(double irr_pretax) {
        this.irr_pretax = irr_pretax;
    }

    public double getIrr_postax() {
        return irr_postax;
    }

    public void setIrr_postax(double irr_postax) {
        this.irr_postax = irr_postax;
    }

    public double getMinimum_investment() {
        return minimum_investment;
    }

    public void setMinimum_investment(double minimum_investment) {
        this.minimum_investment = minimum_investment;
    }

    public int getTenure_in_days() {
        return tenure_in_days;
    }

    public void setTenure_in_days(int tenure_in_days) {
        this.tenure_in_days = tenure_in_days;
    }

    public double getTotal_capital() {
        return total_capital;
    }

    public void setTotal_capital(double total_capital) {
        this.total_capital = total_capital;
    }

    public double getCurrent_progress() {
        return current_progress;
    }

    public void setCurrent_progress(double current_progress) {
        this.current_progress = current_progress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        Opportunity opportunity = (Opportunity) o;
        return Double.compare(opportunity.irr_pretax, irr_pretax) == 0 &&
                Double.compare(opportunity.irr_postax, irr_postax) == 0 &&
                Double.compare(opportunity.minimum_investment, minimum_investment) == 0 &&
                tenure_in_days == opportunity.tenure_in_days &&
                Double.compare(opportunity.total_capital, total_capital) == 0 &&
                Double.compare(opportunity.current_progress, current_progress) == 0 &&
                Objects.equals(opportunity_id, opportunity.opportunity_id) &&
                Objects.equals(code, opportunity.code) &&
                Objects.equals(partner_id, opportunity.partner_id) &&
                Objects.equals(title, opportunity.title) &&
                Objects.equals(short_desc, opportunity.short_desc) &&
                Objects.equals(tags, opportunity.tags) &&
                Objects.equals(investment_type, opportunity.investment_type) &&
                Objects.equals(payout_schedule, opportunity.payout_schedule) &&
                Objects.equals(state, opportunity.state) &&
                Objects.equals(currency, opportunity.currency) &&
                Objects.equals(createdOnTimestamp, opportunity.createdOnTimestamp) &&
                Objects.equals(lastUpdatedTimeStamp, opportunity.lastUpdatedTimeStamp);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(opportunity_id, code, partner_id, title, short_desc, tags, investment_type,
                        payout_schedule,
                        irr_pretax,
                        irr_postax, minimum_investment, tenure_in_days, total_capital, current_progress, state,
                        currency,
                        createdOnTimestamp, lastUpdatedTimeStamp);
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "opportunity_id='" + opportunity_id + '\'' +
                "code='" + code + '\'' +
                ", partner_id='" + partner_id + '\'' +
                ", title='" + title + '\'' +
                ", short_desc='" + short_desc + '\'' +
                ", tags='" + tags + '\'' +
                ", investment_type='" + investment_type + '\'' +
                ", payout_schedule='" + payout_schedule + '\'' +
                ", irr_pretax=" + irr_pretax +
                ", irr_postax=" + irr_postax +
                ", minimum_investment=" + minimum_investment +
                ", tenure_in_days=" + tenure_in_days +
                ", total_capital=" + total_capital +
                ", current_progress=" + current_progress +
                ", state='" + state + '\'' +
                ", currency='" + currency + '\'' +
                ", createdOnTimestamp=" + createdOnTimestamp +
                ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp +
                '}';
    }

    public Opportunity patch(Opportunity patcher) {
        Arrays.stream(Opportunity.class.getDeclaredFields()).forEach(field -> {
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
}
