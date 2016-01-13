package com.fafukeji.service.impl;

import com.fafukeji.dao.RequirementsMapper;
import com.fafukeji.model.Requirements;
import com.fafukeji.service.IRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 2015/7/30 0030.
 */
@Service
public class RequirementsServiceImpl implements IRequirementsService {

        @Autowired
        private RequirementsMapper requirementsMapper;
        @Override
        public int deleteByPrimaryKey(Integer id) {
            return requirementsMapper.deleteByPrimaryKey(id);
        }

        @Override
        public int insert(com.fafukeji.model.Requirements record) {
            return requirementsMapper.insert(record);
        }

        @Override
        public int insertSelective(com.fafukeji.model.Requirements record) {
            return requirementsMapper.insertSelective(record);
        }

        @Override
        public Requirements selectByPrimaryKey(Integer id) {
            return requirementsMapper.selectByPrimaryKey(id);
        }

        @Override
        public int updateByPrimaryKeySelective(com.fafukeji.model.Requirements record) {
            return requirementsMapper.updateByPrimaryKeySelective(record);
        }

        @Override
        public int updateByPrimaryKey(Requirements record) {
            return requirementsMapper.updateByPrimaryKey(record);
        }

        @Override
        public List<Requirements> getAll() {
            return requirementsMapper.getAll();
        }

        @Override
        public List<com.fafukeji.model.Requirements> selectRequirements(com.fafukeji.model.Requirements requirements) {
            return requirementsMapper.selectRequirements(requirements);
        }

    @Override
    public List<Requirements> selectid(Requirements requirements) {
        return requirementsMapper.selectid(requirements);
    }
}


