package OOPS_Inheritance.Inheritance.Problem1;

class Fruit {

    String name;
    String taste;
    String size;

    Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    void eat() {
        System.out.println("Fruit Name : " + name);
        System.out.println("Taste : " + taste);
    }
}

class Apple extends Fruit {

    Apple() {
        super("Apple", "Sweet", "Medium");
    }

    @Override
    void eat() {
        System.out.println("Fruit Name : " + name);
        System.out.println("Taste : Sweet");
    }
}

class Orange extends Fruit {

    Orange() {
        super("Orange", "Sour", "Medium");
    }

    @Override
    void eat() {
        System.out.println("Fruit Name : " + name);
        System.out.println("Taste : Sour");
    }
}

public class TestFruit {

    public static void main(String[] args) {
    	//TODO Auto-generated method stub

        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.eat();

        System.out.println();

        orange.eat();
    }
}