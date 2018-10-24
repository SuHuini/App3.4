//Author Huini
package e.huini.app3;

public class Hairdresser {

    int hairdresserID;
   String FName,SName, location;
   String email;
   String phone;
   protected String password;

    public Hairdresser (String FName, String SName, String location,
                        String email, String phone, String password) {
        this.FName = FName;
        this.SName = SName;
        this.location = location;

        this.email = email;
        this.phone = phone;

        this.password = password;
    }
    public String getFName() {
        return FName;
    }

    public String getSName() {
        return SName;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }


}
