package com.muchachos.normalize;

/**
 * 18/05/2020
 * @author Ramses
 */
public class Normalize {
    public String removeAcento(String str){
    str=str.replace('Š','S');
    str=str.replace('š','s');
    //str.replace('Ð','Dj');
    str=str.replace('Ž','Z');
    str=str.replace('ž','z');
    str=str.replace('À','A');
    str=str.replace('Á','A');
    str=str.replace('Â','A');
    str=str.replace('Ã','A');
    str=str.replace('Ä','A');
    str=str.replace('Å','A');
    str=str.replace('Æ','A');
    str=str.replace('Ç','C');
    str=str.replace('È','E');
    str=str.replace('É','E');
    str=str.replace('Ê','E');
    str=str.replace('Ë','E');
    str=str.replace('Ì','I');
    str=str.replace('Í','I');
    str=str.replace('Î','I');
    str=str.replace('Ï','I');
    str=str.replace('Ñ','N');
    str=str.replace('Ò','O');
    str=str.replace('Ó','O');
    str=str.replace('Ô','O');
    str=str.replace('Õ','O');
    str=str.replace('Ö','O');
    str=str.replace('Ø','O');
    str=str.replace('Ù','U');
    str=str.replace('Ú','U');
    str=str.replace('Û','U');
    str=str.replace('Ü','U');
    str=str.replace('Ý','Y');
    str=str.replace('Þ','B');
    //str.replace('ß','Ss');
    str=str.replace('à','a');
    str=str.replace('á','a');
    str=str.replace('â','a');
    str=str.replace('ã','a');
    str=str.replace('ä','a');
    str=str.replace('å','a');
    str=str.replace('æ','a');
    str=str.replace('ç','c');
    str=str.replace('è','e');
    str=str.replace('é','e');
    str=str.replace('ê','e');
    str=str.replace('ë','e');
    str=str.replace('ì','i');
    str=str.replace('í','i');
    str=str.replace('î','i');
    str=str.replace('ï','i');
    str=str.replace('ð','o');
    str=str.replace('ñ','n');
    str=str.replace('ò','o');
    str=str.replace('ó','o');
    str=str.replace('ô','o');
    str=str.replace('õ','o');
    str=str.replace('ö','o');
    str=str.replace('ø','o');
    str=str.replace('ù','u');
    str=str.replace('ú','u');
    str=str.replace('û','u');
    str=str.replace('ý','y');
    str=str.replace('ý','y');
    str=str.replace('þ','b');
    str=str.replace('ÿ','y');
    str=str.replace('ƒ','f');
    str=str.replace('~',' ');
    str=str.replace('^',' ');
    str=str.replace('´',' ');
    str=str.replace('`',' ');
    str=str.replace('~',' ');
        return str;
    }
}
