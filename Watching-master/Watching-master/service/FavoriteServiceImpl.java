package com.watching.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.watching.dao.FavoriteDAO;
import com.watching.dto.FavoriteDTO;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Inject
	private FavoriteDAO fdao;

	// 찜리스트
	@Override
	public List<FavoriteDTO> favlist(String mId) throws Exception {

		return fdao.favlist(mId);
	}

	// 찜추가
	@Override
	public void addfav(FavoriteDTO fdto) throws Exception {

		fdao.addfav(fdto);
	}

	// 찜추가 중복체크
	@Override
	public int favCheck(int pCode) throws Exception {

		return fdao.favCheck(pCode);
	}
	
	// 찜삭제
	@Override
	public void deletefav(int fCode) throws Exception {

		fdao.deletefav(fCode);
	}



}
