package xkq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.utils.FlaskInterfaceTool;

@RestController
@RequestMapping("test")
public class PythonController {
    @GetMapping("/hello")
    public String hello() {
        String url="http://127.0.0.1:8081/api/test/12345678999";
        return FlaskInterfaceTool.getResByUrl(url);
//        return "hello";
    }

    @GetMapping("/getembedding")
    public String tokens() {
        String [] tokens ={"contract","{","}"};
        String re = tokens.toString();
        String url="http://127.0.0.1:8081/embedding/solidity/"+re;
        return FlaskInterfaceTool.getResByUrl(url);
//        return "hello";
    }
}
