package edu.eci.cvds.servlet.bean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Random;

//@ManagedBean(name="calculadoraBean")
//@SessionScoped;

public class CalculadoraBean {
    private ArrayList<Float>Lista;
    private float media,moda,varianza,dvarianza;
    public  CalculadoraBean() {

    }

    public ArrayList<Float>getLista(){
        return Lista;
    }
    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getModa() {
        return moda;
    }

    public void setModa(float moda) {
        this.moda = moda;
    }

    public float getVarianza() {
        return varianza;
    }

    public void setVarianza(float varianza) {
        this.varianza = varianza;
    }

    public float getDvarianza() {
        return dvarianza;
    }

    public void setDvarianza(float dvarianza) {
        this.dvarianza = dvarianza;
    }

    public float calculateMean(ArrayList<Float> numeros){
        float suma = 0,media ;
        for(int i = 0; i<numeros.size();i++){
            suma += numeros.get(i);
        }
        media =  suma/numeros.size();
        return media;
    }

    public float calculateVariance(ArrayList<Float> numeros){
        float varianza=0;
        for(int i = 1 ; i< numeros.size();i++){
            varianza+= (Math.pow(numeros.get(i)-calculateMean(numeros),2)/numeros.size()-1) ;
        }
        return varianza;
    }

    public float calculateStandardDeviation(ArrayList<Float> numeros){
        return (float) Math.sqrt(calculateVariance(numeros));
    }

    public float calculateMode(ArrayList<Float> numeros){
        float number,cont = 0,value = 0,rep = 0;

        for(int i=0;i<numeros.size();i++){
            number = numeros.get(i);

            for(int j=i+1;j<numeros.size();j++){
                if(numeros.get(j)==number){
                    cont++;
                }
            }

            if(cont>rep) {
                value = number;
                rep = cont;
            }

            cont = 0;
        }
        return value;
    }

    public void restart(){
        media = 0;
        moda = 0;
        dvarianza = 0;
        varianza = 0;
        Lista = new ArrayList<Float>();
    }
}