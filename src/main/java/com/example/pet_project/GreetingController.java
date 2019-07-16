package com.example.pet_project;

import com.example.pet_project.domain.Cartrige;
import com.example.pet_project.domain.Printer;
import com.example.pet_project.domain.Vendor;
import com.example.pet_project.repos.CartrigeRepo;
import com.example.pet_project.repos.PrinterRepo;
import com.example.pet_project.repos.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class GreetingController {

    @Autowired
    private PrinterRepo printerRepo;
    @Autowired
    private CartrigeRepo cartrigeRepo;
    @Autowired
    private VendorRepo vendorRepo;

    @GetMapping("/")
    public String greeting() {

        return "main";
    }


    @GetMapping("/getDescriptionOfPrinter/{printer}")
    public String findCart(
            @PathVariable Printer printer,
            Model model
    ) {
            List<Cartrige> cartriges = printer.getCartriges();
            model.addAttribute("findCart", cartriges);
            return "mainCartrige";
        }

    @GetMapping("/getDescriptionOfCartrige/{cartrige}")
    public String findPrint(
            @PathVariable Cartrige cartrige,
            Model model
    ) {
        List<Printer> printers = cartrige.getPrinters();
        model.addAttribute("findPrinter", printers);
        return "mainPrinter";
    }

    @GetMapping("/PrinterVendors")
    public String printerVendors(Map<String, Object> model) {
        Iterable<Vendor> findVendors =vendorRepo.findAll();
        model.put("vendors", findVendors);
        return "setOfPrinterVendors";
    }
    @GetMapping("/CartrigeVendors")
    public String cartrigeVendors(Map<String, Object> model) {
        Iterable<Vendor> findVendors =vendorRepo.findAll();
        model.put("vendors", findVendors);
        return "setOfCartrigeVendors";
    }

    @GetMapping("/getPrinterByVendor/{vendor}")
    public String findPrinter(
            @PathVariable Vendor vendor,
            Model model
    ) {
        Iterable<Printer> printers = printerRepo.findByVendorContains(vendor.getName());
        model.addAttribute("findPrinter", printers);
        return "mainPrinter";
    }

    @GetMapping("/getCartrigeByVendor/{vendor}")
    public String findCartrige(
            @PathVariable Vendor vendor,
            Model model
    ) {

        Iterable<Cartrige> cartriges = cartrigeRepo.findByVendorContains(vendor.getName());
        model.addAttribute("findCart", cartriges);
        return "mainCartrige";
    }


    }







