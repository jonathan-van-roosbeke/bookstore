import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;

@Service
public class LivreServiceImpl implements ILivreService {

	@Autowired
	ILivreDao livreDao;

	@Override
	public List<Livre> findAll() {
		return livreDao.findAll();
	}
}
