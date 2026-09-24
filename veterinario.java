import java.util.*;

public class veterinario {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<mascota>> paciente = new HashMap<>();
        int op;

        do{
            System.out.println("Menú:\n1. Registrar mascotas asociadas a un dueño\n2. Consultar información\n3. Mostrar todas las mascotas de un dueño\n4. Mostrar todas las mascotas registradas\n5. Búsquedas\n6. Salir");
            op = leerDato(sc, "Elige una opción: ");
            switch(op){
                case 1:
                    sc.nextLine();
                    String own = leerString(sc, "Escribe el nombre del dueño: ");
                    String name = leerString(sc, "Escribe el nombre de tu mascota: ");
                    String type = leerString(sc, "Escribe el tipo de tu mascota: ");
                    String years = leerString(sc, "Escribe la edad de tu mascota: ");
                    mascota pet1 = new mascota(name, type, years);
                    registro(paciente, own, pet1);
                    break;
                case 2:
                    sc.nextLine();
                    consultaInfo(paciente);
                    break;
                case 3:
                    sc.nextLine();
                    String nombre = leerString(sc, "Escribe el nombre del dueño: ");
                    consultaMascotas(paciente, nombre);
                    break;
                case 4:
                    mostrarPet(paciente);
                    break;
                case 5:
                    sc.nextLine();
                    int look = leerDato(sc, "1. Búsqueda por dueño\n2. Búsqueda por mascota");
                    sc.nextLine();
                    if(look == 1){
                        String dueno = leerString(sc, "Escribe el nombre del dueño: ");
                        lookOwner(paciente, dueno);
                    } else if (look == 2){
                        String anim = leerString(sc, "Escribe el nombre de la mascota: ");
                        String tipo = leerString(sc, "Escribe el tipo de animal: ");
                        String edad = leerString(sc, "escribe la edad de la mascota: ");
                        mascota p = new mascota(anim, tipo, edad);
                        lookPet(paciente, p);
                    } else {
                        System.out.println("Opción inválida");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (op != 6);
        System.out.println("Cerrando...");
    }
    public static int leerDato(Scanner sc, String a){ 
        System.out.println(a);
        int b = sc.nextInt();
        return b;
    }
    public static String leerString(Scanner sc, String c){ 
        System.out.println(c);
        String d = sc.nextLine();
        return d;
    }
    public static void registro(HashMap<String, List<mascota>>paciente, String owner, mascota pet1){
        if(paciente.containsKey(owner)){
            paciente.get(owner).add(pet1);
            System.out.println("Mascota registrada");
        } else {
            List<mascota> temp = new ArrayList<>();
            temp.add(pet1);
            paciente.put(owner, temp);
            System.out.println("Mascota y dueño registrados");
        }
    }

    public static void consultaInfo(HashMap<String, List<mascota>>paciente){
        for (Map.Entry<String, List<mascota>> m : paciente.entrySet()){
            List<mascota> animal = m.getValue();
            System.out.println("Dueño : " + m.getKey() + " | Mascotas: " + animal);
        }
    }

    public static void consultaMascotas(HashMap<String, List<mascota>>paciente, String owner){
        if(paciente.containsKey(owner)){
            List<mascota> animales = paciente.get(owner);
            System.out.println("Dueño : " + owner + " | Cantidad: " + animales);
        } else {
            System.out.println("El dueño no está registrado");
        }
    }

    public static void mostrarPet(HashMap<String, List<mascota>>paciente){
        if(!paciente.isEmpty()){
            System.out.println("Mascotas: ");
            for(Map.Entry<String, List<mascota>>p:paciente.entrySet()){
                System.out.println(p.getValue());
            }
        }else{
            System.out.println("Sin mascotas");
        }
    }

    public static void lookOwner(HashMap<String, List<mascota>>paciente, String owner){
        if(paciente.containsKey(owner)){
            List<mascota> pets = paciente.get(owner);
            System.out.println("Dueño : " + owner + " | Mascotas: " + pets);
        } else {
            System.out.println("Dueño no registrado");
        }
    }

    public static void lookPet(HashMap<String, List<mascota>>paciente, mascota pet1){
        boolean found = false;
        for(Map.Entry<String, List<mascota>> entry : paciente.entrySet()){
            for (mascota m : entry.getValue()){
                if(m.getNombre().equals(pet1.getNombre()) && m.getOld().equals(pet1.getOld()) && m.getType().equals(pet1.getType())){
                    String owner1 = entry.getKey();
                    System.out.println("Mascota: " + pet1 + " | Dueño: " + owner1);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("Mascota no encontrada");
        }
    }
}