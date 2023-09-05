package com.tools.jurumarbles.service;
import com.tools.jurumarbles.model.MapEntity;
import com.tools.jurumarbles.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    @Autowired
    private MapRepository repository;

    public MapEntity createMap(MapEntity map) {
        return repository.save(map);
    }
    public Iterable<MapEntity> getAllMaps() {
        return repository.findAll();
    }
    public MapEntity getMapById(int id) {
        return repository.findById(id).orElse(null);
    }

    public MapEntity updateMap(int id, MapEntity map) {
        if (repository.existsById(id)) {
            map.setId(id);
            return repository.save(map);
        }
        return null;
    }
    public void deleteMap(int id) {
        repository.deleteById(id);
    }
}