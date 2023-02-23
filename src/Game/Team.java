package Game;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team<T extends BaseHero> implements Iterable<T> {

    List<T> dreamTeam = new ArrayList<T>();

    public void add(T t) {
        dreamTeam.add(t);
    }


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return dreamTeam.iterator();
    }

    public int getTeamHealth() {
        int teamHealth = 0;
        for (T hero : dreamTeam) {

            teamHealth += hero.getHealth();
        }

        return teamHealth;
    }

    public T minArmor(){
        T element = null;
                for (T hero : dreamTeam) {
            if (hero.isShielded()) {
                if (element == null) {
                    element = hero;
                }
                BaseHero shielded = (BaseHero) hero;
                if ( element.shield.shieldHealth() > shielded.shield.shieldHealth()) {
                    element = hero;
                }
            }

        }

        return element;
    }

    public String minArmorToString(T t){
        if (t == null){
            return "there is no one with a shield";
        }
        return t + " is the weakest shield";

    }

    public int getMaxRange() {

        int maxRange = 0;
        for (T hero : dreamTeam) {

            if (hero instanceof Archer) {

                Archer archer = (Archer) hero;

                if (maxRange < archer.range()) {

                    maxRange = archer.range();
                }
            }

        }

        return maxRange;
    }

    public int getSumDamage() {

        int sumDamage = 0;

        for (T hero : dreamTeam) {

            sumDamage += hero.getWeapon().damage();

        }

        return sumDamage;
    }



}
