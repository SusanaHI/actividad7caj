/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SusanaHI
 */
public class triangulo {
    
    public double base, altura, area, perimetro;
    
    public triangulo(String n1, String n2){
        this.setBase(Double.parseDouble(n1));
        this.setAltura(Double.parseDouble(n2));
        this.setArea(Double.parseDouble(n1),Double.parseDouble(n2));
        this.setPerimeter(Double.parseDouble(n1));        
    }
    
    public void setArea(double base, double altura){
        this.area = ((this.getBase()*this.getAltura())/2);
    }
    
    public double getArea(){
        return area;
    }
    
    public void setPerimeter(double base){
        this.perimetro = (this.getBase()*3);
    }
    
    public double getPerimeter(){
        return perimetro;
    }
    
    public void setBase(double base){
        this.base = base;
    }
    
    public double getBase(){
        return base;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getAltura(){
        return altura;
    }
    
}