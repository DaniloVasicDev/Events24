package com.dragonjic.cubes.events24.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dragonjic.cubes.events24.data.model.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insert(Event event);

    @Delete
    void delete(Event event);

    @Query("SELECT * FROM event")
    List<Event> getAll();

    @Query("SELECT * FROM Event WHERE type like:type")
    List<Event> getAllByType(String type);

    @Query("SELECT * FROM EVENT WHERE id LIKE:id")
    Event getEvent(String id);
}
