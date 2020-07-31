package com.cda.init;

import javax.annotation.PostConstruct;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BddDataTestBean {
    @Autowired
    private ILivreDao livreDao;

    @PostConstruct
    public void initialisation() throws Exception {
        if (livreDao.count() < 10) {
            for (int i = 0; i < 10; i++) {
                Livre livre = Livre.builder().titreLivre("test"+i).quantiteStock(i).nombrePage(i).synopsis("synopsis"+i).nomImage("img"+i).prixLivre(i).build();
                livreDao.save(livre);
            }
        }
    }
}