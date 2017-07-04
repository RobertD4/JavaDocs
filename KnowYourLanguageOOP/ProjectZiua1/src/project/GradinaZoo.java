package project;

import java.util.Date;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public final class GradinaZoo {

    private final String denumireGradinaZoo;
    private final Date dataDeschiriiGradiniii;
    private final AnimalZooRar animalRar;
    private final IngrijitorZoo angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschiriiGradiniii, AnimalZooRar animalRar, IngrijitorZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschiriiGradiniii = dataDeschiriiGradiniii;
        this.animalRar = animalRar;
        this.angajatulLunii = angajatulLunii;
    }

    public String getDenumireGradinaZoo() {
        return denumireGradinaZoo;
    }

    public Date getDataDeschiriiGradiniii() {
        return new Date(this.dataDeschiriiGradiniii.getTime());
    }

    public AnimalZooRar getAnimalRar() {
        return animalRar;
    }

    public IngrijitorZoo getAngajatulLunii() {
        return angajatulLunii;
    }
}
