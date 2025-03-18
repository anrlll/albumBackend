package albumapp.backend.service;

import albumapp.backend.domain.model.TestModel;
import albumapp.backend.domain.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestModel> getDatas(){
        return testRepository.getAllDatas();
    }
}
