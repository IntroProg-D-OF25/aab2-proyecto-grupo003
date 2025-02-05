
import java.util.Scanner;

public class Proyecto_AAB2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su sueldo mensual: ");
        double sueldoMensual = scanner.nextDouble();
        
        double[] facturas = new double[6]; 
        String[] categorias = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud", "Turismo"};
        
        for (int i = 0; i < categorias.length; i++) {
            System.out.print("Ingrese las facturas para " + categorias[i] + ": ");
            facturas[i] = scanner.nextDouble();
        }
        double[] limitesDeducciones = {5000, 3000, 2000, 1000, 1500, 2000};  
        if (!validarDatos(sueldoMensual, facturas)) {
            System.out.println("Error: Los datos ingresados no son validos.");
            return;
        }
        double totalIngresosAnuales = sueldoMensual * 12;
        double totalDeducciones = calcularDeducciones(facturas, limitesDeducciones);
        double impuestoAPagar = calcularImpuesto(totalIngresosAnuales, totalDeducciones);
       
        generarDeclaracion(totalIngresosAnuales, totalDeducciones, impuestoAPagar);
    }

    public static boolean validarDatos(double sueldoMensual, double[] facturas) {
        if (sueldoMensual <= 0) {
            return false; 
        }
        for (double factura : facturas) {
            if (factura < 0) {
                return false; 
            }
        }
        return true; 
    }

    public static double calcularDeducciones(double[] facturas, double[] limitesDeducciones) {
        double totalDeducciones = 0;
        for (int i = 0; i < facturas.length; i++) {
            totalDeducciones += Math.min(facturas[i], limitesDeducciones[i]);
        }
        return totalDeducciones;
    }

    public static double calcularImpuesto(double ingresosAnuales, double totalDeducciones) {
        double baseImponible = ingresosAnuales - totalDeducciones;
 
        if (baseImponible <= 20000) {
            return baseImponible * 0.1;  
        } else if (baseImponible <= 40000) {
            return baseImponible * 0.15; 
        } else {
            return baseImponible * 0.2; 
        }
    }
    public static void generarDeclaracion(double ingresosAnuales, double totalDeducciones, double impuestoAPagar) {
        System.out.println("\n--- Declaracion de Impuestos ---");
        System.out.println("Ingresos Anuales: " + ingresosAnuales);
        System.out.println("Total Deducciones: " + totalDeducciones);
        System.out.println("Impuesto a Pagar: " + impuestoAPagar);
        if (impuestoAPagar < 0) {
            System.out.println("¡Reembolso! Usted tiene una devolucion de impuestos.");
        } 
        }
    }


