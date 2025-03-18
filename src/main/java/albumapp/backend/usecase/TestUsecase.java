package albumapp.backend.usecase;

import albumapp.backend.domain.model.TestModel;
import albumapp.backend.service.TestService;

import java.util.List;

public class TestUsecase {
    private final TestService testService;

    public TestUsecase(TestService testService) {
        this.testService = testService;
    }

    public List<TestModel> getDatas(){
        return testService.getDatas();
    }
}
