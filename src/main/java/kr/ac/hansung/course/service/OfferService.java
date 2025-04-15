package kr.ac.hansung.course.service;

import kr.ac.hansung.course.dao.OfferDao;
import kr.ac.hansung.course.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferDao offerDao;

    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }
}
