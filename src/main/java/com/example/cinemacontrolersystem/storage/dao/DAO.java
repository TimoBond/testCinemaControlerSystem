package com.example.cinemacontrolersystem.storage.dao;

import com.example.cinemacontrolersystem.model.Entity;

public interface DAO <E extends Entity<K>, K>{

    E create(E e);
    E delete(E e);
    E update(E e);
    E find(K k);


}