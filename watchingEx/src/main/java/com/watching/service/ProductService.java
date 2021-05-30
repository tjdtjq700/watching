package com.watching.service;

import java.util.List;

import com.watching.dto.ProductDTO;
import com.watching.vo.ProductImgVO;

public interface ProductService {
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
		//pId ��������
		public int getPId(String pName) throws Exception;
		
		//VO����
		//�̹��� ���ε�
		public void imgUpload(ProductImgVO vo) throws Exception;
		//������ ���ε�
		public void vodUpload(ProductImgVO vo) throws Exception;
		//view
		public ProductImgVO viewImg(int pId) throws Exception;
		//����
		public void modifyImg(ProductImgVO vo) throws Exception;
		//����
		public void deleteImg(String pId) throws Exception;
		
		
		//����¡ó��
		//public int cntList(HashMap<String, String> searchMap) throws Exception;


}
