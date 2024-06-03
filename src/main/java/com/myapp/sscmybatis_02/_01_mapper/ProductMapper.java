package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.CategoryVO;
import com.myapp.sscmybatis_02._03_vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
  List<ProductVO> getProductList(int productNO);
  List<ProductVO> searchProducts(String keyword);
  List<ProductVO> searchProductsByCategory(String keyword,String category);
  List<CategoryVO> getCategory1List();


  ProductVO getProductById(int productNo);

  void insertProduct(ProductVO productVO);

  void updateProduct(ProductVO productVO);
}
