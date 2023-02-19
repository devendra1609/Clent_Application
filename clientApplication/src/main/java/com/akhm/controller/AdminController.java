package com.akhm.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.akhm.controller.command.AdminCommand;
import com.akhm.controller.command.CategoryCommand;
import com.akhm.controller.command.ProductCommand;
import com.akhm.controller.command.SubCategoryCommand;
import com.akhm.service.AdminService;
import com.akhm.service.CategoryService;
import com.akhm.service.ProductService;
import com.akhm.service.SubCategoryService;
import com.akhm.service.dto.AdminDTO;
import com.akhm.service.dto.CategoryDTO;
import com.akhm.service.dto.ProductDTO;
import com.akhm.service.dto.SubCategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private ProductService productService;
//	@RequestMapping(name="/adminlogin",method=RequestMethod.GET)
	@GetMapping("/adminlogin")
	public String showAdminLogin() {
		return "adminlogin";
	}
	//@RequestMapping(name="/adminlogin",method = RequestMethod.POST)
	@PostMapping("adminlogin")
	public String submitAdminLogin(HttpServletRequest request,AdminDTO adminDTO) {
		try {
			log.info("in AdminController....adminlogin()... method started ");
			if (adminDTO != null) {
				
				AdminDTO admin = adminService.getAdmin(adminDTO.getEmailId(), adminDTO.getPassword());
				if (admin != null) {
					
					HttpSession session = request.getSession(true);
					session.setAttribute("AUTH_ADMIN", adminDTO);
					log.info("in AdminController....adminlogin()..details are successfully inserted");
					return "redirect:adminhome";
				} else {
					request.setAttribute("ErrorMessege", "Invalid userName or passsword");
				}
			}

		} catch (Exception e) {
			request.setAttribute("ErrorMessege", "some thing wrong plz try again later");

		}
		return "adminlogin";
	}
	
	@GetMapping("/adminhome")
	public String adminHome(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				return "adminhome";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/addcategory")
	public String showAddCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				return "addcategory";
			} 
		}
		return "redirect:adminlogin";
		
	}
	@PostMapping("/addcategory")
	public String submitAddCategory(HttpServletRequest request,CategoryCommand categoryCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				CategoryDTO categoryDTO=new CategoryDTO();
				categoryDTO.setCategoryName(categoryCommand.getCategoryName());
				categoryDTO.setCategoryCode(categoryCommand.getCategoryCode());
				categoryDTO.setCategoryDescription(categoryCommand.getCategoryDescription());
				Integer categoryId=categoryService.insertCategory(categoryDTO);
				if(categoryId!=null && categoryId>0) {
					return "redirect:categories";
				} else {
					return "addcategory";
				}
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/addsubcategory")
	public String showAddSubCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			SubCategoryDTO subCategoryDTO=(SubCategoryDTO) session.getAttribute("AUTH_ADMIN");
			if(subCategoryDTO!=null) {
				return "addsubcategory";
			} 
		}
		return "redirect:adminlogin";
		
	}
	
	@GetMapping("/addproduct")
	public String showAddProduct(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				return "addproduct";
			} 
		}
		return "redirect:adminlogin";
		
	}
	@PostMapping("/addproduct")
	public String submitAddProduct(HttpServletRequest request,ProductCommand productCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				ProductDTO productDTO=new ProductDTO();
				productDTO.setProductName(productCommand.getProductName());
				productDTO.setProductCode(productCommand.getProductCode());
				productDTO.setProductDescription(productCommand.getProductDescription());
				productDTO.setProductImageName(productCommand.getProductImageName());
				productDTO.setCategoryId(productCommand.getCategoryId());
				productDTO.setSubCategoryId(productCommand.getSubCategoryId());
				productDTO.setProductStatus(productCommand.getProductStatus());
				Integer productId=productService.insertProduct(productDTO);
				if(productId!=null && productId>0) {
					return "redirect:products";
				} else {
					return "addproduct";
				}
			} 
		}
		return "redirect:adminlogin";
	}
	
	
	@PostMapping("/addsubcategory")
	public String submitAddSubCategory(HttpServletRequest request,SubCategoryCommand subCategoryCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
				subCategoryDTO.setSubCategoryName(subCategoryCommand.getSubCategoryName());
				subCategoryDTO.setSubCategoryCode(subCategoryCommand.getSubCategoryCode());
				subCategoryDTO.setSubCategoryDescription(subCategoryCommand.getSubCategoryDescription());
				Integer subCategoryId=subCategoryService.insertSubCategory(subCategoryDTO);
				if(subCategoryId!=null && subCategoryId>0) {
					return "redirect:subcategories";
				} else {
					return "addsubcategory";
				}
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/categories")
	public String showCategories(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				List<CategoryDTO> categories=categoryService.getCategories();
				request.setAttribute("categories", categories);
				return "admincategories";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/subcategories")
	public String showSubCategories(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				List<SubCategoryDTO> subCategories=subCategoryService.getSubCategories();
				request.setAttribute("subcategories", subCategories);
				return "adminsubcategories";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@GetMapping("/products")
	public String showProducts(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				List<ProductDTO> products=productService.getProducts();
				request.setAttribute("categories", products);
				return "adminproducts";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/editcategory")
	public String editCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				CategoryDTO categoryDTO=categoryService.getCategory(Integer.valueOf(request.getParameter("categoryId")));
				request.setAttribute("category", categoryDTO);
				return "editcategory";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/editsubcategory")
	public String editSubCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				SubCategoryDTO subCategoryDTO=subCategoryService.getSubCategory(Integer.valueOf(request.getParameter("subCategoryId")));
				request.setAttribute("subcategory", subCategoryDTO);
				return "editsubcategory";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@GetMapping("/editproduct")
	public String editProduct(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				ProductDTO productDTO=productService.getProduct(Integer.valueOf(request.getParameter("productId")));
				request.setAttribute("product", productDTO);
				return "editproduct";
			} 
		}
		return "redirect:adminlogin";
	}
	@PostMapping("/updateCategory")
	public String submitUpdateCategory(HttpServletRequest request,CategoryCommand categoryCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				CategoryDTO categoryDTO=new CategoryDTO();
				categoryDTO.setCategoryId(categoryCommand.getCategoryId());
				categoryDTO.setCategoryName(categoryCommand.getCategoryName());
				categoryDTO.setCategoryCode(categoryCommand.getCategoryCode());
				categoryDTO.setCategoryDescription(categoryCommand.getCategoryDescription());
				categoryService.updateCategory(categoryDTO);
				return "redirect:categories";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@PostMapping("/updatesubcategory")
	public String submitUpdateSubCategory(HttpServletRequest request,SubCategoryCommand subCategoryCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
				subCategoryDTO.setSubCategoryId(subCategoryCommand.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategoryCommand.getSubCategoryName());
				subCategoryDTO.setSubCategoryCode(subCategoryCommand.getSubCategoryCode());
				subCategoryDTO.setSubCategoryDescription(subCategoryCommand.getSubCategoryDescription());
				subCategoryService.updateSubCategory(subCategoryDTO);
				return "redirect:subcategories";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@PostMapping("/updateproduct")
	public String submitUpdateProduct(HttpServletRequest request,ProductCommand productCommand) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				ProductDTO productDTO=new ProductDTO();
				productDTO.setProductId(productCommand.getProductId());
				productDTO.setProductName(productCommand.getProductName());
				productDTO.setProductCode(productCommand.getProductCode());
				productDTO.setProductDescription(productCommand.getProductDescription());
				productService.updateProduct(productDTO);
				return "redirect:products";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/deletecategory")
	public String deleteCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				categoryService.deleteCategory(Integer.valueOf(request.getParameter("categoryId")));
				return "redirect:categories";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@GetMapping("/deletesubcategory")
	public String deleteSubCategory(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				subCategoryService.deleteSubCategory(Integer.valueOf(request.getParameter("subCategoryId")));
				return "redirect:subcategories";
			} 
		}
		return "redirect:adminlogin";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null) {
				productService.deleteProduct(Integer.valueOf(request.getParameter("subCategoryId")));
				return "redirect:products";
			} 
		}
		return "redirect:adminlogin";
	}
	@GetMapping("/categoriesdownloadcsv")
	public void exportToCsv(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/csv");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		String currentDateAndTime=sdf.format(new Date());
		String headerKey="Content-Disposition";
		String headerValue="attachment;fileName=categories_"+currentDateAndTime+".csv";
		response.setHeader(headerKey, headerValue);
		List<CategoryDTO> categories=categoryService.getCategories();
		if(categories!=null) {
			ICsvBeanWriter csvWriter=new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
				String[] csvHeader= {"category id","category name","Category Description","Category Code"};
				String[] namingValue= {"categoryId","categoryName","categoryDescription","categoryCode"};
				csvWriter.writeHeader(csvHeader);
				for(CategoryDTO categoryDTO:categories) {
					csvWriter.write(categoryDTO, namingValue);
				}
				csvWriter.close();
		}
	}
}
