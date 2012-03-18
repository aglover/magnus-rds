package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "location")
public class Location extends Model {

    public BigDecimal latitude;
    public BigDecimal longitude;
    public String name;
    @Column(name = "date_time")
    public Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name="account_id", nullable = false)
    public Account account;

}
