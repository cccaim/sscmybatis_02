package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.CategoryDTO;
import com.myapp.sscmybatis_02._02_dto.ProductDTO;
import com.myapp.sscmybatis_02._04_service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/products")
public class  ProductController {
  private ProductService productService;

  //메인화면_제품 목록 조회
  @GetMapping("/{productNo}")
  public String showProducts(@PathVariable int productNo, Model model) {
    List<ProductDTO> productList = productService.getAllProduct(productNo);
    List<CategoryDTO> category1List = productService.getCategory1List();
    model.addAttribute("category1List", category1List);
    model.addAttribute("productList", productList);
    return "products";
  }

  // 제품 수정 폼을 보여주는 메소드
  @GetMapping("/edit/{productNo}")
  public String editProduct(@PathVariable int productNo, Model model) {
    ProductDTO product = productService.getProductById(productNo);
    String imageUrl = "/images/" + product.getPhotoName() + ".jpg";
    List<ProductDTO> productList = productService.getAllProduct(productNo);
    model.addAttribute("product", product);
    model.addAttribute("imageUrl", imageUrl);
    model.addAttribute("category2List", productList);
    return "editProduct";
  }

  @PostMapping("/update")
  public String updateProduct(@RequestParam int productNo,
                              @RequestParam String productName,
                              @RequestParam int price,
                              @RequestParam String category1Name,
                              @RequestParam String category2Name,
                              @RequestParam int category2No,
                              @RequestParam(value = "photo", required = false) MultipartFile photo) {
    // 입력 받은 값을 이용하여 ProductDTO 객체 생성
    ProductDTO productDTO = new ProductDTO();
    productDTO.setProductNo(productNo);
    productDTO.setProductName(productName);
    productDTO.setPrice(price);
    productDTO.setCategory1Name(category1Name);
    productDTO.setCategory2Name(category2Name);
    productDTO.setCategory2No(category2No);


    // 파일 업로드 처리를 추가
    if (photo != null && !photo.isEmpty()) {
      String photoName = photo.getOriginalFilename();
      // 파일 저장 로직 추가 (예: 파일을 서버에 저장)
      // 여기서는 단순히 파일 이름을 DTO에 설정
      productDTO.setPhotoName(photoName);
    }

    // ProductService를 사용하여 데이터베이스의 내용을 수정
    productService.updateProduct(productDTO);

    // 수정 완료 후 리다이렉트할 경로 리턴
    return "redirect:/products/" + productNo;
  }

  @GetMapping("/search")
  public String searchProducts(@RequestParam("keyword") String keyword,
                               @RequestParam(value = "category", required = false) String category,
                               Model model) {
    System.out.println("----------------" + keyword +"//"+category);
    List<CategoryDTO> category1List = productService.getCategory1List();
    List<ProductDTO> productList;
    if (category != null && !category.isEmpty()) {
      productList = productService.searchProductsByCategory(keyword, category);
    } else {
      productList = productService.searchProducts(keyword);
    }
    model.addAttribute("category1List", category1List);
    model.addAttribute("productList", productList);
    return "products";
  }
}
