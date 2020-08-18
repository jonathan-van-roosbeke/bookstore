package com.cda.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cda.dao.ILivreDao;
import com.cda.dto.LivreDto;
import com.cda.entity.Livre;

@Service
public class LivreServiceImpl implements ILivreService {

	@Autowired
	ILivreDao livreDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<LivreDto> findAll() {
		List<LivreDto> livresDto = new ArrayList<>();
		List<Livre> livres = livreDao.findAll();
		for(Livre l : livres) {
			livresDto.add(this.modelMapper.map(l, LivreDto.class));
		}
		return livresDto;
	}

	@Override
	public Livre findById(Integer id) {
		return livreDao.findById(id).get();
	}

	@Override
	public Livre save(Livre livre) {
		return livreDao.save(livre);
	}

	@Override
	public void deleteById(Integer id) {
		livreDao.deleteById(id);
	}

	@Override
	public Page<Livre> getPage(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		return livreDao.findAll(pageable);
	}

}
