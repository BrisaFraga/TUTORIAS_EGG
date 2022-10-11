import java.util.Random;

/**
 *
 * @author fraga
 */
public class TUTORIA_DIAGONALES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = new int[3][3];
        int resultadoDiagonalPrincipal ;
        int resultadoDiagonalSecundaria;
        
        llenarMatriz(matriz);
        
        System.out.println("Esta es la matriz con la que trabajaremos:");
     
        mostrarMatriz(matriz);
        resultadoDiagonalPrincipal = sumarDiagonalPrincipal(matriz);
        resultadoDiagonalSecundaria = sumarDiagonalSecundaria(matriz);
        compararDiagonales(resultadoDiagonalPrincipal, resultadoDiagonalSecundaria);
        
    }
    
    public static void llenarMatriz(int[][] matriz) {
        
        Random random = new Random();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = random.nextInt(5);
                
            }
            
        }
        
        
    }
    
    public static int sumarDiagonalPrincipal(int[][] matriz) {
        
        int sumaPrincipal = 0;
                 
              
        
        for (int i = 0; i < 3; i++) {
                        
            for (int j = 0; j < 3; j++) {
                
// suma cada elemento de la matriz a sumaPrincipal EXCLUSIVAMENTE cuando las posiciones de las celdas son iguales                
                if (i == j){
                    sumaPrincipal += matriz[i][j];
                }
                
            }           
            
        }       
       
        return sumaPrincipal;
    }
    
    public static int sumarDiagonalSecundaria(int [][] matriz) {
         int sumaSecundaria = 0;
         // EL 2 REFIERE A LA ULTIMA COLUMNA POR POSICONES AL SER UNA MATRIZ DE 3X3
        // LAS COLUMNAS SEGUN POSICION SERIAN 0/1/2
        
        //auxPosicion
        int auxPosicion = 2;
        
        for (int i = 0; i < 3; i++) {
           
           //ej primera vuelta: i = 0 y auxPosicion = 2 por lo tanto matriz[0][2] es decir
           //la ultima posicion de la primera fila
            sumaSecundaria += matriz[i][auxPosicion];
            
            //se le resta uno para poder acceder a la siguiente posicion en columna 
            // ej si empieza en 2 como ahora la siguiente seria el 1
            auxPosicion -= 1;
            
        }
        
        return sumaSecundaria;
        
    }
    
    public static void compararDiagonales(int diagonalPrincipal, int diagonalSecundaria) {
        
        System.out.println("La suma de la diagonal principal es: " + diagonalPrincipal);
        System.out.println("La suma de la diagonal secundaria es: " + diagonalSecundaria);
        
        if (diagonalPrincipal == diagonalSecundaria) {
            System.out.println("Los resultados de las diagonales son iguales!");
            
        } else {
            if (diagonalPrincipal > diagonalSecundaria) {
                System.out.println("La diagonal principal es mayor.");
                
            }else{System.out.println("La diagonal secundaria es mayor.");}
        }
    }
    
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            System.out.print("[");
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j]+"|");     
           
                   }
            System.out.println(matriz[i][2]+"]");

            
        }
    }
   
}
