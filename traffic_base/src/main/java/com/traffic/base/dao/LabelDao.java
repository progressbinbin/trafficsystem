package com.traffic.base.dao;

import com.traffic.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by yuantousanfen on 2018/12/13.
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {
}
