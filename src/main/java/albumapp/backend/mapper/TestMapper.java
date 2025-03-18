package albumapp.backend.mapper;

import albumapp.backend.domain.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("SELECT id, TestMessage FROM Tests")
    List<TestModel> findAll();
}
