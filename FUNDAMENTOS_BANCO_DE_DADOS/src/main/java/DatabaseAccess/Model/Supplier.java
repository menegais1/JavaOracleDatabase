package DatabaseAccess.Model;


import java.sql.ResultSet;


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
}
