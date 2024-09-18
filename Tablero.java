
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
        for(int f=0;f<FIL;f++) {                                        // FIL + 1
            for(int c=0;c<COL;c++) {                                    // (COL + 1) * FIL -> COL*FIL + FIL
                tablero[f][c] = 0;                                      // COL
            }                                                           // COL
        }                                                               // FIL    
        
        ponerDos();
        ponerDos();
        
               
    }
    
    private int vaciasEnFila(int f) {                                    // 1 paso 
        int n=0;                                                         // 1 paso
        for(int c=0;c<COL;c++) {                                         // COL + 1
            if(tablero[f][c]==0) {                                       // COL
                n++;                                                     // COL
            }                                                            // COL
        }                                                                // COL
        return n;                                                        // 1 paso
    }                                                                    // 1 paso
    
    private int vaciasEnColumna(int c) {                                // 1 paso   
        int n=0;                                                        // 1 paso
        for(int f=0;f<FIL;f++) {                                        // FIL + 1
            if(tablero[f][c]==0) {                                      // FIL
                n++;                                                    // FIL
            }                                                           // FIL
        }                                                               // FIL
        return n;                                                       // 1 paso
    }                                                                   // 1 paso
    
    private int vacias() {                                              // 1 paso
        int n=0;                                                        // 1 paso
        for(int f=0;f<FIL;f++) {                                        // FIL + 1
            for(int c=0;c<COL;c++) {                                    // (COL+1)FIL -> COL*FIL + FIL
                if(tablero[f][c]==0) {                                  // COL*FIL
                    n++;                                                // COL*FIL
                }                                                       // COL * FIL
            }                                                           // COL * FIL
        }                                                               // FIL
        return n;                                                       // 1 paso
    }
    
    
    private void ponerDos() {                                           // 1 PASO
        int f;                                                          // 1 PASO
        int c;                                                          // 1 PASO
        
        Random random = new Random();                                   // 1 PASO
        
        do {                                                            // n
            f = random.nextInt(FIL);                                    // n
        }                                                               // n
         while(vaciasEnFila(f) == 0);                                   // n + 1
        
        do {                                                            // n
            c = random.nextInt(COL);                                    // n
        }                                                               // n
         while(tablero[f][c] != 0);                                     // n + 1
        
        tablero[f][c] = 2;                                              // 1 paso
        
    }                                                                   // 1 paso
    
    
    public void mostrar() {                                             // 1 paso
        for(int f=0;f<FIL;f++) {                                        // FIL + 1 
            dibujaLineaHorizontal();
            dibujaEspacioHorizontal();
            System.out.print("|");  
            for(int c=0;c<COL;c++) {
                System.out.print("    ");
                if(tablero[f][c]>=1000)
                    System.out.print(tablero[f][c]);
                else if(tablero[f][c] >= 100)
                    System.out.print(" "+tablero[f][c]);
                else if(tablero[f][c] >= 10)
                    System.out.print(" "+tablero[f][c]+" ");
                else if(tablero[f][c] > 0)
                    System.out.print("  "+tablero[f][c]+" ");
                else if(tablero[f][c] == 0)
                    System.out.print("    ");
                System.out.print("    |");
            }
            System.out.print("\n");
            dibujaEspacioHorizontal();
        } 
        dibujaLineaHorizontal();
    }    
    
    private void dibujaLineaHorizontal() {                              // 1 paso
        
        System.out.print("|");                                          // 1 paso
        for(int c=0;c<COL;c++) {                                        // COL + 1
            for(int i=0;i<12;i++) {                                     // (n + 1) * COL -> n*COL + COL
                System.out.print("-");                                  // n * COL
            }                                                           // n * COL
            System.out.print("|");                                      // COL
        }                                                               // COL
        System.out.print("\n");                                         // 1 paso
            
        }                                                               // 1 paso
    
    private void dibujaEspacioHorizontal() {                            // 1 paso
         System.out.print("|");                                         // 1 paso
        for(int c=0;c<COL;c++) {                                        // COL + 1
            for(int i=0;i<12;i++) {                                     // (n + 1) * COL -> n*COL + COL
                System.out.print(" ");                                  // n * COL
            }                                                           //n * COL                                             
            System.out.print("|");                                      // COL
        }                                                               // COL
        System.out.print("\n");                                         // 1 paso
    }                                                                   // 1 paso
    
    public boolean ganador() {                                          // 1 paso
        for(int f=0;f<FIL;f++) {                                        // (FIL + 1)
            for(int c=0;c<COL;c++) {                                    // (COL+1)*FIL -> FIL*COL + FIL
                if(tablero[f][c]==2048) return true;                    // FIL * COL
            }                                                           // FIL * COL
        }                                                               // FIL
        return false;                                                   // 1 paso
    }                                                                   // 1 paso
    
    public boolean finPartida() {                                       // 1 paso
        return (ganador() || vacias()==0);                              // 1 paso
    }                                                                   // 1 paso
    
    public void moverArriba() {                                         // 1 paso
        for(int c=0; c<COL; c++) {                                      // COL + 1
            moverArribaColumna(c);                                      // COL
        }                                                               // COL 
        if(!finPartida())                                               // 1 paso
            ponerDos();                                                 //  1 paso
    }                                                                   // 1 paso
    
    private void moverArribaColumna(int c) {                            // 1 paso
        colocarArriba(c);                                               // 
        sumarArriba(c);
        colocarArriba(c);
    }
    
    private void colocarArriba(int c) {                                 // 1 paso
        
        if(vaciasEnColumna(c) < COL) {                                  // 1 paso
            for(int veces = 0;veces < COL-1;veces++) {                  // veces + 1
                for(int f=0;f<FIL-1;f++) {                              // (FIL+1) * veces -> veces* FIL + veces
                    if(tablero[f][c]==0) {                              // FIL*veces
                        tablero[f][c] = tablero[f+1][c];                // FIL*veces
                        tablero[f+1][c] = 0;                            // FIL*veces
                    }                                                   // FIL*veces
                }                                                       // FIL*veces
            }                                                           // veces
        }                                                               // 1 paso
        
    }                                                                   // 1 paso
    
    
    private void sumarArriba(int c) {                                   // 1 paso
        if(vaciasEnColumna(c)<FIL-1) {                                  // 1 paso
            for(int f=0;f<FIL-1;f++) {                                  // FIL + 1
                if(tablero[f][c] == tablero[f+1][c]) {                  // FIL
                    tablero[f][c] *= 2;                                 // FIL
                    tablero[f+1][c] = 0;                                // FIL
                }                                                       // FIL
            }                                                           // FIL
        }                                                               // 1 paso
    }                                                                   // 1 paso
    
    
    
    
    
    public void moverAbajo() {                                          // 1 paso
        for(int c=0; c<COL; c++) {                                      // COL + 1
            moverAbajoColumna(c);                                       // COL
        }                                                               // COL
        if(!finPartida())                                               // 1 paso
                ponerDos();                                             // 1 paso
    }                                                                   // 1 paso
    
    private void moverAbajoColumna(int c) {                             // 1 paso
        colocarAbajo(c);                                                // 1 paso
        sumarAbajo(c);                                                  // 1 paso
        colocarAbajo(c);                                                // 1 paso
    }                                                                   // 1 paso

    private void colocarAbajo(int c) {                                  // 1 paso
        
        if(vaciasEnColumna(c) < COL) {                                  // 1 paso
            for(int veces = 0;veces < COL-1;veces++) {                  // veces + 1
                for(int f=FIL-1;f>0;f--) {                              // (FIL+1)*veces -> FIL*veces + veces
                    if(tablero[f][c]==0) {                              // FIL*veces
                        tablero[f][c] = tablero[f-1][c];                // FIL*veces
                        tablero[f-1][c] = 0;                            // FIL * veces
                    }                                                   // FIL * veces
                }                                                       // FIL * veces
            }                                                           // veces
        }                                                               // 1 paso

    }                                                                   // 1 paso
    
    
    private void sumarAbajo(int c) {                                    // 1 paso
        if(vaciasEnColumna(c)<FIL-1) {                                  // 1 paso
            for(int f=FIL-1;f>0;f--) {                                  // FIL + 1
                if(tablero[f][c] == tablero[f-1][c]) {                  // FIL
                    tablero[f][c] *= 2;                                 // FIL
                    tablero[f-1][c] = 0;                                // FIL
                }                                                       // FIL
            }                                                           // FIL
        }                                                               // 1 paso
    }                                                                   // 1 paso
    
    
    
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
