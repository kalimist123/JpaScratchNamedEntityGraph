package com.example.demo.repositories;


import com.example.demo.models.Customer;
import com.example.demo.models.Post;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @NotNull
    @EntityGraph(value = "post-entity-graph")
    @Override
    List<Post> findAll();
}


