package com.example.OtpGeneration.Controller;

import com.example.OtpGeneration.BaseResponse.BaseResponse;
import com.example.OtpGeneration.DTO.CreateUserDTOs;
import com.example.OtpGeneration.DTO.LoginRequestDTO;
import com.example.OtpGeneration.DTO.MailDTO;
import com.example.OtpGeneration.Entity.Users;
import com.example.OtpGeneration.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cdk-auth-service/user")
public class AllApiController {

    @Autowired
    ApiService apiService;

    @PostMapping("/createuser")
    public BaseResponse createuser(@RequestBody CreateUserDTOs createUserDTOs) {
        Object response = apiService.createUser(createUserDTOs);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(response);
        return baseResponse;
    }


    @PostMapping("/generateotp")
    public BaseResponse generateOTP(@RequestBody MailDTO mailDTO){
        String response = apiService.generateOTP(mailDTO);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(response);
        return baseResponse;
    }


    @PostMapping("/resendotp")
    public BaseResponse resendOTP(@RequestBody MailDTO mailDTO){
        String response = apiService.resendOTP(mailDTO);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(response);
        return baseResponse;
    }


    @PostMapping("/validateotp")
    public BaseResponse validateOTP(@RequestBody LoginRequestDTO loginRequestDTO){
        String response = apiService.validateOTP(loginRequestDTO);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(response);
        return baseResponse;
    }

    @RolesAllowed(value = "user")
    @GetMapping("/summa")
    public  String summa(){
        return "summa with USER";
    }

}