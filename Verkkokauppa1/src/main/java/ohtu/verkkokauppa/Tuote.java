
package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;

public class Tuote {
    public int id;
    public String nimi;
    public int hinta;
    @Autowired
    public Tuote(int id, String nimi, int hinta) {
        this.id = id;
        this.nimi = nimi;
        this.hinta = hinta;
    }

    @Override
    public boolean equals(Object o) {
        Tuote t = (Tuote)o;
        
        return id==t.id;
    }

    public int getId() {
        return id;
    }

    public int getHinta() {
        return hinta;
    }

    @Override
    public String toString() {
        return nimi;
    }            
    
}
