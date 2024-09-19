
package com.jmrh.ejerciciojava06;

import java.util.Random;                                                // 1 paso

/**
 *
 * Andrey Felipe Pinto Uribe         192177
 * Angel Alfredo Urrego Olivera      192179
 */
public class Tablero {                                                  // 1 paso
    
    public static final int FIL = 4;                                    // 1 paso
    public static final int COL = 4;                                    // 1 paso
    private final int[][] tablero;                                      // 1 paso
    
    public Tablero() {                                                  // 1 paso
        tablero = new int[FIL][COL];                                    // 1 paso                           
        for(int f=0;f<FIL;f++) {                                        // n + 1
            for(int c=0;c<COL;c++) {                                    // (m + 1) * n -> n*m + n
                tablero[f][c] = 0;                                      // n*m
            }                                                           // n*m
        }                                                               // n    
        
        ponerDos();                                                     //8 + 8n
        ponerDos();                                                     //8 + 8n
        
    } // total = 20 + 5n + 3m                                           // 1 paso
    
    private int vaciasEnFila(int f) {                                    // 1 paso 
        int n=0;                                                         // 1 paso
        for(int c=0;c<COL;c++) {                                         // n + 1
            if(tablero[f][c]==0) {                                       // n
                n++;                                                     // n
            }                                                            // n
        }                                                                // n
        return n;                                                        // 1 paso
    } //total =  4 + 5n                                                 // 1 paso
    
    private int vaciasEnColumna(int c) {                                // 1 paso   
        int n=0;                                                        // 1 paso
        for(int f=0;f<FIL;f++) {                                        // n + 1
            if(tablero[f][c]==0) {                                      // n
                n++;                                                    // n
            }                                                           // n
        }                                                               // n
        return n;                                                       // 1 paso
    }// total= 5 + 5n                                                   // 1 paso
    
    private int vacias() {                                              // 1 paso
        int n=0;                                                        // 1 paso
        for(int f=0;f<FIL;f++) {                                        // n + 1
            for(int c=0;c<COL;c++) {                                    // (m+1)n -> n*m + n
                if(tablero[f][c]==0) {                                  // n*m
                    n++;                                                // n*m
                }                                                       // n * m
            }                                                           // n * m
        }                                                               // n
        return n;                                                       // 1 paso
    }// total 6 + 7n + 3m                                               // 6 pasos
    
    
    private void ponerDos() {                                           // 1 PASO
        int f;                                                          // 1 PASO
        int c;                                                          // 1 PASO
        
        Random random = new Random();                                   // 1 PASO
        
        do {                                                            // n
            f = random.nextInt(FIL);                                    // n
        }                                                               // n
         while(vaciasEnFila(f) == 0);                                   // (n + 1 ) + 4 + 5n
        
        do {                                                            // n
            c = random.nextInt(COL);                                    // n
        }                                                               // n
         while(tablero[f][c] != 0);                                     // n + 1
        
        tablero[f][c] = 2;                                              // 1 paso
        
    }// total =  12 +  13n                                             // 1 paso
    
    
    public void mostrar() {                                             // 1 paso
        for(int f=0;f<FIL;f++) {                                        // n + 1 
            dibujaLineaHorizontal();                                    // 6 + 6n + 3m
            dibujaEspacioHorizontal();                                  // 6 + 6n + 3m
            System.out.print("|");                                      // 1 paso
            for(int c=0;c<COL;c++) {                                    // n + 1
                System.out.print("    ");                               // n
                if(tablero[f][c]>=1000)                                 // n
                    System.out.print(tablero[f][c]);                    // n
                else if(tablero[f][c] >= 100)                           // n
                    System.out.print(" "+tablero[f][c]);                // n
                else if(tablero[f][c] >= 10)                            // n
                    System.out.print(" "+tablero[f][c]+" ");            // n
                else if(tablero[f][c] > 0)                              // n
                    System.out.print("  "+tablero[f][c]+" ");           // n
                else if(tablero[f][c] == 0)                             // n
                    System.out.print("    ");                           // n
                System.out.print("    |");                              // n
            }                                                           // n
            System.out.print("\n");                                     // 1 paso
            dibujaEspacioHorizontal();                                  // 6 + 7n +3m
        }                                                               // n
        dibujaLineaHorizontal();                                        // 6 + 7n + 3m 
    }// total = 31 + 41n + 12m                                          // 1 paso     
    
