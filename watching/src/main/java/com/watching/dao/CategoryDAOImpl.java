package com.watching.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.watching.dto.ProductDTO;



@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static String namespace = "com.finalPj.testpj.Category";

	@Override
	public List<ProductDTO> dms_dramalist() throws Exception {

		return sqlSession.selectList(namespace + ".dms_dramalist");
	}

	@Override
	public List<ProductDTO> abr_dramalist() throws Exception {
	
		return sqlSession.selectList(namespace + ".abr_dramalist");
	}

	@Override
	public List<ProductDTO> dms_filmlist() throws Exception {
	
		return sqlSession.selectList(namespace + ".dms_filmlist");
	}

	@Override
	public List<ProductDTO> abr_filmlist() throws Exception {

		return sqlSession.selectList(namespace + ".abr_filmlist");
	}

	@Override
	public List<ProductDTO> listsearch(String keyword) throws Exception {
		
		
		return sqlSession.selectList(namespace + ".listsearch", keyword);
	}

}
