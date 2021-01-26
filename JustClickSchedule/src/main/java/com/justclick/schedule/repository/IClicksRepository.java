package com.justclick.schedule.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.justclick.schedule.entity.Clicks;

@Repository
public interface IClicksRepository extends ElasticsearchRepository<Clicks, Integer> {
	

}
