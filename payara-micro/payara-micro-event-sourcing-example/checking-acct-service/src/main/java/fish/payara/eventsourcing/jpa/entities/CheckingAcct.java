package fish.payara.eventsourcing.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "CHECKING_ACCT")
@Entity
@NamedQuery(name = "CheckingAcct.findByAcctNbr", query = "SELECT ca FROM CheckingAcct ca where ca.acctNbr = :acctNbr")
public class CheckingAcct implements Serializable {

    @ManyToOne(optional = false)
    @NotNull
    private AcctHolder acctHolder;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ACCT_NBR")
    private Long acctNbr;

    @Column(name = "ACCT_BALANCE")
    private Double acctBalance;

    @Column(name = "SAVINGS_ACCT_NBR")
    private Long savingsAcctNbr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcctHolder getAcctHolder() {
        return acctHolder;
    }

    public void setAcctHolder(AcctHolder acctHolder) {
        this.acctHolder = acctHolder;
    }

    public Long getAcctNbr() {
        return acctNbr;
    }

    public void setAcctNbr(Long acctNbr) {
        this.acctNbr = acctNbr;
    }

    public Double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(Double acctBalance) {
        this.acctBalance = acctBalance;
    }

    public Long getSavingsAcctNbr() {
        return savingsAcctNbr;
    }

    public void setSavingsAcctNbr(Long savingsAcctNbr) {
        this.savingsAcctNbr = savingsAcctNbr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckingAcct)) {
            return false;
        }
        CheckingAcct other = (CheckingAcct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CheckingAcct{" + "acctHolder=" + acctHolder + ", id=" + id + ", acctNbr=" + acctNbr + ", acctBalance=" + acctBalance + ", savingsAcctNbr=" + savingsAcctNbr + '}';
    }

}
