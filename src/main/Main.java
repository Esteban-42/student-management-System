package main;

import model.Estudiante;
import service.EstudianteService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        EstudianteService service = new EstudianteService();
        int opcion;

        do{
            System.out.println("===============Sistema de Estudiantes===============");
            System.out.println("1. Crear Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    try {
                        System.out.println("Ingrese ID del Estudiante: ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("Error: Ingrese un número válido para el ID:");
                            scanner.next();
                        }
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese Nombre del Estudiante: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Ingrese Edad del Estudiante: ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("Error: Ingrese un número válido para la edad:");
                            scanner.next();
                        }
                        int edad = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese Carrera del Estudiante: ");
                        String carrera = scanner.nextLine();

                        Estudiante estudiante = new Estudiante(id, nombre, edad, carrera);
                        service.agregarEstudiante(estudiante);
                        System.out.println("Estudiante agregado correctamente!!");
                    }catch (Exception e){
                        System.out.println("Error al agregar estudiante");
                    }
                    break;
                case 2:
                    service.mostrarEstudiantes();
                    break;

                case 3:
                    System.out.println("Ingrese ID del Estudiante a eliminar: ");
                    int eliminarEstudiante = scanner.nextInt();
                    boolean eliminado = service.eliminarEstudiante(eliminarEstudiante);

                    if(eliminado){
                        System.out.println("Estudiante eliminado correctamente!!");
                    } else {
                        System.out.println("Estudiante no Encontrado!!");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while (opcion != 4);
    }
}