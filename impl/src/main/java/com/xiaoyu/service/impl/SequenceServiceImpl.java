package com.xiaoyu.service.impl;

import com.xiaoyu.dao.SequenceMapper;
import com.xiaoyu.domain.Sequence;
import com.xiaoyu.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart@create 2019-09-25 21:01
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public Long generateIdentity(String sequenceName) {
        Sequence sequence = new Sequence();
        sequence.setName(sequenceName);
        sequence = sequenceMapper.queryNextSequence(sequence);
        Integer currentValue = null;
        if (sequence != null){
            currentValue = sequence.getCurrentValue();
        }
        return Long.valueOf(currentValue);
    }
}
