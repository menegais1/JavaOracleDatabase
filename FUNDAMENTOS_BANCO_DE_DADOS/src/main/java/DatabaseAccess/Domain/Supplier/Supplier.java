package DatabaseAccess.Domain.Supplier;


import DatabaseAccess.Domain.Base.Entity;

import java.sql.ResultSet;
import java.util.List;


public class Supplier extends Entity<Supplier> {

    public Long id;
    public String name;
    public String CNPJ;
    public String city;
    public String country;
    public String UF;
    public String address;
    public String phone;
    public String email;

    public Supplier(ResultSet result) {
        super(result);
    }

    public Supplier() {
        super();
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(), null);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CPF_CNPJ='" + CNPJ + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", UF='" + UF + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
