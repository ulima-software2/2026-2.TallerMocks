package pe.edu.ulima.is2.repository;

import pe.edu.ulima.is2.model.VideoGame;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryVideoGameRepository implements VideoGameRepository {
    private final Map<Long, VideoGame> games = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public VideoGame save(VideoGame videoGame) {
        if (videoGame.getId() == null) {
            videoGame.setId(idGenerator.getAndIncrement());
        }
        games.put(videoGame.getId(), videoGame);
        return videoGame;
    }

    @Override
    public Optional<VideoGame> findById(Long id) {
        return Optional.ofNullable(games.get(id));
    }

    @Override
    public List<VideoGame> findAll() {
        return new ArrayList<>(games.values());
    }

    @Override
    public VideoGame update(VideoGame videoGame) {
        if (games.containsKey(videoGame.getId())) {
            games.put(videoGame.getId(), videoGame);
            return videoGame;
        }
        throw new RuntimeException("VideoGame not found with ID: " + videoGame.getId());
    }

    @Override
    public void deleteById(Long id) {
        games.remove(id);
    }
}
