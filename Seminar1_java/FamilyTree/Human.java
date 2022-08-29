package Seminar1_java.FamilyTree;
import java.util.HashSet;
import java.util.Set;

public class Human {
    private String name;
    private Human spouse;
    private Human mother;
    private Human father;
    private Set<Human> children = new HashSet<>();

    /**
     * Человек - текущей узел дерева с указанием только имени. 
     * Дальнейшее родство можно добавить отдельно
     * @param name
     */
    public Human(String name) {
        this.name = name;
    }
    /**
     * Человек - узел дерева, имеет имя и указатели на родителей
     * @param name имя 
     * @param father родитель отец
     * @param mother родитель мать
     */
    public Human(String name, Human father, Human mother) {
        this(name);
        addParents(father, mother);
    }

    /**
     * Конструктор с именем человека, его родителями и супругом/супругой
     * @param name
     * @param father
     * @param mother
     * @param spouse
     */
    public Human(String name, Human father, Human mother, Human spouse) {
        this(name, father, mother);
        setSpouse(spouse);
    }

    /**
     * Имя человека текущего узла дерева
     * @return String - name текущего человека
     */
    public String getName() {
        return name;
    }

    /**
     * Получить маму человека текущего узла дерева
     * @return Human - mother данного человека или null, если мать не указана
     */
    public Human getMother() {
        try {
            return mother;
        } catch (NullPointerException npe) {
            return null;
        }
    }

    /**
     * Получить папу человека текущего узла дерева
     * @return Human - father данного человека или null, если отец не указан
     */
    public Human getFather() {
        try {
            return father;
        } catch (NullPointerException npe) {
            return null;
        }
    }

    /**
     * Получить супругу/супруга
     * @return
     */
    public Human getSpouse() {
        return spouse;
    }

    /**
     * Получить детей данного человека
     * @return
     */
    public Set<Human> getChildren() {
        return children;
    }

    // public void setName(String name) {
    //     if (name != null)
    //         this.name = name;
    //     else throw new NullPointerException();
    // }

    // public void setFather(Human father) {
    //     this.father = father;
    //     father.children.add(this);
    // }

    // public void setMother(Human mother) {
    //     this.mother = mother;
    //     mother.children = father.children;
    //     mother.spouse = father;
    //     father.spouse = mother;
    // }

    /**
     * Добавление связи супруг/супруга (Not Null)
     * @param spouse
     */
    public void setSpouse(Human spouse) {
            this.spouse = spouse;
            spouse.spouse = this;
            spouse.children = children;
            System.out.printf("Spouse %s was appointed\n", spouse.getName());
    }

    /**
     * Добавление ребенка в список детей данного человека
     * @param child
     */
    public void addChild(Human child) {
        children.add(child);
        child.father = this;    // здесь еще надо проверить, кто добавляет ребенка (отдельно)
        child.mother = spouse;
        System.out.printf("Child %s was added\n", child.getName());
    }

    /**
     * Добавление родителей (оба Not Null)
     * @param father
     * @param mother
     */
    public void addParents(Human father, Human mother) {
        // if (father == null || mother == null) throw new NullPointerException();
        // if (this.father.getName() == null && this.mother.getName() == null) {
            this.father = father;
            father.children.add(this);
            this.mother = mother;
            mother.children = father.children;
            mother.spouse = father;
            father.spouse = mother;
            System.out.printf("Mother %s and Father %s were created\n", mother.getName(), father.getName());

            
        // }
    }

    public void removeMother() {
        System.out.printf("Mother %s was removed\n", mother.getName());
        mother = null;
    }

    @Override
    public boolean equals(Object obj) { // сравнение на равенство Human осуществляется только по имени - в Set одинаковых имен не будет
        return name.equals( ((Human) obj).getName() );
    }
    
}