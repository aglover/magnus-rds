package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "account") //required otherwise table is Account
public class Account extends Model {
    public String name;
}
