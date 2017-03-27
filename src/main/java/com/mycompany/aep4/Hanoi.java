package com.mycompany.aep4;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class Hanoi {
    
    ArrayList pino1,pino2,pino3;
    ArrayList discos;

    public Hanoi() {
        pino1 = new ArrayList();
        pino2 = new ArrayList();
        pino3 = new ArrayList();
        discos = new ArrayList();                                                                                      
    }   
    
    public void iniciarDiscos(int qnt) {
        for (int diametro = 0; diametro < qnt; diametro++) {
            discos.add(diametro+1);
            System.out.println(discos.toString()+"INICIADO DISCO\n========================");
        }
        iniciarPilha();
    }
    
    public void iniciarPilha() {
        int count = 0;
        for (int i = 0; i < discos.size(); i++) {
            pino1.add(discos.get(i));
            System.out.println(pino1.toString()+"INICIADO PILHA\n========================");
        }
    }
    
    public boolean verificarJogo(ArrayList mov1, ArrayList mov2, ArrayList mov3) {
        if ((!"[]".equals(mov1.toString())) || (mov1.size() != 1)) {
            for (int x = 1; x < mov1.size(); x++) {
                if (Integer.parseInt(mov1.get(x).toString()) > Integer.parseInt(mov1.get(x-1).toString())) {
                    System.out.println("JOGO RUIM - PILHA 1\n --------------------------------");
                    return false;
                }
            }
        }
        
        if ((!"[]".equals(mov2.toString())) || (mov2.size() != 1)) {
        
            for (int y = 1; y < mov2.size(); y++) {
                if (Integer.parseInt(mov2.get(y).toString()) > Integer.parseInt(mov2.get(y-1).toString())) {
                    System.out.println("JOGO RUIM - PILHA 2\n --------------------------------");
                    return false;
                }
            }
        }
        
        if ((!"[]".equals(mov3.toString())) || (mov3.size() != 1)) {
            for (int z = 1; z < mov3.size(); z++) {
                if (Integer.parseInt(mov3.get(z).toString()) > Integer.parseInt(mov3.get(z-1).toString())) {
                    System.out.println("JOGO RUIM - PILHA 3\n --------------------------------");
                    return false;
                }
            }
        }
        System.out.println("JOGO FMZ\n --------------------------------");
        return true;        
    }
    
    public boolean mov1to2() {
        if (validaMov(pino1, pino2)) {
            String vlr = pino1.get(0).toString();
            pino1.remove(0);
            pino2.add(vlr);
            System.out.println("MOVIMENTO 1 TO 2 --> "+vlr+" to ==> "+pino2.toString());
            return true;
        }
        return false;
    }
    
    public boolean mov1to3() {
        if (validaMov(pino1, pino3)) {
            String vlr = pino1.get(0).toString();
            pino1.remove(0);
            pino3.add(vlr);
            System.out.println("MOVIMENTO 1 TO 3 --> "+vlr+" to ==> "+pino3.toString());
            return true;
        }
        return false;
    }
    
    public boolean mov2to1() {
        if (validaMov(pino2, pino1) == true) {
            String vlr = pino2.get(0).toString();
            pino2.remove(0);
            pino1.add(vlr);
            System.out.println("MOVIMENTO 2 TO 1 --> "+vlr+" to ==> "+pino1.toString()); 
            return true;
        }
        return false;
    }  
    
    public boolean mov2to3() {
        if (validaMov(pino2, pino1) == true) {
            String vlr = pino2.get(0).toString();
            pino2.remove(0);
            pino3.add(vlr);
            System.out.println("MOVIMENTO 2 TO 1 --> "+vlr+" to ==> "+pino3.toString()); 
            return true;
        }
        return false;
    } 
    
    public boolean mov3to1() {
        if (validaMov(pino3, pino1)) {
            String vlr = pino3.get(0).toString();
            pino3.remove(0);
            pino1.add(vlr);
            System.out.println("MOVIMENTO 3 TO 1 --> "+vlr+" to ==> "+pino1.toString());
            return true;
        }
        return false;
    }
    
    public boolean mov3to2() {
        if (validaMov(pino3, pino1)) {
            String vlr = pino3.get(0).toString();
            pino3.remove(0);
            pino2.add(vlr);
            System.out.println("MOVIMENTO 3 TO 2 --> "+vlr+" to ==> "+pino2.toString());
            return true;
        }
        return false;
    }
    
    public boolean validaMov(ArrayList mov1, ArrayList mov2) {
        if (!mov1.isEmpty()) {
            if (mov2.isEmpty()) {
                System.out.println("SUMEMO! PINO VAZIO");
                return true;
            } else {
                int tm1 = mov1.size();
                int tm2 = mov2.size();
                int vl1 = Integer.parseInt(mov1.get(tm1-1).toString());
                int vl2 = Integer.parseInt(mov2.get(tm2-1).toString());
                if (vl2 > vl1) {
                    System.out.println("SUMEMO! "+mov1.get(0).toString()+" É MENOR QUE "+mov2.get(0).toString());
                    return true;
                } else if (vl2 < vl1){
                    System.out.println("TA ZUADO! "+mov1.get(0).toString()+" É MAIOR QUE "+mov2.get(0).toString());
                } else {
                    System.out.println("TA ZUADO! NÃO PODE COLOCAR O ELEMENTO DE UM PINO NELE MEMO");
                }
            }
        } else {
            System.out.println("TA ZUADO! PINO VAZIO NÃO DÁ PRA TIRA O QUE NÃO TEM");
        }      
        return false;
    }
    
}
