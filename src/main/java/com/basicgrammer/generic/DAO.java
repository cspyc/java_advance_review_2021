package com.basicgrammer.generic;

import java.util.*;

/**
 * @author Pi
 * @date 2021-04-22 15:34
 */
public class DAO<T> {

    private Map<String, T> data = new HashMap<>();

    public T get(String key) {
        return data.get(key);
    }

    public void save(String id, T entity) {
        if (id == null || entity == null) {
            throw new NullPointerException();
        }
        data.put(id, entity);
    }

    public void update(String s, T entity) {
        if (s == null || entity == null) {
            throw new NullPointerException();
        }
        data.put(s, entity);
    }

    public List<T> list() {
        Collection<T> mapValues = data.values();
        return new ArrayList<>(mapValues);
    }

    public void delete(String id) {
        data.remove(id);
    }
}
