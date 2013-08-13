/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cesareduardosuareztrujillo
 */
public class tvlexpression {
    
    
    
    
    
    public static ArrayList checkAtributos(String expresion,ArrayList atributos,int Nivel){
        
        
        
        //Partir el texto por { y se miran cuantos elementos tiene
        String[] partes = expresion.split("\\{"); 
        
        
        for(int i=0;i<partes.length;i++){
            if(!partes[i].toString().isEmpty()){
                if(i==0){
                    partes[0] = partes[0].replaceAll("root", "");

                    String[] name = {partes[0].toString(),"bool","0","-"};
                    atributos.add(name);

                   // System.out.println(partes[0]);
                // new String[partes[0],0];
                }else{
                //Analisis del resto 
                    
                    //Elementos separados por , son restricciones o atributos que ya no tienen mas ramas
                    
                        //System.out.println(partes[i]);
                        Pattern p = Pattern.compile("(groupallOf|groupone|groupall|group|groupsomeOf)");
                        

                        
                        
                        String[] partesinternas1 = partes[i].split("\\};"); 
                        
                        //Dividimos el bloque en }; cada uno de estos se vuelve a dividir en , donde el 
                        //ultimo representa al dueño de un grupo de nuevo elementos los otros son restricciones 
                        for(int k=0;k<partesinternas1.length;k++){
                            
                            
                            
                            String[] masinterna = partesinternas1[k].split("\\,"); 
                            
                            for(int j=0;j<masinterna.length;j++){
                                
                                Matcher m = p.matcher(masinterna[j]);
                                boolean attr=true;
                                
                                while (m.find()) {
                                    
                                    //System.out.println("No es un feature " + m.group() );
                                    
                                    //animals.add(m.group());
                                    String[] name = {masinterna[j].toString(),"NULL",Integer.toString(Nivel),"-"}; //No es una feature
                                    atributos.add(name);
                                    attr=false;
                                    
                                }  
                                
                                if(attr){
                                    
                                     masinterna[j] = masinterna[j].replaceAll("}", "");
                                     masinterna[j] = masinterna[j].replaceAll("\\n", "").replaceAll("\\t", "").replaceAll(" ", "").replaceAll("\\r", "");
                                     String[] name=new String[4];
                                     if(masinterna[j].toString()!=null && !masinterna[j].toString().equals("")){
                                        //String[] name;
                                         if(j ==(masinterna.length-1)){
                                             
                                            //name ={masinterna[j].toString(),"bool",Integer.toString(Nivel),"more"]; //No es una feature
                                             name[0]=masinterna[j].toString();
                                             name[1]="bool";
                                             name[2]=Integer.toString(Nivel);
                                             name[3]="more";
                                        }else{
                                          //String[]   name = {masinterna[j].toString(),"bool",Integer.toString(Nivel),"-"};
                                             name[0]=masinterna[j].toString();
                                             name[1]="bool";
                                             name[2]=Integer.toString(Nivel);
                                             name[3]="-";
                                        }
                                        atributos.add(name);
 
                                       // System.out.println("Es un potencial Feature " + masinterna[j].toString());
                                     }
                                }
                                
                            }
                            

                        
                        }
                        
                        
                    
                }
            }
        
        }
        
        
        //expresion.toLowerCase().contains("root".toLowerCase());
        
        
        //return checkRestricciones(atributos);
        return atributos;
    }
    
    
    //Verficar los atributos que pueden ser realmente restricciones
    public static ArrayList checkRestricciones(ArrayList atributos){
        ArrayList atributosnew=new ArrayList();
        
        
        /*
         * 
         * Listado de palabras reservadas
         SIMPLE_TYPE = " int " ID "in" SET_EXPRESSION ";"
| " real " ID "in" SET_EXPRESSION ";"
| " enum " ID "in" SET_EXPRESSION ";"
| "int " ID ";"
| " real " ID ";"
| " bool " ID ";" ;
         */
        for(int i=0; i<atributos.size();i++){
        
            Object name = atributos.get(i);
            String[] name2 =(String[])name;
            if(!name2[1].equals("NULL")){
                 //Pattern p = Pattern.compile("(real|enum|int|real|bool)");
                 //System.out.print(name2[0]+",");
                  //String[] vars = {name2[0].toString(),name2[1].toString()};
                  //atributosnew.add(vars);
                 
                Pattern p = Pattern.compile("(ifIn:|real|enum|int|real|bool|==)");
                
                
                
                String[] vars = {name2[0].toString(),name2[1].toString()}; //No es una feature
                
                
                Matcher m = p.matcher(name2[0]);
                boolean attr=true;

                    while (m.find()) {

                        System.out.print("encontro \r");
                      attr=false;
                                    
                     }  
                                
                     if(attr){
                         
                         
                         atributosnew.add(vars);
                         
                     }
                
                
                
            }
        }
        
                             

        
        
        
        return atributosnew;
        
    }
    
    public static void imprimirAtributos(ArrayList atributos) {
        
        for(int i=0; i<atributos.size();i++){
        
            Object name = atributos.get(i);
            String[] name2 =(String[])name;
            if(!name2[1].equals("NULL")){
                System.out.print(name2[0]+",");
            }
        }
            
           
        
        
        
    }
    
    public static ArrayList checkRestricciones(String expresion){
         ArrayList atributos=new ArrayList();
        
        
        return atributos;
    }
    
}
