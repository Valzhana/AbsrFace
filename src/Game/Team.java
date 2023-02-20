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
