package assignments.assignment3.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CabinetImpl<E> implements Cabinet<E>{
    private final Map<String, BinImpl<E>> bins;

    public CabinetImpl(){
        bins = new HashMap<>();
    }

    @Override
    public void add(E item, String bin) {
        bins.putIfAbsent(bin, new BinImpl<>());
        bins.get(bin).add(item);
    }

    @Override
    public void add(Bin<E> items, String bin) {
        bins.putIfAbsent(bin, new BinImpl<>());
        while(items.hasStuff()){
            bins.get(bin).add(items.grab());
        }
    }

    @Override
    public E get(String bin) {
        if(!bins.containsKey(bin) || !bins.get(bin).hasStuff()){
            throw new DisorganizationException("Requested bin is empty or does not exist");
        }

        return bins.get(bin).grab();
    }

    @Override
    public int query(String bin) {
        return bins.getOrDefault(bin, new BinImpl<>()).hasStuff() ? bins.get(bin).getSize() : 0;
    }

    @Override
    public Bin<E> getBin(String bin) {
        if (!bins.containsKey(bin)){
            return new BinImpl<>();
        }

        BinImpl<E> retrievedBin = bins.get(bin);
        BinImpl<E> newBin = new BinImpl<>();

        while (retrievedBin.hasStuff()){
            newBin.add(retrievedBin.grab());
        }

        return newBin;
    }

    @Override
    public String[] getBins() {
        Set<String> binLabels = bins.keySet();

        return binLabels.toArray(new String[0]);
    }

    @Override
    public int getCount() {
        int count = 0;

        for(BinImpl<E> bin : bins.values()){
            count += bin.getSize();
        }

        return count;
    }
}
