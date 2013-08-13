/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dto;

/**
 *
 * @author USUARIO
 */
public class dtotvl {

    private String id_bloque = "";
    private String nombre_bloque = "";
    private String padre_bloque = "";
    private String abuelo_bloque = "";
    private String contiene_bloque = "";
    private int nivel = 0;
    private String name_feacture = "";
    private int nro_feacture_bloque = 0;
    private int mincardinalidad_bloque = 0;

    public String getAbuelo_bloque() {
        return abuelo_bloque;
    }

    public void setAbuelo_bloque(String abuelo_bloque) {
        this.abuelo_bloque = abuelo_bloque;
    }




    public String getPadre_bloque() {
        return padre_bloque;
    }

    public void setPadre_bloque(String padre_bloque) {
        this.padre_bloque = padre_bloque;
    }

    public int getMincardinalidad_bloque() {
        return mincardinalidad_bloque;
    }

    public void setMincardinalidad_bloque(int mincardinalidad_bloque) {
        this.mincardinalidad_bloque = mincardinalidad_bloque;
    }

    public String getName_feacture() {
        return name_feacture;
    }

    public void setName_feacture(String name_feacture) {
        this.name_feacture = name_feacture;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNro_feacture_bloque() {
        return nro_feacture_bloque;
    }

    public void setNro_feacture_bloque(int nro_feacture_bloque) {
        this.nro_feacture_bloque = nro_feacture_bloque;
    }

    public dtotvl() {
    }



    public dtotvl(String id_bloque, String nombre_bloque, String contiene_bloque, int nro_feacture_bloque, int nivel,
            String padre_bloque,String abuelo_bloque) {
        this.id_bloque = id_bloque;
        this.nombre_bloque = nombre_bloque;
        this.contiene_bloque = contiene_bloque;
        this.nro_feacture_bloque = nro_feacture_bloque;
        this.nivel = nivel;
        this.padre_bloque = padre_bloque;
        this.abuelo_bloque=abuelo_bloque;
    }

    public dtotvl(String id_bloque, String nombre_bloque, String contiene_bloque, int nro_feacture_bloque) {
        this.id_bloque = id_bloque;
        this.nombre_bloque = nombre_bloque;
        this.contiene_bloque = contiene_bloque;
        this.nro_feacture_bloque = nro_feacture_bloque;
    }

    public String getContiene_bloque() {
        return contiene_bloque;
    }

    public void setContiene_bloque(String contiene_bloque) {
        this.contiene_bloque = contiene_bloque;
    }

    public String getNombre_bloque() {
        return nombre_bloque;
    }

    public void setNombre_bloque(String nombre_bloque) {
        this.nombre_bloque = nombre_bloque;
    }

    /**
     * Get the value of id_bloque
     *
     * @return the value of id_bloque
     */
    public String getId_bloque() {
        return id_bloque;
    }

    /**
     * Set the value of id_bloque
     *
     * @param id_bloque new value of id_bloque
     */
    public void setId_bloque(String id_bloque) {
        this.id_bloque = id_bloque;
    }
}
