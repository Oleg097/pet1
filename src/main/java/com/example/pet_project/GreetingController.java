package com.example.pet_project;

import com.example.pet_project.domain.Cartrige;
import com.example.pet_project.domain.Printer;
import com.example.pet_project.repos.CartrigeRepo;
import com.example.pet_project.repos.PrinterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class GreetingController {

    @Autowired
    private PrinterRepo printerRepo;
    @Autowired
    private CartrigeRepo cartrigeRepo;

   @GetMapping("/")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/wichOfEps")
    public String printerOrCartrige(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "printOrCartChoise";
    }

    @GetMapping("/epsonsPrinters")
    public String findEpsonPrinters(Map<String, Object> model ){
       String vendor = "epson";
       Iterable<Printer> findprinters;
       findprinters =printerRepo.findByVendorContains(vendor);
       model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/epsonsCartriges")
    public String findEpsonCartriges(Map<String, Object> model ){
        String vendor = "epson";
        Iterable<Cartrige> findcartriges;
        findcartriges =cartrigeRepo.findByVendorContains(vendor);
        model.put("findCart", findcartriges);
        return "mainCartrige";
    }

    @GetMapping("/canons")
    public String findCan(Map<String, Object> model ){
        String vendor = "canon";
        Iterable<Printer> findprinters;
        if(vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        }else { findprinters=null;}
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/brother")
    public String findXer(Map<String, Object> model ){
        String vendor = "brother";
        Iterable<Printer> findprinters;
        if(vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        }else { findprinters=null;}
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/samsungs")
    public String findSams(Map<String, Object> model ){
        String vendor = "samsung";
        Iterable<Printer> findprinters;
        if(vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        }else { findprinters=null;}
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }
   }




