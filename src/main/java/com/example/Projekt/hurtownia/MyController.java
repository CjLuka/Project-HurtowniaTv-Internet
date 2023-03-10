package com.example.Projekt.hurtownia;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Projekt.hurtownia.Repo.PersonRepo;
import com.example.Projekt.hurtownia.Repo.PlatnosciRepo;
import com.example.Projekt.hurtownia.Repo.ProductRepo;
import com.example.Projekt.hurtownia.Repo.ZamowieniaRepo;
//import com.example.Projekt.hurtownia.Tabele.Package;
import com.example.Projekt.hurtownia.Tabele.Person;
import com.example.Projekt.hurtownia.Tabele.Platnosci;
import com.example.Projekt.hurtownia.Tabele.Product;
import com.example.Projekt.hurtownia.Tabele.Zamowienia;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	@Autowired
  private PersonRepo personRepo;
  @Autowired
  private PlatnosciRepo platnosciRepo;
	@Autowired
  private ProductRepo productRepo;
  @Autowired
  private ZamowieniaRepo zamowieniaRepo;
  @Autowired
  private Koszyk koszyk;


  @RequestMapping(value = "/wyswietlprodukty", method = RequestMethod.GET)
  public String wyswietlProdukty(Model model) {
    model.addAttribute("Product", new Product());
    //model.addAttribute("wyswietlprodukty",productRepo.findAll());
    
    
    model.addAttribute("wyswietlprodukty",productRepo.findByIdNotIn(productRepo.FindBySqlQuery1()));
    System.out.println("Test" + productRepo.FindBySqlQuery1());
    return "wyswietlprodukty";
  }
  @RequestMapping(value = "/wyswietlproduktybezzakupu", method = RequestMethod.GET)
  public String wyswietlProduktybezzakupu(Model model) {
    model.addAttribute("Product", new Product());
    model.addAttribute("wyswietlprodukty",productRepo.findAll());
    return "wyswietlproduktybezzakupu";
  }
  @RequestMapping(value = "/wyswietlproduktyforadmin", method = RequestMethod.GET)
  public String wyswietlProduktyforadmin(Model model, Authentication auth) {
    if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
      model.addAttribute("Product", new Product());
      Platnosci test = new Platnosci();
      System.out.println(test.getDataOd());
      System.out.println(test.getDataDo());
      model.addAttribute("wyswietlprodukty",productRepo.findAll());
      return "wyswietlproduktyforadmin";
    }
   
    return "nieposiadaszuprawnien";
  }
  //@RequestMapping(value = "/wyswietlpakiety", method = RequestMethod.GET)
  //public String wyswietlPakiety(Model model) {
  //  //model.addAttribute("Package", new Package());
  //  model.addAttribute("wyswietlpakiety",packageRepo.findAll());
  //  return "wyswietlpakiety";
  //}
  @RequestMapping(value = "/wyswietlplatnosci", method = RequestMethod.GET)
  public String wyswietlPlatnosci(Model model, Authentication auth) {
    //model.addAttribute("Package", new Package());
    if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
      model.addAttribute("wyswietlplatnosci",platnosciRepo.findAll());
      return "wyswietlplatnosci";
    }
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/wyswietlmojezamowienia", method = RequestMethod.GET)
  public String wyswietlMojeZamowienia(Model model, Authentication auth) {//dokoncz wyswietlanie tranaskcji usera
    //model.addAttribute("Package", new Package());
    if(auth.getAuthorities().toString().equals("[ROLE_GOSC]")){
      model.addAttribute("wyswietlzamowieniausera",platnosciRepo.findAll());
      return "wyswietlmojezamowienia";
    }
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/wyswietlzamowienia", method = RequestMethod.GET)
  public String wyswietlZamowienia(Model model, Authentication auth) {
    //model.addAttribute("Package", new Package());
    if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
      model.addAttribute("wyswietlzamowienia",zamowieniaRepo.findAll());
      return "wyswietlzamowienia";
    }
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String stronaGlowna(Model model, Authentication auth) {
    System.out.println(auth);
    return "index";
  }
  @RequestMapping(value = "/indexforadmin", method = RequestMethod.GET)
  public String stronaGlownadlaadmina(Model model, Authentication auth) {
    if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
      return "indexforadmin";
    }
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/indexforgosc", method = RequestMethod.GET)
  public String stronaGlownadlagosc(Model model, Authentication auth) {
    return "indexforgosc";
  }
  @RequestMapping(value = "/koszyk/{id}", method = RequestMethod.GET)
  public String wyswietlkoszyk(Model model, @PathVariable("id") Integer id, HttpSession session) {
    System.out.println(productRepo.findByIdIs(id));
    koszyk.dodajdokoszyka(productRepo.findByIdIs(id));
    System.out.println(koszyk);
    model.addAttribute("wyswietlprodukty",productRepo.findByIdNotIn(productRepo.FindBySqlQuery1()));
    return "wyswietlprodukty";
  }
  @RequestMapping(value = "/zamawiam/{id}", method = RequestMethod.GET)
  public String tworzeniezamowiena(Model model, @PathVariable("id") Integer id, HttpSession session) {
    System.out.println(productRepo.findByIdIs(id));
    return "index";
  }
  @RequestMapping(value = "/finalizujkoszyk", method = RequestMethod.GET)
  public String finalizujkoszyk(Model model, HttpSession session) {
    //model.addAttribute("Test" );
    
    model.addAttribute("zawartoscKoszyka", koszyk.getZamowienie());
    //Zamowienia zamowienia = new Zamowienia();
    System.out.println(koszyk);
    //zamowienia.setPackageProductsId(packageRepo.findById(Id));
    //model.addAttribute("dodajdokoszyka", Package)
    return "finalizujkoszyk";
  }
  @RequestMapping(value = "/zlozzamowienie/{id}", method = RequestMethod.GET)
  public String dodajdozamowienia(Model model, @PathVariable("id") Integer id ,HttpSession session) {
    System.out.println("test");
    System.out.println(koszyk);
    model.addAttribute("zawartoscKoszyka", koszyk.getZamowienie());
    //List<Zamowienia> nowezamowienie = new ArrayList<Zamowienia>();
    //Zamowienia zamowienia1 = new Zamowienia();
    
    for(Product p: koszyk.getZamowienie()){
      Product product = productRepo.findByIdIs(id);
      System.out.println("testestestest");
      //nowezamowienie.add(new Zamowienia(p.getPrice(),new Person(), p.getId()));
      Zamowienia zamowienia2 = new Zamowienia(p.getPrice(), product);
      zamowieniaRepo.save(zamowienia2);//zapisanie kupionego produktu w bazie
      Platnosci platnosc1 = new Platnosci(zamowienia2.getPrice(), zamowienia2);
      platnosc1.setProduct(product);
      zamowienia2.setProduct(product);
      platnosciRepo.save(platnosc1);
      koszyk.usunZListy(p);
    }
    //zamowienia.setPackageProductsId(productRepo.findById(Id));
    //model.addAttribute("dodajdokoszyka", Product)
    return "finalizujkoszyk";
  }
  @RequestMapping(value = "/dodajprodukt", method = RequestMethod.GET)
  public String dodajprodukt(Model model, Product product, Authentication auth) {
    if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
      model.addAttribute("Product", product);
      //productRepo.save(product);
      return "dodajprodukt";
    }
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/dodajproduktdobazy", method = RequestMethod.POST)
  public String dodajproduktdobazy(Model model, Product product) {
    model.addAttribute("Product", product);
    productRepo.save(product);
    return "redirect:/dodajprodukt";
  }
  @RequestMapping(value = "/nieposiadaszuprawnien", method = RequestMethod.GET)
  public String nieposiadaszuprawnien(Model model) {
    return "nieposiadaszuprawnien";
  }
  @RequestMapping(value = "/", method = RequestMethod.GET)
    public String logincase(Model model, Authentication auth){
        if(auth == null){
            System.out.println("auth=null");
            return "index";
        }
        else if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")){
            System.out.println("auth=admin");
            return "indexforadmin";
        }
        else if(auth.getAuthorities().toString().equals("[ROLE_GOSC]")){
            System.out.println("auth=gosc");
            return "indexforgosc";
        }
        else{
            System.out.println("auth=else");
            return "index";
        }
    }
  
  

}
