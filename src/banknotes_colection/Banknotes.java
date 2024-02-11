package banknotes_colection;

import banknote.Banknote;

import java.util.*;

import banknotes_colection.ISort;

public class Banknotes implements ISort, Iterable<Banknote> {
    private List<Banknote> banknotes;

    public Banknotes() {
        this.banknotes = new ArrayList<>();
    }

    public void add(Banknote banknote) {
        this.banknotes.add(banknote);
    }
    public boolean contains(Banknote banknote) {
        return this.banknotes.contains(banknote);
    }

    public void remove(Banknote banknote) {
        this.banknotes.remove(banknote);
    }

    public int getAmount() {
        int amount = 0;
        for (Banknote banknote : this.banknotes) {
            amount += banknote.getValue();
        }
        return amount;
    }

    public void countBanknotes() {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Banknote banknote : banknotes) {
            int value = banknote.getValue();
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        System.out.println("Banknote counts:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void sortASC() {
        Collections.sort(banknotes);
    }

    @Override
    public void sortDESC() {
        sortASC();
        Collections.reverse(banknotes);
    }

    public Iterator<Banknote> iterator() {
        return banknotes.iterator();
    }
}
