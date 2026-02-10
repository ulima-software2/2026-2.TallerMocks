package pe.edu.ulima.is2.repository;

import pe.edu.ulima.is2.model.VideoGame;
import java.util.List;
import java.util.Optional;

public interface VideoGameRepository {
    VideoGame save(VideoGame videoGame);

    Optional<VideoGame> findById(Long id);

    List<VideoGame> findAll();

    VideoGame update(VideoGame videoGame);

    void deleteById(Long id);
}
