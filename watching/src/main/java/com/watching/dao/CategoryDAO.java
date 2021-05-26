package com.watching.dao;

import java.util.List;

import com.watching.dto.ProductDTO;



public interface CategoryDAO {
	
	// 국내드라마 리스트
	public List<ProductDTO> dms_dramalist() throws Exception;
		
	// 해외드라마 리스트
	public List<ProductDTO> abr_dramalist() throws Exception;
			
	// 국내영화 리스트
	public List<ProductDTO> dms_filmlist() throws Exception;
			
	// 해외영화 리스트
	public List<ProductDTO> abr_filmlist() throws Exception;
	
	// 검색
	public List<ProductDTO> listsearch(String keyword) throws Exception;
	
}