    private void dibujaLineaHorizontal() {                              // 1 paso
        
        System.out.print("|");                                          // 1 paso
        for(int c=0;c<COL;c++) {                                        // n + 1
            for(int i=0;i<12;i++) {                                     // (m + 1) * n -> n*m + n
                System.out.print("-");                                  // n * m
            }                                                           // n * m
            System.out.print("|");                                      // n
        }                                                               // n
        System.out.print("\n");                                         // 1 paso
            
    }// total = 6 + 6n + 3m                                             // 1 paso
    
    private void dibujaEspacioHorizontal() {                            // 1 paso
         System.out.print("|");                                         // 1 paso
        for(int c=0;c<COL;c++) {                                        // n + 1
            for(int i=0;i<12;i++) {                                     // (n + 1) * m -> n*m + n
                System.out.print(" ");                                  // n * m
            }                                                           //n * m                                             
            System.out.print("|");                                      // n
        }                                                               // n
        System.out.print("\n");                                         // 1 paso
    }// total = 6 + 6n                                                  // 1 paso
    
    public boolean ganador() {                                          // 1 paso
        for(int f=0;f<FIL;f++) {                                        // (n + 1)
            for(int c=0;c<COL;c++) {                                    // (m+1)*n -> n*m + n
                if(tablero[f][c]==2048) return true;                    // n * m
            }                                                           // n * m
        }                                                               // n
        return false;                                                   // 1 paso
    }// total = 5 + 5n + 3m                                              // 1 paso
    
    public boolean finPartida() {                                       // 1 paso
        return (ganador() || vacias()==0);                              // (5+5n+3m)+ (6 +7n+3m) = 11 + 12n + 6m
    }// total = 13 + 12n + 6m                                           // 1 paso
    
    public void moverArriba() {                                         // 1 paso
        for(int c=0; c<COL; c++) {                                      // n + 1
            moverArribaColumna(c);                                      // 30 + 38n + 12m
        }                                                               // n 
        if(!finPartida())                                               // 13 + 12n + 6 m
            ponerDos();                                                 // 12 + 13n
    } //total = 58 +  64n + 18m                                          // 1 paso
    
    private void moverArribaColumna(int c) {                            // 1 paso
        colocarArriba(c);                                               // 10 + 13n + 6m
        sumarArriba(c);                                                 // 9 + 11 n
        colocarArriba(c);                                               // 10 + 13 + 6m
    }// total = 30 + 37n + 12m
    
    private void colocarArriba(int c) {                                 // 1 paso
        
        if(vaciasEnColumna(c) < COL) {                                  // 5 + 5n
            for(int veces = 0;veces < COL-1;veces++) {                  // n + 1
                for(int f=0;f<FIL-1;f++) {                              // (m+1) * n -> n*m + n
                    if(tablero[f][c]==0) {                              // n*m
                        tablero[f][c] = tablero[f+1][c];                // n*m
                    }                                                   // n*m
                }                                                       // n*m
                        tablero[f+1][c] = 0;                            // n*m
            }                                                           // n
        }                                                               // 1 paso
        
    }// total =  10 + 13n + 6 m                                        // 1 paso
    
    
    private void sumarArriba(int c) {                                   // 1 paso
        if(vaciasEnColumna(c)<FIL-1) {                                  // 5 + 5n
            for(int f=0;f<FIL-1;f++) {                                  // n + 1
                if(tablero[f][c] == tablero[f+1][c]) {                  // n
                    tablero[f][c] *= 2;                                 // n
                    tablero[f+1][c] = 0;                                // n
                }                                                       // n
            }                                                           // n
        }                                                               // 1 paso
    }//total = 9 + 11n                                                  // 1 paso
    
    
    
    
    
    public void moverAbajo() {                                          // 1 paso
        for(int c=0; c<COL; c++) {                                      // n + 1
            moverAbajoColumna(c);                                       // n
        }                                                               // n
        if(!finPartida())                                               // 1 paso
                ponerDos();                                             // 1 paso
    }// total =                                                         // 1 paso
    
    private void moverAbajoColumna(int c) {                             // 1 paso
        colocarAbajo(c);                                                // 11 + 13n + 6m
        sumarAbajo(c);                                                  // 1 paso
        colocarAbajo(c);                                                // 1 paso
    }// total =                                                                    // 1 paso

