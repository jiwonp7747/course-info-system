package kr.ac.hansung.course.controller;

import kr.ac.hansung.course.model.Offer;
import kr.ac.hansung.course.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfferController {
    // Controller -> Service -> Dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers); // key value

        // view로 리턴
        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "createoffer";
    }
}
