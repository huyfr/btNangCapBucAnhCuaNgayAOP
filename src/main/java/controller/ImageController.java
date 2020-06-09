package controller;

import model.Image;
import model.PoorGrammar;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ImageService;
import service.PoorGrammarService;

import java.util.HashMap;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private PoorGrammarService poorGrammarService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex() {
        ModelAndView index = null;
        Image image;
        try {
            index = new ModelAndView("index");
            image = new Image();
            index.addObject("image", image);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return index;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView loadResult(@ModelAttribute("image") Image image, Pageable pageable) {
        ModelAndView result = null;
        Page<Image> images;
        Image newImage;
        try {
            newImage = imageService.save(image);
            if (newImage.getStatus() == 1) {
                images = imageService.findAllByStatusEquals(1, pageable);
                result = new ModelAndView("result");
                result.addObject("images", images);
            } else if (newImage.getStatus() == 0) {
                result = new ModelAndView("error");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
