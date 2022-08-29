package Seminar1_java.PersonPetCommunication;

public class Pet {
    private String petName;
    private Need needs;

    public Pet() {}

    /**
     * Создаем питомца
     * @param name его имя
     */
    public Pet(String name) {
        petName = name;
    }

    public String getPetName() {
        return petName;
    }

    public Need getNeeds() {
        return needs;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * Потребность питомца.
     * @param needs Варианты: кормление (HUNGRY), выгул (WALK), ласка (FONDLE)
     * @return
     */
    public void setNeeds(Need needs) {
        this.needs = needs;
    }

    /**
     * Питомец сигнализирует о потребности.
     * У одного питомца в данный момент может быть только одна потребность,
     * после удовлетворения которой возможна другая потребность.
     * В случае удовлетворения потребности у обеих питомцев, сигнал alarm в семье прекращается.
     * @param need варианты из enum Need
     */
    public void communicate(Need need) {
        if (need != null) {
            needs = need;  
            FamilyMember.contactFamily();
        }      
    }    
    

}
