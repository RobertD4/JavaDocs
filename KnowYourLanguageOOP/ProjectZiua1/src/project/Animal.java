package project;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public abstract class Animal {

    String numele;
    String numeleTariiDeOrigine;

    abstract void mananca(Object object) throws AnimalManancaOmException,AnimalManancaAnimal;
    abstract void seJoaca();
    abstract void faceBaie();
    void doarme(){
        System.out.println("Animalul doarme!");
    }

    public Animal(){
        System.out.println("Animal nou");
    }

    public Animal(String numele) {
        this.numele = numele;
    }

    public Animal(String numele, String numeleTariiDeOrigine){
        this.numele=numele;
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }



}
