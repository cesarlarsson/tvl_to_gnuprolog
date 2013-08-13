/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.utils;

/**
 *
 * @author USUARIO
 */
public class Utilidades {

     public String padr(String stringoriginal, int lenstring, String stringllenado) {
        if (stringoriginal == null) {
            stringoriginal = " ";
        }
        String stringllegada = stringoriginal.trim();
        int lencadena = stringllegada.length();
        String stringreturn = "";
        String stringrelleno = "";
        int nrocarllenados = Math.abs(lenstring - lencadena);
        if (lencadena < lenstring) {
            for (int i = 0; i <= nrocarllenados - 1; i++) {
                stringrelleno = stringrelleno + stringllenado;
            }
        } else {
            stringllegada = stringllegada.substring(0, lenstring);
            stringrelleno = "";
        }
        return stringllegada + stringrelleno;
    }

    public String padl(String stringoriginal, int lenstring, String stringllenado) {
        if (stringoriginal == null) {
            stringoriginal = " ";
        }
        String stringllegada = stringoriginal.trim();
        int lencadena = stringllegada.length();
        String stringreturn = "";
        String stringrelleno = "";
        int nrocarllenados = Math.abs(lenstring - lencadena);
        if (lencadena < lenstring) {
            for (int i = 0; i <= nrocarllenados - 1; i++) {
                stringrelleno = stringrelleno + stringllenado;
            }
        } else {
            stringllegada = stringllegada.substring(0, lenstring);
            stringrelleno = "";
        }
        return stringrelleno + stringllegada;
    }


}
