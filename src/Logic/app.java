package Logic;

import java.io.IOException;
import java.util.Scanner;

public class app {



    public void menu(){

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Bienvenid@ al conversor de monedas");
        System.out.println("1.Dólar -> peso Argentino");
        System.out.println("2.Peso Árgentino -> Dólar");
        System.out.println("3.Dólar -> Real Brasileño");
        System.out.println("4.Real Brasileño -> Dólar");
        System.out.println("5.Dólar -> Peso Colombiano");
        System.out.println("6.Peso Colombiano -> Dólar");
        System.out.println("7.Dólar -> Colón Costarricense");
        System.out.println("8.Colón Costarricense -> Dólar");
        System.out.println("9.Salir");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


    }

    int opcion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la opcion que deseas: ");
        var opcion = scanner.nextInt();
        return opcion;
    }


    public void run() throws IOException, InterruptedException {
        ApiManager apiManager = new ApiManager();
        boolean salir = false;
        String monto;
        Scanner scanner = new Scanner(System.in);
        String CodigoUSA = "USD";
        String CodigoArg = "ARS";
        String CodigoBra = "BRL";
        String CodigoCol = "COP";
        String CodigoCos = "CRC";

        while (!salir){

            menu();
            int op = opcion();


            switch(op){

                case 1:{
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en pesos argentinos es: " + apiManager.ConsultaApi(CodigoUSA, CodigoArg, monto).toString());

                    break;
                }

                case 2:{
                    System.out.println("Introduce el monto en pesos argentinos: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoArg, CodigoUSA, monto).toString());

                    break;
                }

                case 3:{
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en reales brasileños es: " + apiManager.ConsultaApi(CodigoUSA, CodigoBra, monto).toString());

                    break;
                }

                case 4:{
                    System.out.println("Introduce el monto en reales brasileños: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoBra, CodigoUSA, monto).toString());

                    break;
                }

                case 5:{
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en pesos colombianos es: " + apiManager.ConsultaApi(CodigoUSA, CodigoCol, monto).toString());

                    break;
                }

                case 6:{
                    System.out.println("Introduce el monto en pesos colombianos: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoCol, CodigoUSA, monto).toString());

                    break;
                }

                case 7:{
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en colones costarricenses es: " + apiManager.ConsultaApi(CodigoUSA, CodigoCos, monto).toString());

                    break;
                }

                case 8:{
                    System.out.println("Introduce el monto en colones costarricenses: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoCos, CodigoUSA, monto).toString());

                    break;
                }

                case 9:{
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                }

            }


        }

    }

}
