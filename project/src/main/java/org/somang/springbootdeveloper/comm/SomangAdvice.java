package org.somang.springbootdeveloper.comm;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SomangAdvice {


    @ExceptionHandler (SomangException.class)
    public ModelAndView goError(SomangException e){
        System.out.println("go Error " + e.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e.getMessage());
        modelAndView.setViewName("/error/error1");

        return modelAndView;
    }
}
