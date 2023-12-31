package proyect.store.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyect.store.DTO.CategoriesNamesDTO;
import proyect.store.control.CategoriesControl;
import proyect.store.model.CategSubCaAux;
import proyect.store.model.CategoriesModel;
import proyect.store.model.SubCategoriesModel;
import proyect.store.repository.CateSubAuxRepo;
import proyect.store.repository.CategoriesRepo;
import proyect.store.repository.NewCategoriesRepo;
import proyect.store.repository.SubCatRepo;
import proyect.store.service.BringAllData;
import proyect.store.service.MyService;
import proyect.store.service.implementations.SubCatIm;
import proyect.store.service.implementations.SubCatImpl;
import proyect.store.service.services.NamesService;
import proyect.store.service.services.SubCatService;

//@RestController
@Controller
public class mainControler {
  @Autowired
  private CategoriesRepo categoriesRepo;

  @Autowired
  private CateSubAuxRepo cateSubAuxRepo;

  @Autowired
  private SubCatRepo subCatRepo;

  @Autowired
  private NamesService namesService;

  @Autowired
  private SubCatService subCatService;

  @Autowired
  private BringAllData bringAllData;

  @Autowired
  private SubCatIm subCat;

  @Autowired
  NewCategoriesRepo newCategoriesRepo;
  
  @Autowired
  CategoriesControl categoriesControl;

  private MyService service = new MyService();

  @GetMapping("/inicio")
  public String main(Model model) {
    model.addAttribute("objeto", service.myop());
    return "main";
  }

  @GetMapping("/test")
  public String test(Model model) {
    model.addAttribute("objeto", service.myop());
    // return "test";
    return null;
  }

  @GetMapping("/test1")
  public String test1(Model model) {
    model.addAttribute("objeto", service.myop());
    return "test1";
  }

  @GetMapping("/a")
  public List<CategoriesModel> verPuerbas() {
    return categoriesRepo.findAll();
  }

  @GetMapping("/b")
  public List<CategoriesModel> verPuerbas1() {
    List<CategoriesModel> res = categoriesRepo.findAll();

    for (CategoriesModel categoriesModel : res) {
      System.out.println(categoriesModel.getNombre_categoria());
    }
    return categoriesRepo.findAll();
  }

  @GetMapping("/c")
  public List<Long> verPuerbasLong() {
    return cateSubAuxRepo.fidByMySelf(4L);
  }

  @GetMapping("/d")
  public List<SubCategoriesModel> verPuerbassub() {
    return subCatRepo.findAll();
  }

  @GetMapping("/e")
  public List<String> verPuerbassubN() {
    List<Long> listaDeIds = Arrays.asList(1L, 2L, 3L);
    return subCatRepo.findNamesByIds(listaDeIds);
  }

  @GetMapping("/f")
  public List<String> lograrelistar() {
    List<Long> listaDeIds = cateSubAuxRepo.fidByMySelf(4L);// regresara 3 y 4

    return subCatRepo.findNamesByIds(listaDeIds);
  }

  @GetMapping("/ff")
  public List<Long> test() {
    return bringAllData.BringAllDataall();
  }

  @GetMapping("/fff")
  public List<List<String>> test1() {
    return bringAllData.trial();
  }

  @ModelAttribute("listCategories")
  public List<CategoriesModel> listCate() {
    return namesService.list();
  }

  @ModelAttribute("listSubCategories")
  public List<String> listingSub() {
    return subCatService.listSubN();
  }

  @ModelAttribute("listingSubcat")
  public List<List<String>> listTree() {
    return bringAllData.trial();
  }

  @ModelAttribute("bringCat")
  public List<String> listSubN1() {
    return subCat.bringCategories();

  }

  @ModelAttribute("bringSubCat")
  public List<List<String>> listSubN2() {
    // return subCat.bringSubCat();
    return null;
  }

  @ModelAttribute("brinBoth")
  public Map<String, List<String>> listSubN3() {
    return subCat.bringBoth();

  }

  @ModelAttribute("c3p0")
  public List<CategoriesModel> categoriesModelsc3p0() throws SQLException{
    newCategoriesRepo.getAllCategories();
    return null;
  }

  @ModelAttribute("3cp01")
  public List<CategoriesModel> catTest() throws SQLException{
    //categoriesControl = new CategoriesControl();
    categoriesControl.list();
    return null;
  }
  // terngo que insertar lo de c en d

}
