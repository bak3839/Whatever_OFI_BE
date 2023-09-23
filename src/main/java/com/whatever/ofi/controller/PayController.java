package com.whatever.ofi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PayController {

    @PostMapping("/confirm")
    public void confirm() {

    }
}
