/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorias_guia5;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author fraga
 */
public class TUTORIAS_GUIA5 {

    /**
     * @param args the command line arguments
     * 
     * PUNTO A TENER EN CUENTA:
     * EL PROGRAMA NO VERIFICA QUE SE ENCUENTREN MAS DE UNA VEZ LA MISMA PALABRA, LO SIGUE TOMANDO COMO VALIDO,
     * ESO PODRIAS HACERLO VOS COMO UNA MINI TAREA ;)
     *  
     * 
     */
    public static void main(String[] args) {
        
        
        //Creamos la matriz
        Scanner leer;
        leer = new Scanner(System.in);
        String [][] matrizGrande = new String[10][10];
        int fila;
        int columna ;
        int opcion;
        opcion = -1; 
   
        //llenamos la matriz
        ingresarPalabras(matrizGrande);
        llenarMatriz(matrizGrande);
        
        while (opcion != 0) { 
            
            System.out.println("OPCIONES:");
            System.out.println("1 - buscar las palabras en la sopa de letras");
            System.out.println("2 - Buscar una mini matriz de 3x3 y verificar que sus diagonales coincidan.");
            System.out.println("0 - cerrar el programa");
            opcion = leer.nextInt();
            
            
            
            switch(opcion){
                
                case 1:
                    
                    sopaLetras(matrizGrande);
                break;
                case 2:
                    mostrarMatriz(matrizGrande);
                       
                    System.out.println("Ingrese la fila a buscar una matriz de 3x3 (0 al 7)");
                    fila = leer.nextInt();
                    System.out.println("Ingrese la columna a buscar una matriz de 3x3 (0 al 7)");
                    columna = leer.nextInt();

                    while (fila > 7 || fila < 0 || columna > 7 || columna<0) {     
                        System.out.println("ERROR, VUELVA A INGRESARLO!!! ----");
                        System.out.println("Ingrese la fila a buscar una matriz de 3x3 (0 al 7)");
                        fila = leer.nextInt();
                        System.out.println("Ingrese la columna a buscar una matriz de 3x3 (0 al 7)");
                        columna = leer.nextInt();               

                    }

                    diagonalesMiniMatriz(matrizGrande,fila,columna);
                    break;
                case 0:
                    System.out.println("ADIOS!");
                    break;

                default:
                    System.out.println("El numero ingresado no está todavia en nuestro programa");}
            
        }
        
  
        
  
        
        
       
    }
    
 
    
    public static void diagonalesMiniMatriz(String[][] matriz , int fila, int columna) {
        String principal = "";
        String secundaria = "";
        
        // EL 2 REFIERE A LA ULTIMA COLUMNA POR POSICONES AL SER UNA MATRIZ DE 3X3
        // LAS COLUMNAS SEGUN POSICION SERIAN 0/1/2
        int aux = 2;
        
        miniMatriz(matriz, fila, columna);
        
        
        for (int i = 0; i < 3; i++) {
            //Recorre las filas, al hacer i+fila, se refiere a la posicion de la matriz
            // este es de la diagonal secundaria            
            secundaria = secundaria.concat(matriz[i+fila][aux+columna]);
            System.out.println(matriz[i+fila][aux+columna]);
            //se le resta uno para poder acceder a la siguiente posicion en columna 
            // ej si empieza en 2 como ahora la siguiente seria el 1
            aux -= 1;
            
            for (int j = 0; j < 3; j++) {
                
                
                if (i == j){
                    principal = principal.concat(matriz[i+fila][j+columna]);
                }
                
                
            }
            
            
        }
        
        System.out.println("Resultados de la primera diagonal: " + principal);
        System.out.println("Resultados de la segunda diagonal: " + secundaria);
        
        if (principal.toLowerCase().equals(secundaria.toLowerCase())) {
            System.out.println("LAS DIAGONALES SON IGUALES!!!");
            
        }else{System.out.println("LAS DIAGONALES SON DIFERENTES!!!!");}
        
    }
    
    public static void sopaLetras(String[][] matrizGrande) {
        int palabrasEncontradas = 0;
        boolean bandera ;
        
        
        //esta hasta el 4 porque decidi dar 4 intentos nomas, vos podes personalizarlo.
        for (int i = 0; i < 4; i++) {
           
            
            //si ya encontraste las 3 palabras antes de los 4 intentos, no va a realizar las siguientes acciones.
            if (palabrasEncontradas == 3) {
                System.out.println("--- GANASTE, ENCONTRASTE TODAS LAS PALABRAS ---");
                break;
            }
            
            mostrarMatriz(matrizGrande);
            bandera = buscarPalabra(matrizGrande);
            
            // verificamos el estado de la bandera
            if (bandera) {
                
                
                palabrasEncontradas += 1;
                System.out.println("ENCONTRASTE UNA PALABRA!! ");
                
                
                
            }else{
                System.out.println("Oh, la palabra no estaba ahi :(");}
            
        }
        
        //si al salir del for las palabrasEncontras (contador) es distinto de 3, quiere decir que gasto
        //los 4 intentos pero sin encontrar las palabras, por lo que perdio
        if (palabrasEncontradas != 3) {
            System.out.println("Oh perdiste :( Suerte en la proxima!");
            
        }else{ //caso contrario, gasto los 4 intentos pero si encontro las palabras.
            System.out.println("--- GANASTE, ENCONTRASTE TODAS LAS PALABRAS ---");}
        
    }
    
