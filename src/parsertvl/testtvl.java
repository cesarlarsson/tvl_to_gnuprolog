/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertvl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dto.dtotvl;
import org.utils.Utilidades;
import org.utils.tvlexpression;

/**
 *
 * @author USUARIO
 */
public class testtvl {

    private static ArrayList lista = new ArrayList();
    private static int nro_bloque = 0;
    private static String txtbloque1 = "";
    private static String txtbloque2 = "";
    private static String txtbloque3 = "";
    private static String txtbloque4 = "";
    private static String txtbloque5 = "";
    private static String txtbloque6 = "";
    private static Utilidades util = new Utilidades();

    public static void main(String args[]) throws FileNotFoundException {

        try {
            String inb = testtvl("/Users/cesareduardosuareztrujillo/Documents/CesarThanatos/ProyectosJava/TVLtoProlog/src/eldecesar_1.tvl"); //test5LongID --- eldecesar -- cesar1.tvl   ---rexel_v4


            BlockstoList(inb);



            leerList();
        } catch (IOException ex) {
            Logger.getLogger(testtvl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void printBlocks(String untexto) {

        String txtseparador_bloque = ",";

        // System.out.println("bloques..." +untexto);

        String[] bloques = untexto.split(txtseparador_bloque);
        if (bloques.length > 0) {
            for (int i = 0; i <= bloques.length - 1; i++) {
                System.out.println("Valor de I" + i);
                if (bloques[i] != null) {
                    System.out.println(i + " bloques..." + bloques[i]);
                }
            }


        }


    }

    public static void BlockstoList(String untexto) {
        String txtseparador_bloque = ",";

        int control_bloque = 0;
        String strabrellave = "{";
        String strcierrallave = "}";
        //String txtbloque = "";
        //nro_bloque = 0;
       // String txtultimobloque = "";
        int maxnivelbloque = 0;


        for (int x = 0; x < untexto.length(); x++) {
            
            
            //txtbloque = txtbloque + String.valueOf(untexto.charAt(x));

            if (String.valueOf(untexto.charAt(x)).equals(strabrellave)) {
                control_bloque = control_bloque + 1;

            }
            maxnivelbloque = Math.max(maxnivelbloque, control_bloque);
            if (String.valueOf(untexto.charAt(x)).equals(strcierrallave)) {
                control_bloque = control_bloque - 1;
            }

        }

        for (int i = 0; i < maxnivelbloque; i++) {
            
            
            //System.out.println(untexto);
            //System.out.println("--------------");
            BlockstoListIndex(untexto, i);

        }

    }

    public static String testtvl(String txtargs) throws FileNotFoundException, IOException {
        String srcFile = txtargs;
        String destFile = txtargs;
        System.out.println("File  -->" + txtargs);
        String txtstring = "";

        try {

            InputStream oInStream = new FileInputStream(srcFile);
            //OutputStream oOutStream = new FileOutputStream(destFile);

            // Transfer bytes from in to out
            byte[] oBytes = new byte[1];
            int nLength;
            String texto = "";
            BufferedInputStream oBuffInputStream = new BufferedInputStream(oInStream);
            String uncaracter = "";
            while ((nLength = oBuffInputStream.read(oBytes)) > 0) {
                uncaracter = ((new String(oBytes).replaceAll("\\n", "")).replaceAll("\\t", "")).replaceAll(" ", "");
                texto = uncaracter;
                //oOutStream.write(oBytes, 0, nLength);

                txtstring = txtstring + texto;

            }
            txtstring.replaceAll("   ", "").replaceAll("    ", "").replaceAll("      ", "");

            //System.out.println("Texto Leido -->" + txtstring);
            oInStream.close();
        //oOutStream.close();

        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTestcabsa: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTestcabsa: " + e);
        } finally {
        }
        return txtstring;


    }

    private static void BlockstoListIndex(String untexto, int i) {
        String txtseparador_bloque = ",";

        int control_bloque = 0;
        String strabrellave = "{";
        String strcierrallave = "}";
        int nroleidobloque = 0;
        String txtbloqueleido = "";
        String txtbloquepadre = "";
        String txtbloqueabuelo = "";


        for (int x = 0; x < untexto.length(); x++) {
            //System.out.println("Caracter " + x + ": " + untexto.charAt(x));
            //txtbloque6 = txtbloque6 + String.valueOf(untexto.charAt(x));
            //txtultimobloque = txtultimobloque + String.valueOf(untexto.charAt(x));

            if (String.valueOf(untexto.charAt(x)).equals(strabrellave)) {
                control_bloque = control_bloque + 1;
                nroleidobloque = nroleidobloque + 1;

            };
            
            if (String.valueOf(untexto.charAt(x)).equals(strcierrallave)) {
                control_bloque = control_bloque - 1;
            };

            if (i > 0) {
                if (i > 0 && control_bloque == i) {
                    txtbloquepadre = txtbloquepadre + String.valueOf(untexto.charAt(x));
                }
                if (i > 1 && control_bloque == i - 1) {
                    txtbloqueabuelo = txtbloqueabuelo + String.valueOf(untexto.charAt(x));
                }


                if (control_bloque == i + 1) {
                    txtbloqueleido = txtbloqueleido + String.valueOf(untexto.charAt(x));
                }
            } else {
                if (control_bloque <= 1) {
                    txtbloqueleido = txtbloqueleido + String.valueOf(untexto.charAt(x));
                }
            }

            String id_bloque = "";
            if (control_bloque == i && String.valueOf(untexto.charAt(x)).equals(strcierrallave)) {
                nro_bloque = nro_bloque + 1;
                //Utilidades util = new org.utils.Utilidades();

                //util.padl(String.valueOf(i), 10, "0")+"-"+util.padl(String.valueOf(nroleidobloque), 10, "0")
                id_bloque = util.padl(String.valueOf(nroleidobloque), 10, "0") + "-" + util.padl(String.valueOf(i), 10, "0");
                lista.add(new org.dto.dtotvl(id_bloque, "bloque_" + String.valueOf(nro_bloque), txtbloqueleido, nroleidobloque, i,
                        txtbloquepadre, txtbloqueabuelo));
                //System.out.println(txtbloqueleido + nro_bloque + " Nivel 5 ");
                //txtbloque3= "" ;
                
                //Procesar atributos
               // System.out.println(txtbloqueleido);
                
              //  System.out.println("***");
                
                
                txtbloqueleido = "";
                txtbloquepadre = "";
                txtbloqueabuelo = "";
            }

            if (control_bloque == i - 1 && String.valueOf(untexto.charAt(x)).equals(strcierrallave)) {

                txtbloqueabuelo = "";
            }

            if (control_bloque == i - 2 && String.valueOf(untexto.charAt(x)).equals(strcierrallave)) {
                txtbloquepadre = "";
            }

        }
    }

    private static void leerList() {

        

        ArrayList atributos=new ArrayList();
        Collections.sort(lista, new columComparador());

        Iterator it = lista.iterator();
        //int filas_lista = 0;
        org.dto.dtotvl dtotvl = null;
        while (it.hasNext()) {
            dtotvl = (dtotvl) it.next();
            //System.out.println("Contenido getId_bloque" + dtotvl.getId_bloque());
            //System.out.println("Nombre_bloque  --->>>>" + dtotvl.getNombre_bloque());
            
//            if (!(dtotvl.getAbuelo_bloque() == null || dtotvl.getAbuelo_bloque().equals("")) || dtotvl.getNivel() == 0) {
//
//                System.out.println(dtotvl.getId_bloque() +
//                        " [Abuelo] -->" + dtotvl.getAbuelo_bloque() +
//                        " [Padre] -->" + dtotvl.getPadre_bloque() + "  -[bloque]-->" + dtotvl.getNro_feacture_bloque() + dtotvl.getContiene_bloque().trim());
//            }
            
            
           //System.out.println( dtotvl.getContiene_bloque());
            
           atributos= tvlexpression.checkAtributos(dtotvl.getContiene_bloque(),atributos,dtotvl.getNivel()); 
            
         // System.out.println( dtotvl.getContiene_bloque());
          
            
        //filas_lista++;


        //System.out.println("Nivel " + dtotvl.getContiene_bloque());
        //System.out.println("" + dtotvl.getNivel());
        }
        
        
        getSemantica(atributos);
        
        ArrayList lineas=new ArrayList();
        ArrayList pureFeatures=tvlexpression.checkRestricciones(atributos);
        
        
        String features=buildProductline(pureFeatures);
        
        lineas.add("F="+features+",");
        lineas.add("fd_domain("+features+", 0, 1),");
        String[] root=(String[])pureFeatures.get(0); 
        lineas.add(root[0]+"#=1,");
        
        //tvlexpression.imprimirAtributos(atributos);
        
       
        generarDocumentoProlog(lineas);
        
    }

    
    
    
    public static ArrayList getSemantica(ArrayList Features){
        
        for(int k=0; k<Features.size();k++){
            
            String[] valores=(String[]) Features.get(k);
            
            System.out.println(valores[0]+" "+valores[2]+" "+valores[1] +"  "+valores[3]);
            
            
            
            
            
        }
        
        return Features;
        
    }
    
    public static String buildProductline(ArrayList pureFeatures){
        
        
        String features="[";
        for(int w=0; w<pureFeatures.size();w++){
            
            
            Object name = pureFeatures.get(w);
            String[] name2 =(String[])name;
            
            features=features+name2[0];
            if(w<pureFeatures.size()-1){
               features=features +",";
            }
        }
        
        features=features+"]";
        return features;
        
    }
    
    public static void generarDocumentoProlog(ArrayList listtexto){
    
        Writer writer = null;

                try {
                    String text1 = "%Archivo: gnuprolog.pl\r ";
                    text1 = text1 +"%Codigo autogenerado\r";
                    text1 = text1 +"%Desarrollado por:\r";
                    text1 = text1 +"%Mauricio Hurtado\r";
                    text1 = text1 +"%Luis Fernando Cadavid\r";
                    text1 = text1 +"%César Eduardo Suárez T\r\r";

                    for(int w=0; w<listtexto.size();w++){
                        
                        text1 = text1 +listtexto.get(w).toString()+"\r";
                    }
                    
                    
                    File file = new File("gnuprolog.pl");
                    writer = new BufferedWriter(new FileWriter(file));
                    writer.write(text1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (writer != null) {
                            writer.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
    }
   
    
    public static class columComparador implements Comparator {

        public int compare(Object o1, Object o2) {
            String colname = "id_bloque";
            boolean ascending = false;


            dtotvl dto = (dtotvl) o1;
            dtotvl dto2 = (dtotvl) o2;

            int returnval = 0;
            String strnivel1, strnivel2 = "";
            String strnrobloque1, strnrobloque2 = "";
            if (colname.equals("id_bloque")) {

                //strnivel1 = util.padl(String.valueOf(dto.getNivel()),10,"0");
                //strnivel2 =util.padl(String.valueOf(dto2.getNivel()),10,"0");

                strnrobloque1 = util.padl(String.valueOf(dto.getNro_feacture_bloque()), 10, "0");
                strnrobloque2 = util.padl(String.valueOf(dto2.getNro_feacture_bloque()), 10, "0");
                //returnval = ascending ? strnivel1.compareTo(strnivel2) : strnivel2.compareTo(strnivel1);

                //returnval = ascending ? dto.getId_bloque().compareTo(dto2.getId_bloque()) : dto2.getId_bloque().compareTo(dto.getId_bloque());

                returnval = ascending ? strnrobloque1.compareTo(strnrobloque2) : strnrobloque2.compareTo(strnrobloque1);

            //returnval = ascending ? dto.getId_bloque().compareTo(dto2.getId_bloque())  : dto2.getId_bloque().compareTo(dto.getId_bloque());
            //returnval = !ascending ? String.valueOf(dto.getNivel()).compareTo(String.valueOf(dto.getNivel()) : dto2String.valueOf(dto.getNivel()).compareTo(dto.getId_bloque());
            }


            if (colname.equals("id_nivel")) {

                strnivel1 = util.padl(String.valueOf(dto.getNivel()), 10, "0");
                strnivel2 = util.padl(String.valueOf(dto2.getNivel()), 10, "0");

                //strnrobloque1 = util.padl(String.valueOf(dto.getNro_feacture_bloque()),10,"0");
                //strnrobloque2 = util.padl(String.valueOf(dto2.getNro_feacture_bloque()),10,"0");
                returnval = ascending ? strnivel1.compareTo(strnivel2) : strnivel2.compareTo(strnivel1);

            //returnval = ascending ? dto.getId_bloque().compareTo(dto2.getId_bloque()) : dto2.getId_bloque().compareTo(dto.getId_bloque());

            //returnval = ascending ? strnrobloque1.compareTo(strnrobloque2) : strnrobloque2.compareTo(strnrobloque1);

            //returnval = ascending ? dto.getId_bloque().compareTo(dto2.getId_bloque())  : dto2.getId_bloque().compareTo(dto.getId_bloque());

            }


            return returnval;

        }
    }
}
