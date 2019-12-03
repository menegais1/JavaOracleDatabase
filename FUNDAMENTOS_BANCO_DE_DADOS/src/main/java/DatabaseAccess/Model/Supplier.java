package DatabaseAccess.Model;


import java.sql.ResultSet;
import java.util.List;


public class Supplier extends Entity<Supplier> {

    public Long id;
    public String name;
    public String CPF_CNPJ;
    public String city;
    public String country;
    public String UF;
    public String address;
    public String phone;
    public String email;
    public String person_type;

    public Supplier(ResultSet result) {
        super(result);
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CPF_CNPJ='" + CPF_CNPJ + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", UF='" + UF + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", person_type='" + person_type + '\'' +
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

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
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

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }
}