    private void colocarAbajo(int c) {                                  // 1 paso
        
        if(vaciasEnColumna(c) < COL) {                                  // 6 + 5n
            for(int veces = 0;veces < COL-1;veces++) {                  // n + 1
                for(int f=FIL-1;f>0;f--) {                              // (m+1)*n -> n*m + n
                    if(tablero[f][c]==0) {                              // n*m
                        tablero[f][c] = tablero[f-1][c];                // n*m
                        tablero[f-1][c] = 0;                            // n*m
                    }                                                   // n*m
                }                                                       // n*m
            }                                                           // n
        }                                                               // 1 paso

    }// total = 11 + 13n + 6m                                          // 1 paso
    
    
    private void sumarAbajo(int c) {                                    // 1 paso
        if(vaciasEnColumna(c)<FIL-1) {                                  // 6 + 5n 
            for(int f=FIL-1;f>0;f--) {                                  // n + 1
                if(tablero[f][c] == tablero[f-1][c]) {                  // n
                    tablero[f][c] *= 2;                                 // n
                    tablero[f-1][c] = 0;                                // n
                }                                                       // n
            }                                                           // n
        }                                                               // 1 paso
    }// total                                                                    // 1 paso
    
    
    
    public void moverDerecha() {                                        // 1 paso
        for(int f=0; f<COL; f++) {                                      // COL + 1
            moverDerechaFila(f);                                        // COL
        }                                                               // COL
        if(!finPartida())                                               // 1 paso
                ponerDos();                                             // 1 paso
    }                                                                   //  1 paso
    
    private void moverDerechaFila(int f) {                              // 1 paso
        colocarDerecha(f);                                              // 1 paso
        sumarDerecha(f);                                                // 1 paso
        colocarDerecha(f);                                              // 1 paso
    }                                                                   // 1 paso
    
    private void colocarDerecha(int f) {                                // 1 paso

        if(vaciasEnFila(f) < FIL) {                                     // 1 paso
            for(int veces = 0;veces < COL-1;veces++) {                  // (COL + 1 )
                for(int c=COL-1;c>0;c--) {                              // (n + 1) * COL -> n*COL + COL
                    if(tablero[f][c]==0) {                              // n * COL
                        tablero[f][c] = tablero[f][c-1];                // n * COL
                        tablero[f][c-1] = 0;                            // n * COL
                    }                                                   // n * COL
                }                                                       // n * COL
            }                                                           // COL
        }                                                               // 1 paso
        
    }                                                                   // 1 paso
    
    
    private void sumarDerecha(int f) {                                  // 1 paso
        if(vaciasEnFila(f)<FIL-1) {                                     // 1 paso
            for(int c=COL-1;c>0;c--) {                                  // COL + 1
                if(tablero[f][c] == tablero[f][c-1]) {                  // COL
                    tablero[f][c] *= 2;                                 // COL
                    tablero[f][c-1] = 0;                                // COL
                }                                                       // COL
            }                                                           // COL
        }                                                               // 1 paso
    }                                                                   // 1 paso
    
    
    public void moverIzquierda() {                                      //  1 paso
        for(int f=0; f<FIL; f++) {                                      // FIL + 1
            moverIzquierdaFila(f);                                      // FIL
        }                                                               // FIL
        if(!finPartida())                                               // 1 Paso
                ponerDos();                                             // 1 paso
    }                                                                   // 1 paso
    
    private void moverIzquierdaFila(int f) {                            // 1 paso
        colocarIzquierda(f);                                            // 1 paso
        sumarIzquierda(f);                                              // 1 paso
        colocarIzquierda(f);                                            // 1 paso
    }                                                                   // 1paso
    
    private void colocarIzquierda(int f) {                              // 1 paso

        if(vaciasEnFila(f) < FIL) {                                     // 1 paso
            for(int veces = 0;veces < COL-1;veces++) {                  // COL + 1
                for(int c=0;c<COL-1;c++) {                              // (COL + 1)*COL -> COL**2 + COL
                    if(tablero[f][c]==0) {                              // COL**2
                        tablero[f][c] = tablero[f][c+1];                // COL**2
                        tablero[f][c+1] = 0;                            // COL**2
                    }                                                   // COL**2
                }                                                       // COL**2
            }                                                           // COL
        }                                                               // 1 paso
        
    }                                                                   // 1 paso
    
    
    private void sumarIzquierda(int f) {                                // 1 paso
        if(vaciasEnFila(f)<FIL-1) {                                     // 1 paso
            for(int c=0;c<COL-1;c++) {                                  // COL + 1
                if(tablero[f][c] == tablero[f][c+1]) {                  // COL
                    tablero[f][c] *= 2;                                 // COL
                    tablero[f][c+1] = 0;                                // COL
                }                                                       // COL
            }                                                           // COL
        }                                                               // 1 paso
    }                                                                   // 1 paso
      
}                                                                       // 1 paso
