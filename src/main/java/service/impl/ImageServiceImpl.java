package service.impl;

import model.Image;
import model.PoorGrammar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;
import repository.ImageRepository;
import repository.PoorGrammarRepository;
import service.ImageService;

import java.util.List;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private PoorGrammarRepository poorGrammarRepository;

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public Page<Image> findAllByStatusEquals(int status, Pageable pageable) {
        return imageRepository.findAllByStatusEquals(1, pageable);
    }

    @Override
    public Image findById(Integer id) {
        return imageRepository.findOne(id);
    }

    @Override
    public Image save(Image image) {
        List<PoorGrammar> grammarList = poorGrammarRepository.findAll();
        String feedback = image.getFeedback();
        for (PoorGrammar pg : grammarList) {
            if (feedback.contains(pg.getWord())) {
                image.setStatus(0);
            } else {
                image.setStatus(1);
            }
        }
        return imageRepository.save(image);
    }

    @Override
    public void remove(Integer id) {
        imageRepository.delete(id);
    }
}
