package Game;


import java.util.Random;

//Реализовать абстрактный класс Warrior, с полями name, weapon, healthPoint
//Создать интерфейс Weapon с методом damage(), который будет показывать наносимый урон
//На основе класса Warrior создать различные типы воинов, например, лучник, меченосец, ополченец
// и т.п. У лучника добавить поле расстояние поражения.
//Создать различные виды вооружения, например, меч, лук, лопата.
// Обеспечить, чтобы определенный тип воина мог нести только определенной оружие. Можно на определенное оружие добавить уникальные признаки, например, у лука - дальность стрельбы.
public abstract class BaseHero <W extends Weapon>  {


    private int health;

    private String name;

    protected W weapon;

    protected BaseHero(int health, String name, W weapon) {
        this.health = health;
        this.name = name;
        this.weapon = weapon;
    }

    public int damageFork(){
        Random random = new Random();
        return random.nextInt(weapon.damage());

    }

    public boolean hit(BaseHero recepient){
        int damage = damageFork();

        return ! recepient.reduceHealth(damage);


    }

    public boolean reduceHealth(int damage){
        health -= damage;
        return health>0;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public W getWeapon() {
        return weapon;
    }

    public void setWeapon(W weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "BaseHero{" +
                "health=" + health +
                ", name='" + name + '\'' +
                ", weapon=" + weapon +
                '}';
    }
}
