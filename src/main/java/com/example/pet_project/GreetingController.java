package com.example.pet_project;

import com.example.pet_project.domain.Cartrige;
import com.example.pet_project.domain.Printer;
import com.example.pet_project.repos.CartrigeRepo;
import com.example.pet_project.repos.PrinterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/wichOfEps")
    public String printerOrCartrigeEpson(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "printOrCartChoiseEpson";
    }

    @GetMapping("/wichOfCanon")
    public String printerOrCartrigeCanon(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "printOrCartChoiseCanon";
    }

    @GetMapping("/wichOfBrother")
    public String printerOrCartrigeBrother(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "printOrCartChoiseBrother";
    }

    @GetMapping("/wichOfSamsung")
    public String printerOrCartrigeSamsung(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model

    ) {
        model.put("name", name);
        return "printOrCartChoiseSamsung";
    }

    @GetMapping("/epsonsPrinters")
    public String findEpsonPrinters(Map<String, Object> model) {
        String vendor = "epson";
        Iterable<Printer> findprinters;
        findprinters = printerRepo.findByVendorContains(vendor);
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/epsonsCartriges")
    public String findEpsonCartriges(Map<String, Object> model) {
        String vendor = "epson";
        Iterable<Cartrige> findcartriges;
        findcartriges = cartrigeRepo.findByVendorContains(vendor);
        model.put("findCart", findcartriges);
        return "mainCartrige";
    }

    @GetMapping("/canonPrinters")
    public String findCan(Map<String, Object> model) {
        String vendor = "canon";
        Iterable<Printer> findprinters;
        if (vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        } else {
            findprinters = null;
        }
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/canonCartriges")
    public String findCanonCartriges(Map<String, Object> model) {
        String vendor = "canon";
        Iterable<Cartrige> findcartriges;
        findcartriges = cartrigeRepo.findByVendorContains(vendor);
        model.put("findCart", findcartriges);
        return "mainCartrige";
    }

    @GetMapping("/brotherPrinters")
    public String findBrother(Map<String, Object> model) {
        String vendor = "brother";
        Iterable<Printer> findprinters;
        if (vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        } else {
            findprinters = null;
        }
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/brotherCartriges")
    public String findBrotherCartriges(Map<String, Object> model) {
        String vendor = "brother";
        Iterable<Cartrige> findcartriges;
        findcartriges = cartrigeRepo.findByVendorContains(vendor);
        model.put("findCart", findcartriges);
        return "mainCartrige";
    }

    @GetMapping("/samsungPrinters")
    public String findSams(Map<String, Object> model) {
        String vendor = "samsung";
        Iterable<Printer> findprinters;
        if (vendor != null && !vendor.isEmpty()) {
            findprinters = printerRepo.findByVendorContains(vendor);
        } else {
            findprinters = null;
        }
        model.put("findPrinter", findprinters);
        return "mainPrinter";
    }

    @GetMapping("/samsungCartriges")
    public String findSamsungCartriges(Map<String, Object> model) {
        String vendor = "samsung";
        Iterable<Cartrige> findcartriges;
        findcartriges = cartrigeRepo.findByVendorContains(vendor);
        model.put("findCart", findcartriges);
        return "mainCartrige";
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
    }







