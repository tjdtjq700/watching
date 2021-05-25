package com.watching.dao;

import java.util.HashMap;
import java.util.List;

import com.watching.dto.ProductDTO;

public interface ProductDAO {
	//����Ʈ
	public List<ProductDTO> list() throws Exception;
	//��ȸ
	public ProductDTO view(int pId) throws Exception; 
	//���ε� 
	public void upload(ProductDTO dto) throws Exception;
	//����
	public void modify(ProductDTO dto) throws Exception;
	//����
	public void delete(String pId) throws Exception;
	//��ȸ��
	public void uphit(int pId) throws Exception;
	
	//����¡ó��
	//public int cntList(HashMap<String, String> searchMap) throws Exception;

}
