package com.myside.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class ErrorPageHandler implements ErrorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 에러 페이지 정의
    private final String ERROR_ETC_PAGE_PATH = "error";

    // sprigboot framework 의 경우는 /error로 에러상황이 귀결

    @GetMapping("/error")//@RequestMapping(value = "/error") //요청에 매핑해주는것 일정의 .use -> @GettMapping("/error")와 같음
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());

            logger.info("httpStatus : " + statusCode);
            // 404 error
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // 에러 페이지에 표시할 정보
                model.addAttribute("code", status.toString());
                model.addAttribute("msg", httpStatus.getReasonPhrase());
                model.addAttribute("timestamp", new Date());
            }

            // 500 error
            if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                // 서버 처리 에러
                model.addAttribute("code", "500"); //자바언어 형태로 데이터를 구조화해두고 json으로 넣어주는것
                model.addAttribute("msg", "500 error");
                model.addAttribute("timestamp", new Date());
            }
        }
        else {
            model.addAttribute("code", "unknown");
            model.addAttribute("msg", "unknown error");
            model.addAttribute("timestamp", new Date());
        }
        return ERROR_ETC_PAGE_PATH;
    }
}



//HTTP 상태코드
//100 번대 상태코드
//100 ----> 데이터의 일부를 서버가 받은 상태(처리중인 상태)
//200 번대 상태코드 : 정상적인 처리 후 응답
//200 ----> OK 에러없이 정상처리
//204 ----> 정상처리 되었으나, 서버에 보낼 데이터가 없음
//300 번대(다른 URL 처리)
//301: 요청한 URL이 새로 변경되었음.
//304: 기존의 데이터와 변경된것이 없음
//400번대
//400: 요청에 문제가 있기때문에 서버에서 인식할 수 없음
//403: 서버에서 허락되지않음
//404: 요청 URL을 찾을 수 없음
//406: 전송 방식이 허락되지 않음(REST방식에서 자주 나타나는 상태코드) ex. get으로 보내야하는데 post로 보냈다.
//500번대
//500: 서버에서 처리시 문제가 발생(프로그램 내부적인 오류)
//502: 게이트웨이, 프록시 상태의 문제(과부하)
//503: 일시적인 서비스 중단 상태
//504: 지정된 처리시간이 지나서 처리되지 못하는 경우