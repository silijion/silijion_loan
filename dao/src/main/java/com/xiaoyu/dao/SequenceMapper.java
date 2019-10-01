package com.xiaoyu.dao;

import com.xiaoyu.domain.Sequence;

public interface SequenceMapper {
   public  Sequence queryNextSequence(Sequence sequence);
}