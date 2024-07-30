package com.example.datacomproject.controller;

import com.example.datacomproject.model.DataComForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataComController {

    private static final Logger logger = LoggerFactory.getLogger(DataComController.class);

    @GetMapping("/data")
    public String index(Model model) {
        model.addAttribute("dataComForm", new DataComForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute DataComForm dataComForm, Model model) {
        String operation = dataComForm.getOperation();

        logger.info("Selected operation: {}", operation);
        logger.info("Input 1: {}", dataComForm.getInput1());
        logger.info("Input 2: {}", dataComForm.getInput2());

        String result = null;

        switch(operation) {
            case "Hamming Distance":
                result = calculateHammingDistance(dataComForm.getInput1(), dataComForm.getInput2());
                break;
            case "Parity Check":
                result = parityCheck(dataComForm.getInput1());
                break;
            case "Bit Stuffing":
                result = bitStuffing(dataComForm.getInput1());
                break;
            case "Bit Destuffing":
                result = bitDestuffing(dataComForm.getInput1());
                break;
            default:
                result = "Invalid operation";
        }

        dataComForm.setResult(result);
        model.addAttribute("dataComForm", dataComForm);
        return "index";
    }

    private String calculateHammingDistance(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return "Strings must be of the same length";
        }
        int distance = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }
        }
        return String.valueOf(distance);
    }

    private String parityCheck(String input) {
        int counter = 0;
        for (char c : input.toCharArray()) {
            if (c == '1') counter++;
        }
        return counter % 2 == 0 ? "Even Parity" : "Odd Parity";
    }


    private String bitStuffing(String input) {
        if (input == null) {
            return "Input cannot be null";
        }
        StringBuilder res = new StringBuilder();
        int counter = 0;
        for (char c : input.toCharArray()) {
            if (c == '1') {
                counter++;
                res.append(c);
                if (counter == 5) {
                    res.append('0');
                    counter = 0;
                }
            } else {
                res.append(c);
                counter = 0;
            }
        }
        return res.toString();
    }

    private String bitDestuffing(String input) {
        if (input == null) {
            return "Input cannot be null";
        }
        StringBuilder out = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '1') {
                counter++;
                out.append(c);
                if (counter == 5) {
                    if (i + 1 < input.length() && input.charAt(i + 1) == '0') {
                        i++;
                    }
                    counter = 0;
                }
            } else {
                out.append(c);
                counter = 0;
            }
        }
        return out.toString();
    }
}
