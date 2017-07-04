package project;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo{
    @Override
    public void calculeazaBonusSalarial() {
        int bonus= 3*valoareBonusPerAnimal;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca aninalului");
    }


    public void lucreaza(Animal animal,Object mancare) throws AnimalManancaOmException,AnimalPeCaleDeDisparitieException {
        lucreaza(animal);
        animal.doarme();
        animal.faceBaie();
        animal.seJoaca();
        animal.mananca(mancare);

        if (animal instanceof AnimalZooRar && mancare ==null) throw new AnimalPeCaleDeDisparitieException();
        calculeazaBonusSalarial();
    }
}
