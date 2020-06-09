package repository;

import model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Integer> {
    Page<Image> findAllByStatusEquals(int status, Pageable pageable);
}