package xkq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xkq.entity.BugEntity;

import java.util.List;

@Mapper
@Repository
public interface BugsMapper {
    List<BugEntity> getAllBugs();
}
