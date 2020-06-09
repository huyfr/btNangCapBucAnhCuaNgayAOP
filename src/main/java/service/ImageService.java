package service;

import model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {
    Page<Image> findAll(Pageable pageable);

    Page<Image> findAllByStatusEquals(int status, Pageable pageable);

    Image findById(Integer id);

    Image save(Image image);

    void remove(Integer id);
}
