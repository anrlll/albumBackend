package albumapp.backend.controller;

import albumapp.backend.domain.model.TestModel;
import albumapp.backend.usecase.TestUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiTestController {
    private final TestUsecase testUsecase;

    public ApiTestController(TestUsecase testUsecase){
        this.testUsecase = testUsecase;
    }

    @GetMapping("/test")
    public String testMessage(){
        return "Connect";
    }

    @GetMapping("/getAllDatas")
    public List<TestModel> getDatas(){
        return testUsecase.getDatas();
    }
}
