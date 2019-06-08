package com.test.framework.hotel.supportMethods;

import java.util.HashMap;
import java.util.Map;

public class Storage {


    private static volatile Storage instance;
    private Map<String, Object> storageMap = new HashMap<>();

    private Storage() {
    }


    public static Storage getInstance() {
        if (instance == null) {
            synchronized (Storage.class) {
                if (instance == null) {
                    instance = new Storage();
                }
            }
        }
        return instance;
    }

    public synchronized <T> T getStorageValue(String key, Class<T> valueType) {

        try {
            return valueType.cast(storageMap.get(key));
        } catch (ClassCastException e) {
            return null;
        }

    }

    public synchronized <T> void setStorageValue(String key, T value) {
        storageMap.put(key, value);
    }


    public synchronized void clear() {
        storageMap.clear();
    }


}
