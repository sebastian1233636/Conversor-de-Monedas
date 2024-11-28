package Logic;

import Persistencia_de_datos.Conversion;
import Persistencia_de_datos.FileManager;

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
        FileManager fileManager = new FileManager();
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
                    String descripcion = "Dólar a peso Argentino";
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en pesos argentinos es: " + apiManager.ConsultaApi(CodigoUSA, CodigoArg, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoUSA, CodigoArg, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 2:{
                    String descripcion = "Peso Árgentino a Dólar";
                    System.out.println("Introduce el monto en pesos argentinos: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoArg, CodigoUSA, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoArg, CodigoUSA, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 3:{
                    String descripcion = "Dólar a Real Brasileño";
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en reales brasileños es: " + apiManager.ConsultaApi(CodigoUSA, CodigoBra, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoUSA, CodigoBra, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 4:{
                    String descripcion = "Real Brasileño a Dólar";
                    System.out.println("Introduce el monto en reales brasileños: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoBra, CodigoUSA, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoBra, CodigoUSA, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 5:{
                    String descripcion = "Dólar a Peso Colombiano";
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en pesos colombianos es: " + apiManager.ConsultaApi(CodigoUSA, CodigoCol, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoUSA, CodigoCol, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 6:{
                    String descripcion = "Peso Colombiano a Dólar";
                    System.out.println("Introduce el monto en pesos colombianos: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoCol, CodigoUSA, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoCol, CodigoUSA, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 7:{
                    String descripcion = "Dólar a Colón Costarricense";
                    System.out.println("Introduce el monto en dólares: ");
                    monto = scanner.next();
                    System.out.println("El monto en colones costarricenses es: " + apiManager.ConsultaApi(CodigoUSA, CodigoCos, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoUSA, CodigoCos, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 8:{
                    String descripcion = "Colón Costarricense a Dólar";
                    System.out.println("Introduce el monto en colones costarricenses: ");
                    monto = scanner.next();
                    System.out.println("El monto en dólares es: " + apiManager.ConsultaApi(CodigoCos, CodigoUSA, monto).toString());
                    Conversion conversion = new Conversion(apiManager.ConsultaApi(CodigoCos, CodigoUSA, monto).getConversionResult(),descripcion);
                    fileManager.addToJson(conversion);

                    break;
                }

                case 9:{
                    System.out.println("Guardando en archivo...");
                    fileManager.generarJson();
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                }

            }


        }

    }

}
