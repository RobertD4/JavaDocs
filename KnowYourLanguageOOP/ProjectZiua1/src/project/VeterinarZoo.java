package project;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    @Override
    public void calculeazaBonusSalarial() {
        int bonus = 3*valoareBonusPerAnimal;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal!");
        if (animal instanceof AnimalZooFeroce) animal.faceBaie();
        calculeazaBonusSalarial();
    }
}
