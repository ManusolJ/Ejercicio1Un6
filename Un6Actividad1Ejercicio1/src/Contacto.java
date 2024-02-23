public class Contacto {

    private String contacto;

    private String phoneNumber;

    public Contacto(String contacto,String phoneNumber){
        this.contacto = contacto;
        this.phoneNumber = phoneNumber;
    }

    public String getContacto(){
        return contacto;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public static Contacto createContacto(String phoneNumber,String contacto){
        return new Contacto(phoneNumber,contacto);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "contacto='" + contacto + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
