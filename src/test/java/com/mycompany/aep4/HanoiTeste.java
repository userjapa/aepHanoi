package com.mycompany.aep4;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

public class HanoiTeste {
    
    // FICA ATENTO NO OUTPUT!!!
    
    // TESTE DOS PINOS
    @Test
    public void quantPinos() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(8);
        assertThat(hanoi.pino1.toString()).isEqualTo("[8, 7, 6, 5, 4, 3, 2, 1]");
    }
    
    // TESTE DE EMPILHAR
    @Test
    public void discosEmpilhados() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(7);
        assertThat(hanoi.discos.toString()).isEqualTo("[7, 6, 5, 4, 3, 2, 1]");
    }
    
    // TESTE DOS DIAMETROS
    @Test
    public void diametroDiscos() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(6);
        String diametros = " - ";
        for (int i = 0; i < hanoi.discos.size(); i++) {
            diametros += "DISCO "+(i+1)+": DIAMETRO "+(i+1)+" - \n";
        }
        assertThat(diametros).isEqualTo(" - DISCO 1: DIAMETRO 1 - \nDISCO 2: DIAMETRO 2 - \nDISCO 3: DIAMETRO 3 - \nDISCO 4: DIAMETRO 4 - \nDISCO 5: DIAMETRO 5 - \nDISCO 6: DIAMETRO 6 - \n");
    }
    
    // TESTE DE MOVIMENTO
    @Test
    public void tranferencia() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(5);
        assertThat(hanoi.validaMov(hanoi.pino1, hanoi.pino1)).isEqualTo(false);
    }
    
    // TESTE DE MOVIMENTO INVÁLIDO
    @Test
    public void movInvalido() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(4);
        hanoi.mov1to2();
        hanoi.mov1to3();
        hanoi.mov2to3();
        hanoi.mov1to2();
        hanoi.mov1to2();
        
        assertThat(hanoi.pino1.toString()).isEqualTo("[4]");
        assertThat(hanoi.pino3.toString()).isEqualTo("[2, 1]");
    }
    
    // TESTE DO GRÁFICO
    @Test
    public void grafico() {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarDiscos(3);
        hanoi.mov1to2();
        assertThat(hanoi.graf(hanoi.pino1)).isEqualTo("\n\n|++|\n|+++|\n====================\n\n");
        assertThat(hanoi.graf(hanoi.pino2)).isEqualTo("\n\n|+|\n====================\n\n");
        assertThat(hanoi.graf(hanoi.pino3)).isEqualTo("\n\n====================\n\n");
    }
    
}