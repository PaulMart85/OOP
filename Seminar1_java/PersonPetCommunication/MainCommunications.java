package Seminar1_java.PersonPetCommunication;

public class MainCommunications {

    public static void main(String[] args) {
        // создадим семью
        FamilyMember father = new FamilyMember("Nikolay", Status.FATHER);
        FamilyMember mother = new FamilyMember("Oxana", Status.MOTHER);
        FamilyMember daughter = new FamilyMember("Olga", Status.CHILD);
        FamilyMember son = new FamilyMember("Andrey", Status.CHILD);
        FamilyMember uncle = new FamilyMember("Boris", null);  // это не член семьи
        System.out.printf("Семья: отец %s, мать %s, дочь %s, сын %s\n", 
                                                    father.getName(), mother.getName(), 
                                                    daughter.getName(), son.getName());

        // семья покупает собаку
        Pet dog = new Pet("Leo");
        System.out.println("Семья купила собаку и назвала ее " + 
                            FamilyMember.takeDog(dog));
        
        // собака просит есть
        dog.communicate(Need.HUNGRY);
        System.out.println("В доме раздается лай " + FamilyMember.alarm);

        // первый реагирует отец и ведет собаку на прогулку (т.к. взял на себе ответственность по выгулу)
        father.reactFamily();
        System.out.println("Но пес и не думает гулять " + FamilyMember.alarm);

        // лай услышала дочь и кормит собаку как ей поручено согласно зоне ответственности
        daughter.reactFamily();
        System.out.println("Собака накормлена и лай прекращается " + FamilyMember.alarm);

        // через время семья взяла кота
        Pet cat = new Pet("Tom");
        System.out.println("Семья взяла кота и назвала его " + 
                            FamilyMember.takeCat(cat));

        // кот хочет гулять
        cat.communicate(Need.WALK);
        System.out.println("В доме раздается мяу " + FamilyMember.alarm);
        // бугут сын (поручено накормить) и мама (приласкать)
        son.reactFamily();
        mother.reactFamily();
        System.out.println(FamilyMember.alarm + " Кот продолжает песню и хочет гулять");
        // об этом догадался теперь отец, который не торопился в этот раз наперед
        father.reactFamily();
        System.out.println(FamilyMember.alarm + " Кот успокоился");

        // вдруг в доме раздается лай собаки и мяуканье сразу
        // собака просит еды, а кот - ласки
        dog.communicate(Need.HUNGRY);
        cat.communicate(Need.FONDLE);
        System.out.printf("В доме раздается мяу и гав одновременно %b. В это время гостит дядя.\n", FamilyMember.alarm);
        // в это время у нашей семьи гостит дядя, он первый реагирует на звуки питомцев
        uncle.reactFamily();
        System.out.printf("Питомцы не слушаются, и звуки продолжаются %s\n", FamilyMember.alarm);
        // дочь уже научилась распознавать звуки и кормит собаку
        daughter.reactFamily();
        System.out.println("Собака накормлена и притихла. Нужд у нее пока нет " + dog.getNeeds());
        System.out.println("Кот же продолжает мяукать " + FamilyMember.alarm + ", он хочет " + cat.getNeeds());
        // за дело взялась мама, и кот притих
        mother.reactFamily();
        System.out.printf("Мать приласкала кота, и звуки умолкли %b. Дядя %s успокоился тоже.\n", FamilyMember.alarm, uncle.getName());





        
        

    }
    
}
