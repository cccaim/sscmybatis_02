package com.myapp.sscmybatis_02._04_service;


import com.myapp.sscmybatis_02._01_mapper.ProductMapper;
import com.myapp.sscmybatis_02._02_dto.CategoryDTO;
import com.myapp.sscmybatis_02._02_dto.ProductDTO;
import com.myapp.sscmybatis_02._03_vo.CategoryVO;
import com.myapp.sscmybatis_02._03_vo.ProductVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class ProductService {
  private final ProductMapper productMapper;

  //메인화면 모든 리스트 나열
  public List<ProductDTO> getAllProduct(int productNo) {
    List<ProductVO> voList = productMapper.getProductList(productNo);
//    for (ProductVO vo : voList) {
//      System.out.println(vo);
//    }
    List<ProductDTO> dtoList = new ArrayList<>();
    for (ProductVO vo : voList) {
      ProductDTO dto = convertToDTO(vo);
      dtoList.add(dto);
    }
    return dtoList;
  }

  // ID로 제품 정보 가져오기
  public ProductDTO getProductById(int productNo) {
    ProductVO productVO = productMapper.getProductById(productNo);
    return convertToDTO(productVO);
  }

  public List<ProductDTO> searchProducts(String keyword) {
    List<ProductVO> voList = productMapper.searchProducts(keyword);
    List<ProductDTO> dtoList = new ArrayList<>();
    for (ProductVO vo : voList) {
      ProductDTO dto = convertToDTO(vo);
      dtoList.add(dto);
    }
    return dtoList;
  }

  public List<ProductDTO> searchProductsByCategory(String keyword, String category) {
    List<ProductVO> voList = productMapper.searchProductsByCategory(keyword, category);
    List<ProductDTO> dtoList = new ArrayList<>();
    for (ProductVO vo : voList) {
      ProductDTO dto = convertToDTO(vo);
      dtoList.add(dto);
    }
    return dtoList;
  }

  public List<CategoryDTO> getCategory1List(){
    List<CategoryVO> voList = productMapper.getCategory1List();
    List<CategoryDTO> dtoList = new ArrayList<>();
    for (CategoryVO vo : voList) {
      CategoryDTO dto = new CategoryDTO();
      dto.setName(vo.getName());
      dto.setNameKo(vo.getNameKo());
      dtoList.add(dto);
    }
    return dtoList;
  }
  public void updateProduct(ProductDTO productDTO) {
    // ProductDTO를 ProductVO로 변환하여 업데이트
    ProductVO productVO = convertToVO(productDTO);
    productMapper.updateProduct(productVO);
  }
  private ProductVO convertToVO(ProductDTO dto) {
    ProductVO vo = new ProductVO();
    vo.setPhotoNo(dto.getPhotoNo());
    vo.setPhotoName(dto.getPhotoName());
    vo.setProductNo(dto.getProductNo());
    vo.setProductName(dto.getProductName());
    vo.setPrice(dto.getPrice());
    vo.setCategory2No(dto.getCategory2No());
    vo.setCategory2Name(dto.getCategory2Name());
    vo.setCategory1No(dto.getCategory1No());
    vo.setCategory2NameKo(dto.getCategory2Name_ko());
    vo.setCategory1Name(dto.getCategory1Name());
    vo.setCategory1NameKo(dto.getCategory1Name_ko());
//    vo.setColorNo(dto.getColorNo());
//    vo.setColorName(dto.getColorName());
    return vo;
  }

  // VO를 DTO로 변환하는 메소드
  private ProductDTO convertToDTO(ProductVO vo) {
    ProductDTO dto = new ProductDTO();
    dto.setPhotoNo(vo.getPhotoNo());
    dto.setPhotoName(vo.getPhotoName());
    dto.setProductNo(vo.getProductNo());
    dto.setProductName(vo.getProductName());
    dto.setPrice(vo.getPrice());
    dto.setCategory2No(vo.getCategory2No());
    dto.setCategory2Name(vo.getCategory2Name());
    dto.setCategory1No(vo.getCategory1No());
    dto.setCategory2Name_ko(vo.getCategory2NameKo());
    dto.setCategory1Name(vo.getCategory1Name());
    dto.setCategory1Name_ko(vo.getCategory1NameKo());
    return dto;
  }
}


