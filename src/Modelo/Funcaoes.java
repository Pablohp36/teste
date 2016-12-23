/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Funcaoes {
    
    public double calcular (ArrayList calculo){
        ArrayList ordem = new ArrayList();
        ordem.add("^");
        ordem.add("R");
//        ordem.add("L");
        ordem.add("*");
        ordem.add("/");
        ordem.add("+");
        ordem.add("-");
        int tamanho = ordem.size();
        int tamanho2 = calculo.size();
        for (int i = 0;i< tamanho; i++){
            int posicao = 0;
            Iterator listar = calculo.iterator();
            while (listar.hasNext()) {
               
               String element = (String) listar.next();
               String operador = (String) ordem.get(i);
               String ante = "";
               if(element.equals(operador)){
                    String prox = (String) calculo.get(posicao+1);
                    if(!element.equals("P")|| element.equals("R")|| element.equals("L")){
                        ante = (String) calculo.get(posicao-1);
                    }else{
                        ante = (String) calculo.get(posicao +1);
                    }
                    
                    if(operador.equals("^")){
                        double result = Math.pow(Double.valueOf(ante), Double.valueOf(prox));
                        calculo.set(posicao-1, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                            }

                            if(posicao <= tamanho2){
                                calculo.remove(posicao);
                                
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        posicao--; 
                    }else if(operador.equals("+")){
                    double result = Double.valueOf(ante)+ Double.valueOf(prox);
                        calculo.set(posicao-1, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                            }

                            if(posicao <= tamanho2){
                                calculo.remove(posicao);
                                if(calculo.contains("+")){
                                    posicao--;
                                }
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        posicao--;
                        
                    }else if(operador.equals("-")){
                    double result = Double.valueOf(ante)- Double.valueOf(prox);
                        calculo.set(posicao-1, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                                calculo.remove(posicao);
                                if(calculo.contains("-")){
                                    posicao--;
                                }
                            }

                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        posicao--;
                        
                    }else if(operador.equals("*")){
                    double result = Double.valueOf(ante)* Double.valueOf(prox);
                        calculo.set(posicao-1, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                                calculo.remove(posicao);
                                if(calculo.contains("*")){
                                    posicao--;
                                }
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        posicao--; 
                    }else if(operador.equals("/")){
                    double result = Double.valueOf(ante)/ Double.valueOf(prox);
                        calculo.set(posicao-1, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                                calculo.remove(posicao);
                                if(calculo.contains("/")){
                                    posicao--;
                                }
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        posicao--;
                    }else if(operador.equals("R")){
                    double result = Math.sqrt(Double.valueOf(prox));
                        calculo.set(posicao, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 ){
                                calculo.remove(posicao+1);
                                
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                    }else if(operador.equals("L")){
                    double result = Math.log(Double.valueOf(prox));
                        calculo.set(posicao, String.valueOf(result));
                        try {
                            if(posicao <= tamanho2 && posicao-1 >=0){
                                calculo.remove(posicao);
                                
                            }
                        listar = calculo.iterator();
                        tamanho2 = calculo.size();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                    }
               }//fecha if
                //System.out.println(posicao);
               posicao++;
                
                
            }//fin while
            
        }//fin for
        double retorno = Double.valueOf((String)calculo.get(0));
       // calculo.clear();
        return retorno;
    }


}