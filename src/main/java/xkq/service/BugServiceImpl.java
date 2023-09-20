package xkq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xkq.entity.BugEntity;
import xkq.mapper.BugsMapper;

import java.util.List;

@Service
public class BugServiceImpl implements BugService {
    @Autowired
    private BugsMapper bugsMapper;
    @Override
    @Cacheable("bugs")
    public List<BugEntity> getAllBugs(){
            return bugsMapper.getAllBugs();
    }
}
