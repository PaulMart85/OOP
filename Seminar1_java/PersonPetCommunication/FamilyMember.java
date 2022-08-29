package Seminar1_java.PersonPetCommunication;

public class FamilyMember {
    private String name;
    private Status status;
    private static Pet dog;
    private static Pet cat;
    public static boolean alarm = false;

    /**
     * Создание члена семьи.
     * @param name имя члена семьи
     * @param st его статус: отец (FATHER), мать (MOTHER) или ребенок (CHILD)
     */
    public FamilyMember(String name, Status st) {
        this.name = name;
        status = st;
        dog = new Pet();
        cat = new Pet();
    }

    public String getName() {
        return name;
    }

    /**
     * Семья обзавелась собакой. Возможно иметь только одну собаку (папа больше не разрешает :)))
     * @param newDog та самая новая собака
     * @return
     */
    public static String takeDog(Pet newDog) { // можно было void, но взял String, чтобы метод сообщал, какую собаку приобрели
        dog = newDog;
        return dog.getPetName();
    }

    /**
     * Семья взяла кота/кошку. Можно взять только одного (тут мама больше не разрешает :))
     * @param newCat тот самый новый кот или кошка
     * @return 
     */
    public static String takeCat(Pet newCat) {
        cat = newCat;
        return cat.getPetName();
    }
    
    /**
     * Питомец обращается к семье с потребностью. Может отреагировать любой член семьи
     */
    public static void contactFamily() {
        alarm = true;
    }     

    /**
     * Реакция членов семьи на обращение питомца.
     * У питомца в данный момент может быть только одна потребность,
     * после удовлетворения которой возможна другая потребность.
     * В семье обязанности распределены между ее членами:
     * Ребенок занимается только кормлением,
     * Отец - только выгулом,
     * Мать приласкает
     */
    public void reactFamily() {
        if (status == null)
            System.out.println(name + " - Вы не член семьи.");
        else 
            switch (status) {
                case CHILD: // ребенку в семье поручено только кормить питомцев
                    if (dog.getNeeds() == Need.HUNGRY) dog.setNeeds(null);
                    if (cat.getNeeds() == Need.HUNGRY) cat.setNeeds(null);
                    if (dog.getNeeds() == null && cat.getNeeds() == null) alarm = false;
                    break;
                case MOTHER: // мать ласкает
                    if (dog.getNeeds() == Need.FONDLE) dog.setNeeds(null);
                    if (cat.getNeeds() == Need.FONDLE) cat.setNeeds(null);
                    if (dog.getNeeds() == null && cat.getNeeds() == null) alarm = false;
                    break;
                case FATHER: // отец выгуливает
                    if (dog.getNeeds() == Need.WALK) dog.setNeeds(null);
                    if (cat.getNeeds() == Need.WALK) cat.setNeeds(null);
                    if (dog.getNeeds() == null && cat.getNeeds() == null) alarm = false;
                    break;    
                default:                    
                    break;
            }
    }
}
