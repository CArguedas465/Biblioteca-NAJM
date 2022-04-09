
package sistemabiblioteca.Idiomas;

import java.util.Properties;


public class Idioma extends Properties{
    
    /*En su constructor se solicitan las propiedades de los archivos de propiedades inglés y español*/
    public Idioma(String idioma){
        switch(idioma){
            case "Español":
                getProperties("espanol.properties");
                break;
            case "Inglés":
                getProperties("ingles.properties");
                break;
        }
        
    }
    
    /*Retorna la propiedad solicitada*/
    private void getProperties(String idioma){
        try {
            this.load(getClass().getResourceAsStream(idioma));
        } catch (Exception e){}
    }
}
