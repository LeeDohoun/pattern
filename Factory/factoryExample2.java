package pattern.Factory;
interface Character {
    void attack();
}

class Warrior implements Character {
    public void attack() {
        System.out.println("전사가 검으로 공격합니다!");
    }
}

class Mage implements Character {
    public void attack() {
        System.out.println("마법사가 화염구를 발사합니다!");
    }
}

class Archer implements Character {
    public void attack() {
        System.out.println("궁수가 화살을 쏩니다!");
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter();
}

class WarriorFactory extends CharacterFactory {
    public Character createCharacter() {
        return new Warrior();
    }
}

class MageFactory extends CharacterFactory {
    public Character createCharacter() {
        return new Mage();
    }
}

class ArcherFactory extends CharacterFactory {
    public Character createCharacter() {
        return new Archer();
    }
}

public class factoryExample2 {
    public static void main(String[] args) {
        CharacterFactory factory1 = new WarriorFactory();
        Character c1 = factory1.createCharacter();
        c1.attack();

        CharacterFactory factory2 = new MageFactory();
        Character c2 = factory2.createCharacter();
        c2.attack();

        CharacterFactory factory3 = new ArcherFactory();
        Character c3 = factory3.createCharacter();
        c3.attack();
        
    }
}
