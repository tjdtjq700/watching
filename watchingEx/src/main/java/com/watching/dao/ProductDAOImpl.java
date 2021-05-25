package com.watching.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watching.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	private static String namespace="com.watching.productMapper";
	
	
	@Override
	public List<ProductDTO> list() throws Exception {
		
		return sqlSession.selectList(namespace+".list");
	}

	@Override
	public ProductDTO view(int pId) throws Exception {
		
		return sqlSession.selectOne(namespace+".view", pId);
	}

	@Override
	public void upload(ProductDTO dto) throws Exception {
		sqlSession.insert(namespace+".upload", dto);

	}

	@Override
	public void modify(ProductDTO dto) throws Exception {
		sqlSession.update(namespace+".modify", dto);

	}

	@Override
	public void delete(String pId) throws Exception {
		sqlSession.delete(namespace+".delete", pId);

	}

	@Override
	public void uphit(int pId) throws Exception {
		sqlSession.update(namespace+".uphit",pId);

	}

}
