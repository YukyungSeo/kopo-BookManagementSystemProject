package kr.ac.kopo.inMemory.da;

import java.util.ArrayList;

public interface MapDA<K, V> {

	public boolean add(K k, V v);

	public V remove(K k);

	public V get(K k);

	public ArrayList<V> getList(String value);
}
