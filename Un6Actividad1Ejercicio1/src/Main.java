import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static telefonoMovil tm = new telefonoMovil("123456789");
    private static Scanner sc = new Scanner(System.in);
    public static void imprimirMenu() {
        System.out.println("0 - Para salir.");
        System.out.println("1 - Para imprimir contactos.");
        System.out.println("2 - Para añadir contacto.");
        System.out.println("3 - Para modificar.");
        System.out.println("4 - Para eliminar.");
        System.out.println("5 - Para buscar si hay un contacto en la lista.");
        System.out.println("6 - Para imprimir menu.");
    }

    public static void printContact(){
        tm.printContacts();
    }

    public static void addContact(){
        String nom;
        String tlfn;
        System.out.println("Introduce el nombre del nuevo contacto.");
        nom = sc.next();
        System.out.println("Introduce el numero del nuevo contacto.");
        tlfn = sc.next();
        tm.addNewContact(Contacto.createContacto(nom,tlfn));
    }

    public static void modifyContact(){
        System.out.println("Introduce el nombre del contacto que quieres modificar y el nombre y numero del nuevo contacto.");
        tm.updateContact(tm.queryContact(sc.next()),Contacto.createContacto(sc.next(),sc.next()));
    }

    public static void removeContact(){
        System.out.println("Selecciona el nombre del contacto que quieres eliminar.");
        tm.removeContact(tm.queryContact(sc.next()));
    }

    public static void printContactInformation(){
        System.out.println("Selecciona el contacto.");
        Contacto c = tm.queryContact(sc.next());
        System.out.println(c.getContacto() + " " + c.getPhoneNumber());
    }


    public static void main(String[] args) {
    boolean keepgoing = true;
    boolean checker = true;
    int choose = 0;
    imprimirMenu();

    do{
        System.out.println("Elige una opcion");
            choose = sc.nextInt();
        switch (choose){
            case 0:
                keepgoing = false;
                break;
            case 1:
                printContact();
                break;
            case 2:
                addContact();
                break;
            case 3:
                modifyContact();
                break;
            case 4:
                removeContact();
                break;
            case 5:
                printContactInformation();
                break;
            case 6:
                imprimirMenu();
                break;
        }

    }while(keepgoing);
    }
}