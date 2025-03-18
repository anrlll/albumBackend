package albumapp.backend.domain.repository;

import albumapp.backend.domain.model.TestModel;
import albumapp.backend.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestRepository {
    private final TestMapper testMapper;

    public TestRepository(TestMapper testMapper){
        this.testMapper = testMapper;
    }

    public List<TestModel> getAllDatas() {
        return testMapper.findAll();
    }
}