    public static void llenarMatriz(String[][] matriz){
        
        Random random = new Random();
        char a;
       
       
        
        //RECORRE FILAS
        for (int i = 0; i < 10; i++) {
            //RECORRE COLUMNAS
            for (int j = 0; j < 10; j++) {
                //VERIFICA QUE LA MATRIZ ESTE VACIA PARA NO SOBRESCRIBIR LAS PALABRAS INGRESADAS.
                if (matriz[i][j] == null) {
                     //Hace un numero random, lo suma a las 'a' y al ser convertido al char, 
                    //te podria asignar todos los caracteres del abecedario en MINUSCULA
                     a = (char) ('a' + random.nextInt(26));
                     //.valueOf() convierte el char en un string
                    matriz[i][j] = String.valueOf(a);
                }
               
            }
            
        }
    }
    

    public static void ingresarPalabras(String[][] matriz) {
        Random random = new Random();

        Scanner leer;
        leer = new Scanner(System.in);
        String palabra ;


       
        int c;
        int f;
        
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese una palabra no mayor a 10 digitos:");
            palabra = leer.nextLine();
            while (palabra.length() >10) {     
                System.out.println("ERROR INGRESE UNA PALABRA MAS CORTA!!!!!!!!!");
                System.out.println("Ingrese una palabra no mayor a 10 digitos:");
                palabra = leer.nextLine();
                
            }
            
   
            //le da un lugar random a las filas y las columnas
            f = random.nextInt(10);
            c = random.nextInt(10-palabra.length());
            boolean bandera = false;
         
            for (int j = 0; j < palabra.length(); j++) {
                
                //mientras la matriz en la posicion actual no este vacia y la bandera este en falso, va a entrar aqui
                //esto se hace para no sobrescribir la primera letra, abria que verificar que no sobrescriba mas de una letra
                //yo no lo hice para acortar el tiempo del ejercicio pero podrias intentarlo vos :)
                while(matriz[f][c] != null && bandera == false) {                    
                    f = random.nextInt(10);
                    c = random.nextInt(10-palabra.length());
                }
                
                //al salir o no entrar al bucle, se pone la bandera en True para que no entre mientras recorre la matriz para
                //guardar la palabra bien 
                
                 bandera = true;                              
                
                // j = posicion actual en la palabra, c =  donde se coloco la primera letra de la palabra
                //se suma para obtener la posicion actual de la columna
                matriz[f][j+c]  = palabra.substring(j, j+1);
                
                //verifica que ya estemos en la ultima vuelta de este for, para poder restablecer la bandera.
                if (j == palabra.length()-1) {                    
                    bandera = false;
                }
            }
            
        }
         
 
    }
    
    public static void miniMatriz(String[][] matriz , int fila, int columna) {
        for (int i = fila; i < fila+3; i++) {
            System.out.print("[");
            for (int j = columna; j < columna+2; j++) {
                System.out.print(matriz[i][j]+'|');               
                   }
            System.out.println(matriz[i][columna+2]+']');
            
        }
    }
    
    public static void mostrarMatriz(String[][] Matriz) {
        
        for (int i = 0; i < 10; i++) {
            System.out.print("[");
            for (int j = 0; j < 9; j++) {
                System.out.print(Matriz[i][j]+'|');               
                   }
            System.out.println(Matriz[i][9]+']');
            
        }
        
    }
    
    public static boolean buscarPalabra(String[][] matriz){
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la palabra a buscar:");
        String pal = leer.nextLine();
        
        System.out.println("Ingrese la fila donde cree que se encuentra: (0,9)");
        int fila = leer.nextInt();
        System.out.println("Ingrese la columna donde cree que se encuentra: (0,9)");
        int columna = leer.nextInt();
        
        int limite = columna+ pal.length();
        int contador = 0;
        
        
        for (int i = columna; i < limite; i++) {
           
            //verifica con el equals que el subestring de palabra, sea igual a lo que hay en la matriz en la posicion (fila, i)
            // al agregarle el ! al principio estaria verificando que sean distintos, ya que el ! hace referencia al diferente
            if (!matriz[fila][i].toLowerCase().equals(pal.toLowerCase().substring(contador, contador+1)) ) {
                
                //el .toLowerCase retorna la cadena en minusculas, al agregarlo tanto en la matriz como en la palabra buscada
                // no abra problema si las ingresamos diferenciadas (minusculas o mayusculas)
                
                //entra aqui cuando no coinciden por lo tanto no es la palabra buscada
              
                return false;
            } 
            //el contador es para poder ir avanzando en las posiciones de la palabra
            contador += 1;
        }
        return true;
        
        //devuelve true o false, al encontrar o no (respectivamente) la palabra.
    }
}
