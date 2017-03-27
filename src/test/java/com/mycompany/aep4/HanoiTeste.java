package com.mycompany.aep4;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

public class HanoiTeste {
    
    
    // TESTE DOS PINOS
    @Test
    public void quantPinos() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(6);
        assertThat(hanoi.pino1.toString()).isEqualTo("[6, 5, 4, 3, 2, 1]");
    }
    
    @Test
    public void discosEmpilhados() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(5);
        assertThat(hanoi.discos.toString()).isEqualTo("[5, 4, 3, 2, 1]");
    }
    
    @Test
    public void diametroDiscos() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(4);
        String diametros = " - ";
        for (int i = 0; i < hanoi.discos.size(); i++) {
            diametros += "DISCO "+(i+1)+": DIAMETRO "+(i+1)+" - \n";
        }
        assertThat(diametros).isEqualTo(" - DISCO 1: DIAMETRO 1 - \nDISCO 2: DIAMETRO 2 - \nDISCO 3: DIAMETRO 3 - \nDISCO 4: DIAMETRO 4 - \n");
    }
    
    @Test
    public void tranferencia() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(7);
        assertThat(hanoi.validaMov(hanoi.pino1, hanoi.pino1)).isEqualTo(false);
    }
    
    @Test
    public void movInvalido() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(8);
        hanoi.mov1to2();
        hanoi.mov1to3();
        hanoi.mov2to3();
        hanoi.mov1to2();
        hanoi.mov1to2();
        
        assertThat(hanoi.pino1.toString()).isEqualTo("[8, 7, 6, 5, 4]");
        assertThat(hanoi.pino3.toString()).isEqualTo("[2, 1]");
    }
    
    @Test
    public void grafico() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(4);
        
        assertThat(hanoi.mov1to2()).isEqualTo(true);
    }
    
}
