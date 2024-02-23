import java.util.ArrayList;
import java.util.Scanner;

public class telefonoMovil {
    Scanner sc = new Scanner(System.in);
    private String myNumber;

    private ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public telefonoMovil(String myNumber){
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contacto contacto){
        if(comprobarExistencia(contacto)){
            System.out.println("Este contacto ya existe.");
            return false;
        }
        else{
            myContacts.add(contacto);
            System.out.println("Contacto agregado.");
        }
        return true;
    }

    public boolean updateContact(Contacto oldContact,Contacto newContact){
        for(int i = 0;i < myContacts.size();i++){
            if(!comprobarExistencia(oldContact)){
                System.out.println("Este contacto no existe.");
                return false;
            }
            else if(comprobarExistencia(newContact)){
                System.out.println("Este contacto ya existe.");
                return false;
            }
        }
            myContacts.set(findContact(oldContact), newContact);
            System.out.println("Contacto modificado con exito.");
            return true;
            /*comprobar*/
    }

    public boolean removeContact(Contacto c){
        if(findContactByName(c.getContacto()) < 0){
            System.out.println("Este contacto no existe.");
            return false;
        }
        else myContacts.remove(findContact(c));
        System.out.println("Contacto eleminado.");
        return true;
    }


    private int findContact(Contacto contacto){
        return myContacts.indexOf(contacto);
    }

    private int findContactByName(String nombre){
        int index = 0;
        for(int i = 0;i < myContacts.size();i++){
            if(myContacts.get(i).getContacto().equalsIgnoreCase(nombre)){
                index = i;
            }
        }
        return index;
    }
    public Contacto queryContact(String nombre){
        Contacto c;
        c = myContacts.get(findContactByName(nombre));
        return c;
    }

    public void printContacts(){
        System.out.println("Tienes " + myContacts.size() + " contactos.");
        for(int i = 0;i < myContacts.size();i++){
            System.out.println(myContacts.get(i).getContacto() + " " + myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean comprobarExistencia(Contacto x) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (findContactByName(x.getContacto()) >= 0) {
                return true;
            }
        }
        return false;
    }

}
