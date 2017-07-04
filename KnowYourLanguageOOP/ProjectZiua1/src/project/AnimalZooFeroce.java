package project;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooRar se joaca!");
        super.doarme();
    }

    @Override
    void faceBaie(){
        System.out.println("AnimalulZooRar face baie!");
    }

    public AnimalZooFeroce() {
    }

    public AnimalZooFeroce(String numele, String numeleTariiDeOrigine) {
        super(numele, numeleTariiDeOrigine);
    }

    void doarme(){
        super.doarme();
        System.out.println("Animal feroce vaneaza!");
    }

    void mananca(Object object) throws AnimalManancaOmException,AnimalManancaAnimal{
        if (object instanceof AngajatZoo) throw new AnimalManancaOmException("Stai ca vine!");
            else System.out.println("E safe!");
        if (object instanceof Animal) throw new AnimalManancaAnimal("Stai ca vine dupa tine!");
            else System.out.println("AnimalZooRar mananca!");

    }
}
