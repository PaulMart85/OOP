package Seminar1_java.FamilyTree;
/**
 * Родословное дерево. 
 * Предположение, что у каждого человека есть только один отец и одна мать, и один супруг/супруга,
 * может быть любое количество братьев и сестер, а также и детей.
 * Также допущение, что все имена во всех родственных связях разные
 */
public class GenealogicalTree {

    public static void main(String[] args) {
        
        // Это я - все дальнейшие родственники определяются относительно меня!!!
        Human itIsMe = new Human("Paul", new Human("Nikolay"), new Human("Oxana"), new Human("Anastasia"));

        // Добавим дедушку и бабушку по отцовской линии (т.е. родителей отца)
        itIsMe.getFather().addParents(new Human("Eduard"), new Human("Barbara"));

        // Добавим детей
        itIsMe.addChild(new Human("Theodor"));

        // Добавим брата и сестру
        Human myBrother = new Human("Andrey", itIsMe.getFather(), itIsMe.getMother());
        Human mySister = new Human("Olga", itIsMe.getFather(), itIsMe.getMother(), new Human("Viktor"));

        // Добавим детей моей сестры Olga
        mySister.addChild(new Human("Ilaija"));
        mySister.addChild(new Human("Emilia"));

        // Добавим супругу брата
        myBrother.setSpouse(new Human("Kristina"));

        // Добавим моего дядю - брата отца
        itIsMe.getFather().getFather().addChild(new Human("Lev"));

        // Добавим родителей мужа сестры (т.е. свекра и свекровь сестры Olga)
        mySister.getSpouse().addParents(new Human("Vladimir"), new Human("Rosa"));

        // Удалим (по каким-то причинам) свекровь сестры Olga
        mySister.getSpouse().removeMother(); 
        
        // Получим имя бабушки по отцовской линии
        System.out.printf("My father's mother's name is %s \n", itIsMe.getFather().getMother().getName());

        // Получим количество детей у отца Nikolay и матери Oxana
        System.out.printf("Count of my brothers and sisters is %s \n", itIsMe.getFather().getChildren().size());

        // Получим имя супруги моего брата Andrey
        for (Human elem : itIsMe.getFather().getChildren())
            if (elem.getName() == "Andrey") {
                System.out.printf("My brother's wife names %s \n", elem.getSpouse().getName());
                break;
            }      
    }
    
}
