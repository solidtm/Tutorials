package tutorials;

public class Tutorial6 {
    public static void main(String[] args) {

        Person p = new Person();
        WhitePerson richard = new WhitePerson();
        WhitePerson john = new WhitePerson();
        BlackPerson b = new BlackPerson();
        System.out.println(p.skinColor());
        System.out.println(richard.skinColor());
        System.out.println(john.skinColor());
        System.out.println(b.talk("african"));
        System.out.println(b.talk("african", "cholocate"));
    }

    public int getNumber() {
        return 0;
    }

    private String getString() {
        return "";
    }

    protected static boolean getBoolean() {
        return true;
    }

    static double doubleMethod(int x, double y) {
        return 0.0;
    }



    /*
     * 1. Methods/Functions, method calling, access modifiers, method scope, overloading and overriding methods
     * 2. Object-Oriented programming, Classes and Objects and Constructors
     * 3. Pillars of OOP - Inheritance, Polymorphism, Encapsulation,  and Abstraction (Interfaces and Abstract classes)
     * 4.
     *
     *
     * Access modifiers: These are keywords that defines the level of access to a method, class or any construct
     * public - can be accessed form any package in the app
     * private - can only be accessed within the same class
     * protected - can only be accessed anywhere within the same package
     * static - can be accessed throughout the lifetime of the program and does not need to be accessed via ab object or reference.
     *
     * A method/function is a piece of code that does or performs a specific task
     * Define a method:
     * <access modifier(optional)> <return data type> <name of method> (<method parameters separated by commas>){
     *     //method functionality <do something here>
     *
     *    return return type
     * }
     *
     * Object-Oriented programming - modelling real life objects in computer programs
     * Class - blueprint or model of a real life item. `eg Person, Vehicle, School, Library, `
     * Object - is an instance/reference of a class
     * Inheritance - is a class inheriting properties and methods from another class, we use extends keyword to inherit from a parent class or implements keyword to inherit from an interface
     * Polymorphism - is the ability of a method to take on many forms => multiple methods withe same name can have various/different functions they perform
     * Abstraction - Data hiding is the hiding of implementation details of a particular class and exposing only important details. we use interfaces and abstract classes
     * Encapsulation: this is the merging of variables and methods into a single unit => access modifiers
     *
     * class Person{
     *   String name;
     *   int ears; boolean isBaby;
     *
     *   void eat(){
     *
     *   }
     *
     *   void walk(){
     *
     *   }
     *
     *   String skinColor(){
     *     return skinColor;
     *   }
     * }
     *
     * class WhitePerson inherits Person{
     *
     *
     * }
     *
     * class Dog{}
     *
     * Person richard = new Person();
     * Person taremi = new Person();
     * Dog husky = new Dog();
     * Dog germanShepherd = new Dog();
     *
     *
     *
     * */
}


class Person {
    String name;
    int ears;
    boolean isBaby;

    void eat() {

    }

    void walk() {

    }

    String skinColor() {
        return "skinColor";
    }
}

class WhitePerson extends Person{
    @Override
    String skinColor() {
        return "white";
    }
}

class BlackPerson extends Person{
    @Override
    String skinColor() {
        return "black";
    }

    public String talk(String origin){
        return "A black " + origin + " is talking";
    }

    public String talk(String origin, String skinType){
        return "A black " + origin +  skinType + " with skin color is talking";
    }
}
